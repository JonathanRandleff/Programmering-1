package OU3;

import java.util.Locale;
import java.util.Scanner;

public class BestamDenKortasteVagen extends DenKortasteVagen {

    public static void main(String[] args) {
        /**
         * Skapar inmatningsverktyg
         */
        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);

        /**
         * Inmatning av längder mellan X-stationen och U-stationerna.
         */
        int n = 3;
        double [] XtoZ = new double [n];
        for (int i = 0; i<n; i++) {
            System.out.print ("Avståndet mellan stationerna X och U" + (i+1) + ": ");
            XtoZ[i] = in.nextDouble();
        }

        /**
         * Inmatning av längder mellan U-stationerna och V-stationerna.
         */
        int m = 4;
        double [][] UtoV = new double [n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                System.out.print("Avståndet mellan stationerna U" + (i+1) + " och V" + (j+1) + ": ");
                UtoV[i][j] = in.nextDouble();
            }
        }

        /**
         * Inmatning av längder mellan V-stationerna och Y.
         */
        double [] VtoY = new double [m];
        for (int w = 0; w<m; w++) {
            System.out.print ("Avståndet mellan stationerna V" + (w+1) + " och Y: ");
            VtoY[w] = in.nextDouble();
        }

        /**
         *
         */
        int [] stationer = mellanstationer (XtoZ, UtoV, VtoY);
        System.out.println ("Snabbaste resväg är X - U" + stationer[0] + " - V" + stationer[1] + " - Y" );

        /**
         * Anropar metod som skriver ut längderna mellan alla de olika stationerna.
         * Skriver ut den kortaste vägen mellan X och Y
         */
        System.out.println ("Den kortaste vägen är: " + langd (XtoZ, UtoV, VtoY));
    }
}
