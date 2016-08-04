/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3_2;

/**
 *
 * @author pawel
 */
public class Zad3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wyrazenie wyr = new Wyrazenie("(3*((1+2)-1))");
        System.out.println("" + wyr.oblicz());
        wyr = new Wyrazenie("(4/0)");
        try {
            System.out.println("" + wyr.oblicz());
        }
        catch(DivideZeroException e) {
            System.out.println("Nastapila proba dzielenia przez zero!");
        }
        try {
            wyr = new Wyrazenie("(*5((0)");
            System.out.println("" + wyr.oblicz());
        }
        catch(DivideZeroException e) {
            System.out.println("Nastapila proba dzielenia przez zero!");
        }
    }
    
}
