package net.zoogon.webcheck.server;

public class ProxyServlet extends HttpServlet {

    /**
     * 
     */
    private static final long   serialVersionUID        = 8L;

    private static final String targetServer            = "localhost";
    private static final int    targetPort                      = 80;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("GET NOT implemented!");
        resp.sendError(HttpStatus.ORDINAL_501_Not_Implemented);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        handleRequest(req, res);
    }

    @SuppressWarnings("unchecked")
    protected void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final StringBuffer file = new StringBuffer();

        file.append(req.getRequestURI());
        if (req.getQueryString() != null) {
                file.append("?" + req.getQueryString());
        }

        HttpURLConnection conn = (HttpURLConnection) new URL("http", targetServer, targetPort, file.toString()).openConnection();

        conn.setRequestMethod("POST");

        // copy header
        // copy headers
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
                String name = (String) headerNames.nextElement();
                String value = req.getHeader(name);

                value = value.replace(":8080", ":80");

                conn.addRequestProperty(name, value);
        }

        conn.setDoOutput(true);

        try {
                OutputStream out = conn.getOutputStream();
                fastStreamcopy(req.getInputStream(), out);
        } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Server down");
                return;
        }

        try {
                int code = conn.getResponseCode();
                String msg = conn.getResponseMessage();

                System.out.println("code: " + code + ", msg: " + msg);
                resp.setStatus(code, msg);
                Map<String, List<String>> headerFields = conn.getHeaderFields();

                for (Map.Entry<String, List<String>> e : headerFields.entrySet()) {
                        for (String val : e.getValue()) {
                                if (e.getKey() != null)
                                        resp.addHeader(e.getKey(), val);
                        }
                }

                // Try normal stream, then error stream and accept if remote host says that there is no content.
                try {
                        fastStreamcopy(conn.getInputStream(), resp.getOutputStream());
                } catch (IOException e) {
                        try {
                                fastStreamcopy(conn.getErrorStream(), resp.getOutputStream());
                        } catch (Exception e1) {
                                if (conn.getContentLength() == 0) {
                                        // That ok - nothing there
                                } else {
                                        throw e;
                                }

                        }
                }
        } catch (IOException e) {
                System.err.println(e.getMessage());
                throw e;
        }

    }

    public static void fastStreamcopy(InputStream input, OutputStream output) throws IOException {
        final ReadableByteChannel inputChannel = Channels.newChannel(input);
        final WritableByteChannel outputChannel = Channels.newChannel(output);
        // copy the channels
        fastChannelCopy(inputChannel, outputChannel);
    }

    public static void fastChannelCopy(final ReadableByteChannel src, final WritableByteChannel dest) throws IOException {
        final ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(buffer) != -1) {
                // prepare the buffer to be drained
                buffer.flip();
                // write to the channel, may block
                dest.write(buffer);
                // If partial transfer, shift remainder down
                // If buffer is empty, same as doing clear()
                buffer.compact();
        }
        // EOF will leave buffer in fill state
        buffer.flip();
        // make sure the buffer is fully drained.
        while (buffer.hasRemaining()) {
                dest.write(buffer);
        }
    }
}