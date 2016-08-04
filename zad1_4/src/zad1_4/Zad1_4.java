/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1_4;

import java.util.Scanner;

/**
 *
 * @author pawel
 */
public class Zad1_4 {
    
    public static String toBin(Integer in) {
        StringBuilder result = new StringBuilder();
        while(in > 0) {
            if(in % 2 == 0) result.append("0");
            else result.append("1");
            in /= 2;
        }
        return result.reverse().toString();
    }
    
    public static String toOct(Integer in) {
        StringBuilder result = new StringBuilder();
        while(in > 0) {
            Integer tmp = in % 8;
            String digit = tmp.toString();
            result.append(digit);
            in /= 8;
        }
        return result.reverse().toString();
    }
    
    public static String toHex(Integer in) {
        StringBuilder result = new StringBuilder();
        while(in > 0) {
            Integer tmp = in % 16;
            String digit;
            switch(tmp) {
                case 10: digit = "A"; break;
                case 11: digit = "B"; break;
                case 12: digit = "C"; break;
                case 13: digit = "D"; break;
                case 14: digit = "E"; break;
                case 15: digit = "F"; break;
                default: digit = tmp.toString(); break;
            }
            result.append(digit);
            in /= 16;
        }
        return result.reverse().toString();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz dodatnia liczbe calkowita");
        Integer in = scanner.nextInt();
        if(in < 0) System.out.println("Wprowadzona liczba jest niepoprawna");
        else {
            System.out.println("Binarna postac: " + toBin(in));
            System.out.println("Osemkowa postac: " + toOct(in));
            System.out.println("Szesnastkowa postac: " + toHex(in));
        }
    }
    
}