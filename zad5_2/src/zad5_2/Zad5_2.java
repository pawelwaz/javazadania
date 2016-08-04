/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5_2;

import java.util.HashMap;

/**
 *
 * @author pawel
 */
public class Zad5_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap mapa = new HashMap();
        mapa.put(new Wspolrzedna(2, 3), new String("czerwony"));
        mapa.put(new Wspolrzedna(-3, 0), new String("czarny"));
        mapa.put(new Wspolrzedna(-1, 2), new String("czerwony"));
        mapa.put(new Wspolrzedna(2, -1), new String("czarny"));
        Wspolrzedna w = new Wspolrzedna(-1, 2);
        System.out.println("Punkt " + w.toString() + " ma kolor " + mapa.get(w));
    }
    
}
