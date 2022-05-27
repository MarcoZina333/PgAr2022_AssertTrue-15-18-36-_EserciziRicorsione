package it.unibs.progettoArnaldo.calcolatrice;

import it.unibs.progettoArnaldo.util.Utility;

public class Espressione {
	public Operazione radice;

	public Espressione(Operazione radice) {
		this.radice = radice;
	}
	
	public Espressione(String radice, Operazione figlioSX, Operazione figlioDX) {
		this.radice = new Operazione(radice, figlioSX, figlioDX);
	}
	
	public Double getRisultato() {
		return radice.getRisultato();
	}
	
	public static class Parsing{
		enum Stato{
			OPERATORE, NUMERO, PARENTESI_A, PARENTESI_C, VIRGOLA;
		}
		
		static Operazione toNotazionePolaccaInv(String espressione) {
			if (!isEspressioneValida(espressione))
				return null;
			Operazione padre = null, figlioSX = null, figlioDX = null;
			char[] exp = espressione.toCharArray();
			int inizioParentesi;
			for (int i = 0; i < exp.length; i++) {
				if (exp[i] == '(') {
					inizioParentesi = i+1;
				}
				if (exp[i] == '(') {
					inizioParentesi = i+1;
				} 
			}
			return null;
		}
		
		static boolean isEspressioneValida(String espressione) {
			char[] exp = espressione.toCharArray();
			Stato s = null;
			int parentesiAperte = 0;
			for (int i = 0; i < exp.length;i++) {
				if (s != null) {
					switch (s) {
						case OPERATORE:
							if (exp[i] == ')')
								return false;
							break;
						case NUMERO:
							if (exp[i] == '(')
								return false;
							break;
						case PARENTESI_A:
							if (Utility.isOperatore(""+exp[i]) || exp[i] == ')')
								return false;
							break;
						case PARENTESI_C:
							if (Utility.isNumeric(""+exp[i]))
								return false;
							break;
						case VIRGOLA:
							if (i ==1 || !Utility.isNumeric(""+exp[i]) || !Utility.isNumeric(""+exp[i-2])) 
								return false;
							break;
					}
				}
				
				if (Utility.isOperatore(""+exp[i])) {
					s = Stato.OPERATORE;
				}
				else if (Utility.isNumeric(""+exp[i])) {
					s = Stato.NUMERO;
					
				}
				else if (exp[i] == ','){
					if (i == exp.length-1) return false;
					s = Stato.VIRGOLA;
					}
				else if (exp[i] == '(') {
					s = Stato.PARENTESI_A;
					parentesiAperte++;
				}
				else if (exp[i] == ')') {
					s = Stato.PARENTESI_C;
					parentesiAperte--;
				}
				else if (exp[i] == ' ' || exp[i] == '\n') {}
				else return false;
			}
			return parentesiAperte == 0;
		}
	}
}
