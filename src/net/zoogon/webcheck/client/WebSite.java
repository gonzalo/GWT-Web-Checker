package net.zoogon.webcheck.client;

public class WebSite {
	
	private static final int NOT_CHECKED = -1;
	private static final int WEBSITE_UP = 0;
	private static final int FAILED_TO_FETCH = 1;
	private static final int BAD_FORMED_URL = 2;
	
	private static final String DEFAULT_URL = "http://www.google.com";
	
	
	private String url;
	private int status;	
	
	public WebSite(){
		this.setUrl(DEFAULT_URL);
		this.setStatus(NOT_CHECKED);
	}
	
	public WebSite(String url){
		
		//¿Debería comprobar aquí mismo la validez de la cadena?
		
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
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	private void setStatus(int status) {
		status = status;
	}

	
	

}
