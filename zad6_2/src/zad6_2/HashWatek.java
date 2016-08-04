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
public class HashWatek extends Thread {
    private HashMap map;
    private int istart, iend;
    private String[] keys;
    
    public HashWatek(HashMap newMap, int newStart, int newEnd, String[] newKeys) {
        map = newMap;
        istart = newStart;
        iend = newEnd;
        keys = newKeys;
    }
    
    public void run() {
        try {
            for (Integer i=istart; i <= iend; i++) {
                map.put(keys[i-istart], i);
                Thread.sleep(50);
            }
        }
        catch (InterruptedException e) {};
    }
}
