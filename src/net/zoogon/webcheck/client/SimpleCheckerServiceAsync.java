package net.zoogon.webcheck.client;

import net.zoogon.webcheck.shared.WebSite;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SimpleCheckerServiceAsync {

	void simpleWebCheck(String url, AsyncCallback<WebSite> callback);

}
