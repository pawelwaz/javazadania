/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5_3;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author pawel
 */
public class Graf {
    private int n; // liczba wierzchołków, V = {0,1,...,n-1}
    private LinkedList[] tab; // tablica wierzchołków połączonychz danym wierzcholkiem
    
    public Graf(String lan) {
        StringTokenizer st = new StringTokenizer(lan, "() ,");
        n = Integer.parseInt(st.nextToken());
        tab = new LinkedList[n];
        for (int i=0; i<n; ++i) tab[i] = new LinkedList();
        while (st.hasMoreTokens()) {
            tab[Integer.parseInt(st.nextToken())].add(new Integer(st.nextToken()));
        }
    }
    
    public String toString() {
        StringBuffer result = new StringBuffer("");
        for(Integer i = 0; i < tab.length; i++) {
            result.append(i.toString());
            result.append(": ");
            for(Integer j = 0; j < tab[i].size(); j++) {
                result.append(tab[i].get(j));
                result.append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
    
}
