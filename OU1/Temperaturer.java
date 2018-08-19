package OU1;

import java.util.*; // Scanner, Locale

public class Temperaturer {
    public static void main(String[] args) {
        {
            System.out.println("TEMPERATURER\n");

            // inmatningsverktyg
            Scanner in = new Scanner(System.in);
            in.useLocale(Locale.US);

            // mata in uppgifter om antalet veckor och antalet mätningar
            System.out.print("antalet veckor: ");
            int antalVeckor = in.nextInt();
            System.out.print("antalet mätningar per vecka: ");
            int antalMatningarPerVecka = in.nextInt();

            // plats att lagra temperaturer
            double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

            // mata in temperaturerna
            for (int vecka = 1; vecka <= antalVeckor; vecka++) {
                System.out.println("temperaturer - vecka " + vecka + ":");
                for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                    t[vecka][matning] = in.nextDouble();
            }
            System.out.println();

            // visa temperaturerna
            System.out.println("temperaturerna:");
            for (int vecka = 1; vecka <= antalVeckor; vecka++) {
                for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                    System.out.print(t[vecka][matning] + " ");
                System.out.println();
            }
            System.out.println();

            // den minsta, den största och medeltemperaturen  veckovis
            double[] minT = new double[antalVeckor + 1];
            double[] maxT = new double[antalVeckor + 1];
            double[] sumT = new double[antalVeckor + 1];
            double[] medelT = new double[antalVeckor + 1];

            // Räknar ut minsta, högsta, summan och medel av temperaturerna veckovis
            for (int vecka = 1; vecka <= antalVeckor; vecka++) {
                minT[vecka] = t[vecka][1];
                maxT[vecka] = t[vecka][1];
                for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
                    sumT[vecka] += (t[vecka][matning]);
                    if (t[vecka][matning] > maxT[vecka]) {
                        maxT[vecka] = t[vecka][matning];
                    }
                    if (t[vecka][matning] < minT[vecka]) {
                        minT[vecka] = t[vecka][matning];
                    }
                }
                medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;
            }

            // visa den minsta, den största och medeltemperaturen för varje vecka
            for (int vecka = 1; vecka <= antalVeckor; vecka++) {
                System.out.println("Vecka: " + vecka);
                System.out.println("Min: " + minT[vecka]);
                System.out.println("Max: " + maxT[vecka]);
                System.out.println("Medel: " + medelT[vecka]);
                System.out.println();
            }

            // den minsta, den största och medeltemperaturen - hela mätperioden
            double minTemp = minT[1];
            double maxTemp = maxT[1];
            double sumTemp = 0;
            double medelTemp = 0;

            // Beräknar minsta, högsta, summan och medeltemperaturerna
            for (int vecka = 1; vecka <= antalVeckor; vecka++) {
                if (minT[vecka] < minTemp) {
                    minTemp = minT[vecka];
                }
                if (maxT[vecka] > maxTemp) {
                    maxTemp = maxT[vecka];
                }
                sumTemp += sumT[vecka];
            }
            medelTemp = sumTemp / (antalMatningarPerVecka * antalVeckor);

            // visa den minsta, den största och medeltemperaturen i hela mätperioden
            System.out.println("Hela perioden: ");
            System.out.println("minTemp: " + minTemp);
            System.out.println("maxTemp: " + maxTemp);
            System.out.println("medelTemp: " + medelTemp);
        }
    }
}