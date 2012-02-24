package net.zoogon.webcheck.server;

import net.zoogon.webcheck.client.WebSite;
import net.zoogon.webcheck.client.SimpleCheckerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SimpleCheckerServiceImpl extends RemoteServiceServlet implements SimpleCheckerService {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String simpleWebCheck(String url) {
    // TODO Auto-generated method stub
    return "todoOK";
  }

}
