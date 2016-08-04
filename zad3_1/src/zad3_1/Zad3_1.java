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
public class Zad3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kolejka k = new Kolejka();
        try {
            k.doKolejki(new Integer(7));
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(new Double(3.14));
            for (int i=1; i<=4; ++i)
                System.out.println((k.zKolejki()).toString());
        }
        catch (Przepelnienie e) {
            System.out.println("Przepełniona kolejka!");
        }
        catch (Niedomiar e) {
            System.out.println("Pusta kolejka!");
           }
    } 
}
