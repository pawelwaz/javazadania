/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.Math;
import java.util.Scanner;
/**
 *
 * @author pawel
 */
public class Kwadratowe {

    private Integer a, b, c;
    
    public Kwadratowe() {
        a = b = c = 0;
    }
    
    public Kwadratowe(Integer newA, Integer newB, Integer newC) {
        setParams(newA, newB, newC);
    }
    
    public final void setParams(Integer newA, Integer newB, Integer newC) {
        a = newA;
        b = newB;
        c = newC;
    }
    
    public Integer getY(Integer x) {
        return (int) Math.pow(x, 2) * a + x * b + c;
    }
    
    public int amountOfSquareRoots() {
        Integer delta = (int) Math.pow(b, 2) - 4 * a * c;
        if(delta < 0) return 0;
        else if(delta == 0) return 1;
        else return 2;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Integer newA, newB, newC;
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj a");
        newA = scanner.nextInt();
        System.out.println("podaj b");
        newB = scanner.nextInt();
        System.out.println("podaj c");
        newC = scanner.nextInt();
        Kwadratowe rownanie = new Kwadratowe(newA, newB, newC);
        System.out.println("ilosc pierwiastkow: " + rownanie.amountOfSquareRoots());
    }
    
}
