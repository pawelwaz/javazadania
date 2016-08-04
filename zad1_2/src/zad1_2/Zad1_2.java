/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1_2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author pawel
 */
public class Zad1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź liczbę całkowitą");
        Integer liczba = scanner.nextInt();
        if(liczba < 0) System.out.println("liczba musi być dodatnia");
        else if(liczba == 0) System.out.println("0");
        else {
            BigInteger liczbaBig = new BigInteger(Integer.toString(liczba));
            BigInteger wynik = new BigInteger("1");
            while(liczbaBig.toString() != "0") {
                wynik = wynik.multiply(liczbaBig);
                liczbaBig = liczbaBig.subtract(new BigInteger("1"));
            }
            System.out.println(wynik.toString());
        }
    }
    
}
