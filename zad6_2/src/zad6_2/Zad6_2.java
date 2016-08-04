/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad6_2;

import java.util.HashMap;

/**
 *
 * @author pawel
 */
public class Zad6_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String keys1[] = {"jeden", "dwa", "trzy", "cztery", "pięć"};
        String keys2[] = {"sześć", "siedem", "osiem", "dziewięć", "dziesięć"};
        HashMap mapa = new HashMap();
        HashWatek w1 = new HashWatek(mapa, 1, 5, keys1);
        HashWatek w2 = new HashWatek(mapa, 6, 10, keys2);
        w1.start();
        w2.start();
        try {
            w1.join();
            w2.join();
        }
        catch (InterruptedException e) {};
        pokazMape(mapa, keys1);
        pokazMape(mapa, keys2);
    }
    
    private static void pokazMape(HashMap mapa, String[] klucze) {
        for(int i = 0; i < klucze.length; i++) {
            Integer val = (Integer) mapa.get(klucze[i]);
            System.out.println(klucze[i] + " = " + val.toString());
        }
    }
    
}
