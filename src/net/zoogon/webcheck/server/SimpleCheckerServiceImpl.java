package net.zoogon.webcheck.server;

import net.zoogon.webcheck.client.SimpleCheckerService;
import net.zoogon.webcheck.shared.WebSite;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SimpleCheckerServiceImpl extends RemoteServiceServlet implements SimpleCheckerService {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public WebSite simpleWebCheck(String url) {
    
	WebSite webToCheck = new WebSite(url);
	
	webToCheck.checkWebSite();
	return webToCheck;
  }

}
