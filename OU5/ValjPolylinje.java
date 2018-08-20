package OU5;

import java.util.Random;

class ValjPolylinje
{
    public static final Random rand = new Random ();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main (String[] args) {
// skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            polylinjer[i] = slumpPolylinje ();
        }
// visa polylinjerna
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            System.out.println("Linje: " + (i+1) + " " + polylinjer[i] + polylinjer[i].getFarg());
    }
// bestäm den kortaste av de polylinjer som är gula
        int tempValue = 0;
        Polylinje kortasteGul = new Polylinje();
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            if (polylinjer[i].getFarg().equals("gul")) {
                if (polylinjer[i].langd() <= polylinjer[tempValue].langd()) {
                    kortasteGul = polylinjer[i];
                }
                tempValue=i;
            }
        }
// visa den valda polylinjen
        System.out.println("Den kortaste gula är: " + kortasteGul);
    }
    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
// det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt ()
    {
        String n = "" + (char) (65 + rand.nextInt (26));
        int x = rand.nextInt (11);
        int y = rand.nextInt (11);
        return new Punkt (n, x, y);
    }
    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
// eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
// kan inte ha samma namn.
    public static Polylinje slumpPolylinje () {
// skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        int antalHorn = 2 + rand.nextInt (7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];
// ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        char valtChar = 0;
        int asciiMod;

        while (antalValdaHorn < antalHorn) {
            valdPunkt = slumpPunkt();
            valtChar = valdPunkt.getNamn().charAt(0);
            asciiMod = (int) (valtChar) - 65;
            if (!valdaNamn[asciiMod]) {
                valdaNamn[asciiMod] = true;
                polylinje.laggTill(valdPunkt);
                antalValdaHorn++;
            }
        }
// sätt färg
        polylinje.setFarg(slumpFarg());
        return polylinje;
    }

    /**
     * Slumpar en färg för polylinjen.
     * @return färgen
     */
    public static String slumpFarg() {
        String colour;
        int colourCode = rand.nextInt(3);
        if (colourCode == 0) {
            colour = "blå";
        } else if (colourCode == 1) {
            colour = "röd";
        } else {
            colour = "gul";
        }
        return colour;
    }
}