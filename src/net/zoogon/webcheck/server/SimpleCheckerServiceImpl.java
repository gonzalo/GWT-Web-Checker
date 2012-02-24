package net.zoogon.webcheck.server;

import net.zoogon.webcheck.client.WebSite;
import net.zoogon.webcheck.client.SimpleCheckerService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SimpleCheckerServiceImpl extends RemoteServiceServlet implements SimpleCheckerService {

  public WebSite getStatus(String url) {
    // TODO Auto-generated method stub
    return null;
  }

}
