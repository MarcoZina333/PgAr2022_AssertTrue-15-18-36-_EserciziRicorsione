package it.unibs.progettoArnaldo.calcolatrice;

import it.unibs.progettoArnaldo.util.Utility;

public class Operazione {
	
	public Operazione nonno;
	public String padre;
	public Operazione figlioSX;
	public Operazione figlioDX;
	public Operazione(Operazione nonno, String padre, Operazione figlioSX, Operazione figlioDX) {
		if (nonno != null ) {
			if (nonno.getFiglioSX() == null) {
				nonno.setFiglioSX(this);
			}
			else if (nonno.getFiglioDX() == null) {
				nonno.setFiglioDX(this);
			}
		}
		this.nonno = nonno;
		this.padre = padre.trim();
		this.figlioSX = figlioSX;
		if (figlioSX != null)
			figlioSX.setNonno(this);
		this.figlioDX = figlioDX;
		if (figlioDX != null)
			figlioDX.setNonno(this);
	}
	
	public Operazione(String principale) {
		this.nonno = null;
		this.padre = principale.trim();
		this.figlioSX = null;
		this.figlioDX = null;
	}
	
	public Operazione(String padre, Operazione figlioSX, Operazione figlioDX) {
		this.nonno = null;
		this.padre = padre.trim();
		this.figlioSX = figlioSX;
		this.figlioDX = figlioDX;
	}
	
	public Operazione() {
		this.nonno = null;
		this.padre = null;
		this.figlioSX = null;
		this.figlioDX = null;
	}
	
	public Operazione getNonno() {
		return nonno;
	}

	public void setNonno(Operazione nonno) {
		this.nonno = nonno;
	}

	public String getPadre() {
		return padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
	}

	public Operazione getFiglioSX() {
		return figlioSX;
	}

	public void setFiglioSX(Operazione figlioSX) {
		this.figlioSX = figlioSX;
	}

	public Operazione getFiglioDX() {
		return figlioDX;
	}

	public void setFiglioDX(Operazione figlioDX) {
		this.figlioDX = figlioDX;
	}

	public Double getRisultato() {
		if (Utility.isNumeric(padre))
			return Double.parseDouble(padre);
		else if (Utility.isOperatore(padre)) {
			Double risSX = figlioSX.getRisultato();
			Double risDX = figlioDX.getRisultato();
			if (risSX != null && risDX != null) {
				switch (padre.charAt(0)) {
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
