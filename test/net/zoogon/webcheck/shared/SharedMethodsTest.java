package net.zoogon.webcheck.shared;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * @author gonzalo
 * 
 */
public class SharedMethodsTest extends GWTTestCase {


	/**
	 * Must refer to a valid module that sources this class.
	 */
	public String getModuleName() {
		return "net.zoogon.webcheck.Web_Checker";
	}

	/**
	 * Testing badformed urls
	 */
	public void testIsWellFormed_badfUrls() {
		
		assertFalse(SharedMethods.isWellFormed("dhtp://www.google.com"));
		assertFalse(SharedMethods.isWellFormed("dhtp://www.google.com"));
		assertFalse(SharedMethods.isWellFormed("ftps://www.google.com"));
		assertFalse(SharedMethods.isWellFormed("mailto://www.google.com"));
		assertFalse(SharedMethods.isWellFormed("google"));
		assertFalse(SharedMethods.isWellFormed("google.com"));
		assertFalse(SharedMethods.isWellFormed("www.google.com"));
		
		
	}

	/**
	 * Testing correct urls
	 */
	public void testIsWellFormed_correctUrls() {
		
		assertTrue(SharedMethods.isWellFormed("http://www.google.com"));
		assertTrue(SharedMethods.isWellFormed("http://google.com"));
		assertTrue(SharedMethods.isWellFormed("https://www.google.com"));
		assertTrue(SharedMethods.isWellFormed("http://www.google.es"));
		assertTrue(SharedMethods.isWellFormed("ftp://www.google.com"));
		assertTrue(SharedMethods.isWellFormed("http://172.186.85.72"));
		assertTrue(SharedMethods.isWellFormed("http://172.186.85.72:88/home"));


	}
}
