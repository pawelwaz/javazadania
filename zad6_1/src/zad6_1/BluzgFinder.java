/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad6_1;
import static java.lang.Thread.sleep;
import javax.swing.*;
/**
 *
 * @author pawel
 */
public class BluzgFinder extends Thread {
    JTextArea okno;
    volatile boolean zakonczyc;
    
    public BluzgFinder(JTextArea comp) {
        okno = comp;
        zakonczyc = false;
    }
    
    public void run() {
        while (! zakonczyc) {
            try {
                String tekst = okno.getText().toLowerCase();
                String[] bluzgi = {"cholera", "dupa", "kurwa", "chuj", "pieron"}; //itp., itd.
                boolean mamyGo = false;
                for(int i = 0; i < bluzgi.length; i++) {
                    if(tekst.contains(bluzgi[i])) mamyGo = true;
                }
                if(mamyGo) {
                    JOptionPane.showMessageDialog(okno, "Wykryto nieładne słowa! Proszę poprawić swoje postępowanie!");
                }
                sleep(10000);
            }
            catch (Exception e) {}
        }
    }
}
