package net.zoogon.webcheck.shared;

import java.io.Serializable;
import com.google.gwt.http.client.*;



/**
 * @author gonzalo
 * 
 */
@SuppressWarnings("serial")
public class WebSite implements Serializable {

	public static final int NOT_CHECKED = -1;
	public static final int WEBSITE_UP = 0;
	public static final int FAILED_TO_FETCH = 1;
	public static final int BAD_FORMED_URL = 2;

	private static final String DEFAULT_URL = "http://www.google.com";

	private String url;
	private int status;
	private String webSiteContent;

	public WebSite() {
		this.setUrl(DEFAULT_URL);
		this.setStatus(NOT_CHECKED);
	}

	public WebSite(String url) {

		// ¿Debería comprobar aquí mismo la validez de la cadena?

		this.setUrl(url);
		this.setStatus(NOT_CHECKED);
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
		this.setStatus(NOT_CHECKED);
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	private void setStatus(int inputStatus) {
		status = inputStatus;
	}

	public boolean checkWebSite(){
		try {

			//primero chequeamos si la url está correcta
			if (SharedMethods.isWellFormed(url)){
				webSiteContent = doHttpUrlConnectionAction(url);
				status = WEBSITE_UP; 
				return true;
			} else {
				status = BAD_FORMED_URL;
				return false;
			}
		} catch (Exception e){
		      status = FAILED_TO_FETCH;
		      e.printStackTrace();
		      return false;
		}
	}

	/**
	 * Returns the output from the given URL.
	 * 
	 * I tried to hide some of the ugliness of the exception-handling in this
	 * method, and just return a high level Exception from here. Modify this
	 * behavior as desired.
	 * 
	 * @param desiredUrl
	 * @return
	 * @throws Exception
	 */
	private String doHttpUrlConnectionAction(String desiredUrl)
	throws Exception {

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(desiredUrl));
		
		try {
			  Request request = builder.sendRequest(null, new RequestCallback() {
			    public void onError(Request request, Throwable exception) {
			       // Couldn't connect to server (could be timeout, SOP violation, etc.)     
			    }

			    public void onResponseReceived(Request request, Response response) {
			      if (200 == response.getStatusCode()) {
			          // Process the response in response.getText()
			    	  
			      } else {
			        // Handle the error.  Can get the status text from response.getStatusText()
			      }
			    }       
			  });
			} catch (RequestException e) {
			  // Couldn't connect to server        
			}
		return "jejej";

	}
}
