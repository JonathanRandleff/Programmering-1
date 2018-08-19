package OU2;


public class Triangel {

	public static void main(String[] args) {
		System.out.println(area(5,2));
		System.out.println(omkrets(3,2,8));
		System.out.println("Radien av den omskrivna cirkeln är: " + radieOmskriven(5, 5, 5));
		System.out.println("Radien av den inskrivna cirkeln är: " + radieInskriven(5, 5, 5));
	}
	// Metod som räknar ut area
	public static double area(double b, double h) {
		double ar = (b*h)/2;
		return ar;
	}
	// Metod som räknar ut omkrets
	public static double omkrets(double a, double b, double c) {
		double omkr = a+b+c;
		return omkr;
	}
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
}
