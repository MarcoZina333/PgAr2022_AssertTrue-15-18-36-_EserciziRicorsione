package it.unibs.progettoArnaldo.calcolatrice;

import it.unibs.progettoArnaldo.util.InputDati;

public class MainCalc {

	public static void main(String[] args) {
		System.out.println(Espressione.Parsing.isEspressioneValida(InputDati.leggiStringaNonVuota("Inserisci l'espressione: ")));

	}

}
