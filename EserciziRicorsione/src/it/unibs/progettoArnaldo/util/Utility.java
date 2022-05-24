package it.unibs.progettoArnaldo.util;

public class Utility {
	public static final String OPERAZIONI_VALIDE = "+-*/";
	
	public static boolean isNumeric (String str) {
		try{
			Double.parseDouble(str);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean isOperatore(String c) { 
		if (c == null || c.length() == 0 || c.length() > 1)
			return false;
		return OPERAZIONI_VALIDE.indexOf(Character.toUpperCase(c.charAt(0))) != -1;
	}
}
