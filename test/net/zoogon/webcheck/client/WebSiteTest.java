package net.zoogon.webcheck.client;

import com.google.gwt.junit.client.GWTTestCase;;

public class WebSiteTest extends GWTTestCase {
	
	
	/**
	 * Must refer to a valid module that sources this class.
	 */
	public String getModuleName() {
		return "net.zoogon.webcheck.Web_Checker";
	}

	
	public void testConstructor(){

		WebSite testWebSite = new WebSite();
		assertEquals("http://www.google.com", testWebSite.getUrl());
		assertEquals(WebSite.NOT_CHECKED, testWebSite.getStatus());

		testWebSite = new WebSite("http://www.testurl.com");
		assertEquals("http://www.testurl.com", testWebSite.getUrl());
		assertEquals(WebSite.NOT_CHECKED, testWebSite.getStatus());
	}

	public void testSetUrl(){

		WebSite testWebSite = new WebSite();
		testWebSite.setUrl("http://www.testurl.com");
		assertEquals("http://www.testurl.com", testWebSite.getUrl());
		assertEquals(WebSite.NOT_CHECKED, testWebSite.getStatus());

	}
	
	
}
