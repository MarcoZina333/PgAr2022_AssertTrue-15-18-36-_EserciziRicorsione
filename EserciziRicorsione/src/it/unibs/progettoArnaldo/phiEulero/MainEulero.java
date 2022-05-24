package it.unibs.progettoArnaldo.phiEulero;

import it.unibs.progettoArnaldo.util.InputDati;

public class MainEulero {

	public static void main(String[] args) {
		int n = InputDati.leggiIntero("Inserisci il valore di cui vuoi calcolare la phi di Eulero: ");
		try {
			//System.out.println(mcdEuclide(11, 12));
			//System.out.println(isInteger(n));
			System.out.println(phiEuleroIter(n));
			System.out.println(phiEulero(n));
			//System.out.println(Math.pow(16, 1.0/4));
			
		}catch (Exception e) {
			System.out.println("Attenzione! Inserito numero negativo per la ricerca della phi di Eulero");
		}
	}

	public static int phiEuleroIter (int n) throws IllegalArgumentException{
		if (n < 0)
			throw new IllegalArgumentException();
		else if (n == 1) {
			return 1;
		}
		else {
			int count = 1;
			for (int i=2; i < n;i++) {
				if (sonoCoprimi(n, i)) count++;
			}
			return count;
		}
	}
	
	public static int phiEulero (int n) throws IllegalArgumentException{
		if (n < 0)
			throw new IllegalArgumentException();
		else if (n == 1) {
			return 1;
		}
		else {
			boolean primo = true;
			for (int i = 2; i <= n/2;i++) {
				double p = Math.pow(n, 1.0/i);
				if (isInteger(p) && isPrimo(Math.round(p))) {
					return (int)Math.round((p-1)*Math.pow(p, i-1));
				}
				else if (n%i == 0) {
					primo = false;
					if (sonoCoprimi(n/i, i))
						return phiEulero(i)*phiEulero(n/i);
				}
				
			}
			if (primo) return n-1;
			
		}
		return -1;
	}
	
	public static int mcdEuclide(int a, int b) {
		if (b == 0) {
			return a;
		}
		else {
			int r = a % b;
			if (r == 0) {
				return b;
			}
			else return mcdEuclide(b, r);
		}
	}	
	
	public static boolean sonoCoprimi(int a, int b) {
		return Math.abs(mcdEuclide(a,b)) == 1;
	}
	
	public static boolean isPrimo(int n) {
		for (int i=2; i <= n/2;i++)
			if (n % i == 0)
				return false;
		return true;
	}
	
	public static boolean isPrimo(long n) {
		for (int i=2; i <= n/2;i++)
			if (n % i == 0)
				return false;
		return true;
	}
	
	public static boolean equals(double a, double b) {
		final double EPSILON = 0.00001;
		return Math.abs(a-b) < EPSILON;
	}
	
	public static boolean isInteger(double a) {
		final double EPSILON = 0.00001;
		return Math.abs(Math.round(a) - a) < EPSILON;
	}
	
	
}
