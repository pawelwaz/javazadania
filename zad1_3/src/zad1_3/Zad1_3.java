/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1_3;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author pawel
 */
public class Zad1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dodatnią liczbę całkowitą");
        Integer input = scanner.nextInt();
        if(input <= 0) System.out.println("Wartość liczby jest nieprawidłowa");
        else {
            BigDecimal suma = new BigDecimal("0");
            for(Integer i = 1; i <= input; i++)
                if(i % 2 == 1) suma = suma.add(new BigDecimal(i.toString()));
            System.out.println("suma liczb nieparzystych wynosi " + suma.toString());
        }
    }
    
}
