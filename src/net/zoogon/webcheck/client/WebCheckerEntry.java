package net.zoogon.webcheck.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class WebCheckerEntry implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		SimpleCheckerWidget simplechecker = 
				new SimpleCheckerWidget("http://www.google.com");
        RootPanel.get("WebApp").add(simplechecker);

		

	}

}
