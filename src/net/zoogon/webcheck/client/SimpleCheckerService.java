package net.zoogon.webcheck.client;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("simpleChecker")
public interface SimpleCheckerService extends RemoteService {

  public String simpleWebCheck(String url);
}