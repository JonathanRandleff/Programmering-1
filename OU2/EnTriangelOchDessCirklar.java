package OU2;
import java.util.*; // Scanner, Locale

public class EnTriangelOchDessCirklar {

	public static void main(String[] args) {
		// inmatningsverktyg
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);

		// Frågar om triangels 3 längdvärden och sparar dem som double
		System.out.println("Ange triangelns första sidas längd:");
		double a = in.nextDouble ();
		System.out.println("Ange triangelns andra sidas längd:");
		double b = in.nextDouble ();
		System.out.println("Ange triangelns tredje sidas längd:");
		double c = in.nextDouble ();

		// Skriver ut radie via metoderna
		System.out.println("Radien av den omskrivna cirkeln är: " + Triangel.radieOmskriven(a, b, c));
		System.out.println("Radien av den inskrivna cirkeln är: " + Triangel.radieInskriven(a, b, c));

	}
	/*
	// Metod som räknar ut radien på en omskriven cirkel
	public static double radieOmskriven(double a, double b, double c) {
		double s = (a+b+c)/2;
		double radieOm = (a*b*c) / (4*Math.sqrt(s*(s-a)*(s-b)*(s-c)));
		return radieOm;
	}
	// Metod som räknar ut radien på en inskriven cirkel
	public static double radieInskriven(double a, double b, double c) {
		double s = (a+b+c)/2;
		double x = (s-a)*(s-b)*(s-c);
		double radieIn = Math.sqrt(x/s);
		return radieIn;
	}
	*/
}
