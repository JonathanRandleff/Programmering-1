package OU3;

public class DenKortasteVagen {
    //metoder
    //en metod för algoritm, anropa med de tre olika parametersekvenserna?
    public static double[] mellanstationer (double[] a, double[][] b, double[] c)
    {
        int n = 4;
        double min1 = a[0];
        double min2 = b[0][0];
        double min3 = c[0];
        double [] stat = new double [n];
        for (int i = 0; i<3; i++)
        {
            if (a[i]<min1)
                min1 = a[i];
            if (min1 == a[i])
                System.out.print ("Kortaste vägen är först mellan station X och U" + (i+1) + ". ");
            for (int j = 0; j<4; j++)
            {
                if (b[i][j]<min2)
                    min2 = b[i][j];
                if (min2 == b[i][j])
                    System.out.print("Den kortaste vägen från andra stationen är till V" + (i+j+1) + " och därefter till station Y.");
                if (c[j]<min3)
                    min3 = c[j];
            }
        }
        stat [0] = min1;
        stat [1] = min2;
        stat [2] = min3;
        return stat;
    }

    public static double langd (double[] a, double[][] b, double[] c)
    {
        int n = 12;
        double [] längder = new double [n];
        for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<4; j++)
            {
                int temp =+ j + (4*i);
                double aa = a[i];
                double bb = b[i][j];
                double cc = c[j];
                double totalLängd = aa+bb+cc;
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
