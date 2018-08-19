package OU5;

import java.util.Arrays;

public class Polylinje
{
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;
    public Polylinje ()
    {
        this.horn = new Punkt[0];
    }
    public Polylinje (Punkt[] horn) {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt (horn[i]);
    }
    public String toString () {
        StringBuilder description = new StringBuilder();
        for (Punkt punkt : this.horn) {
            description.append("(" + punkt.getNamn() + " " + punkt.getX() + " " + punkt.getY() + ") ");
        }
        return description.toString();
    }
    public Punkt[] getHorn () {
        return Arrays.copyOf(this.horn, this.horn.length);
    }
    public String getFarg () {
        return this.farg;
    }
    public int getBredd () {
        return this.bredd;
    }
    public void setFarg (String farg) {
        this.farg = farg;
    }
    public void setBredd (int bredd) {
        this.bredd = bredd;
    }
    public double langd () {
        double langd = 0;
        for (int i = 0; i < this.horn.length - 1; i++) {
            langd += this.horn[i].avstand(this.horn[i + 1]);
        }
        return langd;
    }
    public void laggTill (Punkt horn)
    {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);
        this.horn = h;
    }
    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt newhorn = new Punkt(horn); // Make a new copy of the object referenced
        Punkt[] nyhorn = new Punkt[this.horn.length + 1]; // Create an array one index longer than horn

        // Loop until the name provided shows up
        int index = 0;
        for (int i = 0; i < this.horn.length; i++) {
            if (this.horn[i].getNamn().equals(hornNamn)) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < nyhorn.length - 1; i++) {
            nyhorn[i < index ? i : i + 1] = this.horn[i];
        }
        nyhorn[index] = newhorn;

        this.horn = nyhorn;
    }

    public void taBort (String hornNamn) {
        Punkt[] newhorn = new Punkt[this.horn.length - 1]; // Create an array one index longer than horn

        // Loop until the name provided shows up
        int index = 0;
        for (int i = 0; i < this.horn.length; i++) {
            if (this.horn[i].getNamn().equals(hornNamn)) {
                index = i;
                break;
            }
        }
        for (int j = 0; j < index; j++) {
            newhorn[j] = this.horn[j];
        }
        for (int j = index; j < newhorn.length; j++) {
            newhorn[j] = this.horn[j + 1];
        }

        this.horn = newhorn;
    }
    public class PolylinjeIterator
    {
        private int aktuell = -1;
        public PolylinjeIterator ()
        {
            if (Polylinje.this.horn.length > 0)
                aktuell = 0;
        }
        public boolean finnsHorn ()
        {
            return aktuell != -1;
        }
        public Punkt horn () throws java.util.NoSuchElementException
        {
            if (!this.finnsHorn ())
                throw new java.util.NoSuchElementException (
                        "slut av iterationen");
            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;
        }
        public void gaFram ()
        {
            if (aktuell >= 0 &&
                    aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }
    }
}
