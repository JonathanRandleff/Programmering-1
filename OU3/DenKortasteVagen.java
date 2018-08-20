package OU3;

public class DenKortasteVagen {

    /**
     * En metod som räknar ut den kortaste vägen och returnerar vilka mellanstationer som ger denna väg
     * @param a Stationerna vid sträckan X - U
     * @param b Stationerna vid sträckan U - V
     * @param c Stationerna vid sträckan V - Y
     * @return En array med de mellanstationer på den kortaste vägen
     */
    public static int[] mellanstationer (double[] a, double[][] b, double[] c) {
        double tempo = 1000000;
        int [] kortastVag = new int [2];
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<4; j++) {
                double xu = a[i];
                double uv = b[i][j];
                double vy = c[j];
                double totalLängd = xu+uv+vy;
                if (totalLängd < tempo) {
                    kortastVag[0] = i+1;
                    kortastVag[1] = j+1;
                    tempo = totalLängd;
                }
            }
        }
        return kortastVag;
    }

    /**
     * Räknar ut längden för den kortaste vägen.
     * @param a Stationerna vid sträckan X - U
     * @param b Stationerna vid sträckan U - V
     * @param c Stationerna vid sträckan V - Y
     * @return Längden mellan X och Y med den kortaste vägen.
     */
    public static double langd (double[] a, double[][] b, double[] c)
    {
        int n = 12;
        double [] längder = new double [n];
        for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<4; j++)
            {
                int temp =+ j + (4*i);
                double xu = a[i];
                double uv = b[i][j];
                double vy = c[j];
                double totalLängd = xu+uv+vy;
                System.out.println ("Längd för X, U" + (i+1) + ", V" + (j+1) + ", Y: " + totalLängd);
                längder[temp] = totalLängd;
            }
        }
        int forst = 0;
        int sist = längder.length -1;
        int minst = forst;
        int aktuell = forst +1;
        while (aktuell <= sist)
        {
            if (längder[aktuell]<längder[minst])
                minst = aktuell;
            aktuell++;
        }
        return längder[minst];
    }
}
