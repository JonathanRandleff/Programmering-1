package OU3;

import java.util.Locale;
import java.util.Scanner;


public class BestamDenKortasteVagen extends DenKortasteVagen {

    //inmatningar och metodanrop

    public static void main(String[] args) {
        //inmatningsverktyg
        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);

        //matar in längder mellan station X och Z1
        int n = 3;
        double [] avståndXZ1 = new double [n];
        for (int i = 0; i<n; i++)
        {
            System.out.print ("Avstånd mellan X och U" + (i+1) + ": ");
            avståndXZ1[i] = in.nextDouble();
        }

        //matar in längder mellan station Z2 och Z3
        int m = 4;
        double [][] avståndZ1Z2 = new double [n][m];
        for (int i = 0; i<n; i++)
        {
            for (int j = 0; j<m; j++)
            {
                System.out.print("Avstånd mellan U" + (i+1) + " och V" + (j+1) + ": ");
                avståndZ1Z2[i][j] = in.nextDouble();
            }

        }

        //matar in längder mellan station Z3 och Y
        double [] avståndZ3Z4 = new double [m];
        for (int w = 0; w<m; w++)
        {
            System.out.print ("Avstånd mellan V" + (w+1) + " och Y: ");
            avståndZ3Z4[w] = in.nextDouble();
        }


        //anrop!
        double [] stationer = mellanstationer (avståndXZ1, avståndZ1Z2, avståndZ3Z4);
        System.out.println();
        System.out.print ("Längden mellan de olika stationerna är: ");
        for (int i = 0; i <3; i++)
        {
            System.out.print (" " + stationer[i]+ " ");
        }
        System.out.println();



        double längd = langd (avståndXZ1, avståndZ1Z2, avståndZ3Z4);
        System.out.print ("Den kortaste vägen är: " + längd);


    }

}
