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
public class FunkcjaKwadratowa extends Wielomian {
    private Integer a, b, c;
    
    public FunkcjaKwadratowa() {
        a = b = c = 0;
    }
    
    public FunkcjaKwadratowa(Integer newA, Integer newB, Integer newC) {
        a = newA;
        b = newB;
        c = newC;
    }
    
    @Override
    public void wypiszMiejscaZerowe() {
        Integer delta = b * b - 4 * a * c;
        if(delta < 0) System.out.println("brak");
        else if(delta == 0) System.out.println((-1 * b) / (2 * a));
        else {
            System.out.print((-1 * b - (int) Math.sqrt(delta) / (2 * a)) + " ");
            System.out.print((-1 * b + (int) Math.sqrt(delta) / (2 * a)));
        }
    }
}
