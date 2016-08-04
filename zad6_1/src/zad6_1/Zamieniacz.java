/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad6_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author pawel
 */
class Zamieniacz extends Thread {
    
    JTextArea okno;
    volatile boolean zakonczyc;
    
    public Zamieniacz(JTextArea comp) {
        okno = comp;
        zakonczyc = false;
    }
    
    public void run() {
        while (! zakonczyc) {
            try {
                String tekst = okno.getText();
                int indeks = tekst.indexOf("{");
                if (indeks >= 0) {
                    okno.replaceRange("begin", indeks, indeks+1);
                    okno.setCaretPosition(tekst.length()+4);
                }
                else {
                    indeks = tekst.indexOf("}");
                    if (indeks >=0) {
                        okno.replaceRange("end", indeks, indeks+1);
                        okno.setCaretPosition(tekst.length()+2);
                    }
                }
                sleep(2000);
            }
            catch (Exception e) {}
        }
    }
}
