package it.unibs.progettoArnaldo.calcolatrice;

import it.unibs.progettoArnaldo.util.Utility;

public class Operazione {
	
	public String principale;
	public Operazione secondariaSX;
	public Operazione secondariaDX;
	public Operazione(String principale, Operazione secondariaSX, Operazione secondariaDX) {
		this.principale = principale.trim();
		this.secondariaSX = secondariaSX;
		this.secondariaDX = secondariaDX;
	}
	
	public Operazione(String principale) {
		this.principale = principale.trim();
		this.secondariaSX = null;
		this.secondariaDX = null;
	}
	
	public Double getRisultato() {
		if (Utility.isNumeric(principale))
			return Double.parseDouble(principale);
		else if (Utility.isOperatore(principale)) {
			Double risSX = secondariaSX.getRisultato();
			Double risDX = secondariaDX.getRisultato();
			if (risSX != null && risDX != null) {
				switch (principale.charAt(0)) {
					case '+':
						return risSX + risDX;
					case '-':
						return risSX - risDX;
					case '*':
						return risSX * risDX;
					case '/':
						return risSX / risDX;
				}
			}
			
		}
		return null;
	}
}
