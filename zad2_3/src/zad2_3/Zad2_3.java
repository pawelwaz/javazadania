/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2_3;

/**
 *
 * @author pawel
 */
public class Zad2_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wielomian w[] = new Wielomian[3];
        w[0] = new FunkcjaLiniowa(2, 1);
        w[1] = new FunkcjaKwadratowa(1, -2, 2);
        w[2] = new FunkcjaKwadratowa(1, 0, -1);
        for (int i=0; i<3; i++) {
            w[i].wypiszMiejscaZerowe();
        }
    }
    
}
