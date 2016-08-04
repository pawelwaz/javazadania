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
public class FunkcjaLiniowa extends Wielomian {
    private Integer a, b;
    
    public FunkcjaLiniowa() {
        a = b = 0;
    }
    
    public FunkcjaLiniowa(Integer newA, Integer newB) {
        a = newA;
        b = newB;
    }
    
    @Override
    public void wypiszMiejscaZerowe() {
        System.out.println((double) (-1 * b) / a);
    }
}
