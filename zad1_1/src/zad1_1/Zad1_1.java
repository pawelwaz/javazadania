/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1_1;
import javax.swing.JOptionPane;

/**
 *
 * @author pawel
 */
public class Zad1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String text = JOptionPane.showInputDialog("Wprowadź tekst");
        text = text.toUpperCase();
        JOptionPane.showMessageDialog(null, text);
        System.exit(0);
    }
    
}
