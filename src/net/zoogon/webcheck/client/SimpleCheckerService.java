package net.zoogon.webcheck.client;


import net.zoogon.webcheck.shared.WebSite;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("simpleChecker")
public interface SimpleCheckerService extends RemoteService {

  public WebSite simpleWebCheck(String url);
}