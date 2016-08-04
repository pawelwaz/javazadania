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
class Watek extends Thread {
    
    private KolejkaKomunikatow koko;
    private int istart;
    
    public Watek(KolejkaKomunikatow kk, int pocz) {
        koko = kk;
        istart = pocz;
    }

    public void run() {
        try {
            for (int i=istart; i<=10; i+=2) {
                koko.wyslij(new Integer(i));
                Thread.sleep(50);
            }
        }
        catch (InterruptedException e) {};
    }
}
