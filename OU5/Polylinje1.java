package OU5;

public class Polylinje1
{
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;
    public Polylinje1 ()
    {
        this.horn = new Punkt[0];
    }
    public Polylinje1 (Punkt[] horn) {
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
        return horn;
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

    }
    public void taBort (String hornNamn) {

    }
}