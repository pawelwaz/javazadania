/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad6_2;

/**
 *
 * @author pawel
 */
import java.util.*;
class KolejkaKomunikatow {
    
    Vector kolejka = new Vector();
    
    public synchronized void wyslij(Object ob) {
        kolejka.addElement(ob);
    }
    
    public synchronized Object odbierz() {
        if (kolejka.size() == 0) return null;
        Object ob = kolejka.firstElement();
        kolejka.removeElementAt(0);
        return ob;
    }
}
