package OU5;

public class Punkt {

    private int x;
    private int y;
    private String s;

    public Punkt(String s, int x, int y) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
    @Override
    public String toString() {
        return "(" + this.s + " " + this.x + " " + this.y + ")";
    }
    public Punkt(Punkt punkt) {
        this.x = punkt.x;
        this.y = punkt.y;
        this.s = punkt.s;
    }
    public String getNamn() {
        return s;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double avstand(Punkt p2) {
        int x1 = this.getX();
        int x2 = p2.getX();
        int y1 = this.getY();
        int y2 = p2.getY();
        double z = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);

        return Math.sqrt(z);
    }
    public boolean equals(Punkt p2) {
        if (this.x == p2.x && this.y == p2.y) {
            return true;
        }
        return false;
    }
}
