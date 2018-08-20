package OU5;

public class Punkt {

    private int x;
    private int y;
    private String s;

    /**
     * @param s Namnet på punkten
     * @param x X-kordinaten
     * @param y Y-kordinaten
     */
    public Punkt(String s, int x, int y) {
        this.x = x;
        this.y = y;
        this.s = s;
    }

    /**
     * Skapar en sträng av namn och dess kordinater.
     * @return
     */
    @Override
    public String toString() {
        return "(" + this.s + " " + this.x + " " + this.y + ")";
    }

    /**
     * Konstruktorn
     * @param punkt
     */
    public Punkt(Punkt punkt) {
        this.x = punkt.x;
        this.y = punkt.y;
        this.s = punkt.s;
    }

    /**
     * En get för att få namnet på punkten.
     * @return namnet
     */
    public String getNamn() {
        return s;
    }

    /**
     * En get för att få X-kordinaten av punkten
     * @return X-kordinaten
     */
    public int getX() {
        return x;
    }

    /**
     * En get för att få Y-kordinaten av punkten.
     * @return Y-kordinaten
     */
    public int getY() {
        return y;
    }

    /**
     * En set för att ändra X-kordinaten av punkten
     * @param x X-kordinaten man vill ändra till
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * En set för att ändra Y-kordinaten av punkten.
     * @param y Y-kordinaten man vill ändra till
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Beräknar avståndet mellan denna punkt och en annan
     * @param p2 Punkten man beräknar avståndet till
     * @return Avståndet mellan de två punkterna
     */
    public double avstand(Punkt p2) {
        int x1 = this.getX();
        int x2 = p2.getX();
        int y1 = this.getY();
        int y2 = p2.getY();
        double z = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);

        return Math.sqrt(z);
    }

    /**
     * Kollar om två punkter är likadana eller ej
     * @param p2 Punkten man jämför med.
     * @return Om de två punkterna är likadana eller inte.
     */
    public boolean equals(Punkt p2) {
        if (this.x == p2.x && this.y == p2.y) {
            return true;
        }
        return false;
    }
}
