/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3_1;

/**
 *
 * @author pawel
 */
public class Kolejka {
    
    static final int N = 5;
    private Object[] tab;
    private int pocz, zaost, lbel;
    
    public Kolejka() {
        pocz=0; zaost=0; lbel=0;
        tab = new Object[N];
    }
    
    void doKolejki(Object el) throws Przepelnienie {
        if(lbel >= N) {
            tab[zaost] = el;
            zaost = (zaost+1) % N;
            ++lbel; 
        }
        else throw new Przepelnienie();
    }
    
    Object zKolejki() throws Niedomiar {
        if(lbel > 0) {
            int ind = pocz;
            pocz = (pocz+1) % N;
            --lbel;
            return tab[ind]; 
        }
        else throw new Niedomiar();  
    }
    
}
