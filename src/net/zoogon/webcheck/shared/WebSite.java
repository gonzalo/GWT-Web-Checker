package net.zoogon.webcheck.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WebSite implements Serializable{
	
	public static final int NOT_CHECKED = -1;
	public static final int WEBSITE_UP = 0;
	public static final int FAILED_TO_FETCH = 1;
	public static final int BAD_FORMED_URL = 2;
	
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
		this.setStatus(NOT_CHECKED);
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
	private void setStatus(int inputStatus) {
		status = inputStatus;
	}

	
	

}
