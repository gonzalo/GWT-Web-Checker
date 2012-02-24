package net.zoogon.webcheck.shared;

import com.google.gwt.regexp.shared.RegExp;

public class SharedMethods {
	
	//aunque esta validación se podría realizar directamente en el cliente
	//prefiero hacerla aquí por si quiero modificar los criterios de validación
	//además sirve como prueba de una clase compartida entre cliente y servidor
	
	
	/**
	 * isWellFormed check through regular expressions if a string is a correct url
	 * @param url
	 * @return true or false
	 */
	public static boolean isWellFormed (String url){
		return isValidUrl(url, true);
	}
	
	/**
	 * ref: http://stackoverflow.com/questions/4498225/gwt-java-url-validator
	 * @param url 
	 * @param topLevelDomainRequired
	 * @return 
	 */
	private static boolean isValidUrl(String url, boolean topLevelDomainRequired) {
		RegExp urlValidator = RegExp.compile("^((ftp|http|https)://[\\w@.\\-\\_]+(:\\d{1,5})?(/[\\w#!:.?+=&%@!\\_\\-/]+)*){1}$");
		RegExp urlPlusTldValidator = RegExp.compile("^((ftp|http|https)://[\\w@.\\-\\_]+\\.[a-zA-Z]{2,}(:\\d{1,5})?(/[\\w#!:.?+=&%@!\\_\\-/]+)*){1}$");
		
	    return (topLevelDomainRequired ? urlPlusTldValidator : urlValidator).exec(url) != null;
	}

}
