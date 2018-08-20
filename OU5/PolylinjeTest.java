package OU5;

import java.util.Scanner;

public class PolylinjeTest {

    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    // Skapar ett par punkter som kan användas till polylinjen.
    Punkt p1 = new Punkt("A", 3, 4);
    Punkt p2 = new Punkt("B", 5, 6);
    Punkt p3 = new Punkt("C", 8, 2);
    Punkt p4 = new Punkt("D", 4, 1);
    Punkt p5 = new Punkt("E", 7, 9);

    // Skapar polylinjen
    Punkt[] horn = {p1, p2, p3};
    Polylinje linje1 = new Polylinje(horn);

    // Polylinje
    System.out.println("The polyline: " +linje1.toString() + "\n");

    // Färger
    System.out.println("The current colour is: " + linje1.getFarg());
    System.out.print("Enter new colour: ");
    linje1.setFarg(in.next());
    System.out.println("The new colour is: " + linje1.getFarg() + "\n");

    // Bredd
    System.out.println("The current width is: " + linje1.getBredd());
    System.out.print("Enter new width: ");
    linje1.setBredd(in.nextInt());
    System.out.println("The new width is: " + linje1.getBredd() + "\n");

    // Langd
    System.out.println("The length is: " + linje1.langd() + "\n");

    // Lägg till
        System.out.println("Adding point D to the polyline");
        linje1.laggTill(p4);
        System.out.println(linje1 + "\n");

        // Lägg till framför
        System.out.println("Adding point E before D in the polyline");
        linje1.laggTillFramfor(p5, "D");
        System.out.println(linje1 + "\n");

        // Ta bort
        System.out.println("Removing point B from the polyline");
        linje1.taBort("B");
        System.out.println(linje1 + "\n");

        // Skapar iterator objekt
        Polylinje.PolylinjeIterator polyIter = linje1.new PolylinjeIterator();

        // Går via iteratorn igenom linjen ett steg i taget tills slutet.
        while (polyIter.finnsHorn()) {
            System.out.println(polyIter.horn());
            polyIter.gaFram();
        }
    }
}
