package net.zoogon.webcheck.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SimpleCheckerServiceAsync {

	void simpleWebCheck(String url, AsyncCallback<String> callback);

}
