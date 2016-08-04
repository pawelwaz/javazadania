/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5_1;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author pawel
 */
public class Zad5_1 {

    private static void wypiszElementy(TreeSet zbior) {
        Iterator it = zbior.iterator();
        while (it.hasNext()) {
            System.out.println((it.next()).toString());
        }
    }
    
    public static void main(String[] args) {
        int[] test = new int[20];
        TreeSet zbior = new TreeSet();
        zbior.add( new Wspolrzedna(2, 3) );
        zbior.add( new Wspolrzedna(-3, 0) );
        zbior.add( new Wspolrzedna(-1, 2) );
        zbior.add( new Wspolrzedna(-1, 2) );
        zbior.add( new Wspolrzedna(-3, -2) );
        wypiszElementy(zbior);
    }
    
}
