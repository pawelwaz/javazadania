/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pawel
 */
public class Rational {

    private Integer nominator, denominator;
    
    public Rational(Integer newNom, Integer newDenom) {
        nominator = newNom;
        denominator = newDenom;
    }
    
    public Rational() {
        nominator = 0;
        denominator = 0;
    }
    
    public void setNominator(Integer newNom) {
        nominator = newNom;
    }
    
    public void setDenominator(Integer newDenom) {
        denominator = newDenom;
    }
    
    public Integer getNominator() {
        return nominator;
    }
    
    public Integer getDenominator() {
        return denominator;
    }
    
    public static void equalDenominator(Rational arg1, Rational arg2) {
        Integer den1 = arg1.getDenominator();
        Integer den2 = arg2.getDenominator();
        arg1.setNominator(arg1.getNominator() * den2);
        arg1.setDenominator(arg1.getDenominator() * den2);
        arg2.setNominator(arg2.getNominator() * den1);
        arg2.setDenominator(arg2.getDenominator() * den1);
    }
    
    public Rational add(Rational arg) {
        Rational tmp1 = new Rational(nominator, denominator);
        Rational tmp2 = new Rational(arg.getNominator(), arg.getDenominator());
        equalDenominator(tmp1, tmp2);
        return new Rational(tmp1.getNominator() + tmp2.getNominator(), tmp1.getDenominator());
    }
    
    public Rational mul(Rational arg) {
        return new Rational(nominator * arg.getNominator(), denominator * arg.getDenominator());
    }
    
    public Rational sub(Rational arg) {
        Rational tmp1 = new Rational(nominator, denominator);
        Rational tmp2 = new Rational(arg.getNominator(), arg.getDenominator());
        equalDenominator(tmp1, tmp2);
        return new Rational(tmp1.getNominator() - tmp2.getNominator(), tmp1.getDenominator());
    }
    
    public Rational div(Rational arg) {
        return new Rational(nominator * arg.getDenominator(), denominator * arg.getNominator());
    }
    
    public boolean equals(Rational arg) {
        Rational tmp1 = new Rational(nominator, denominator);
        Rational tmp2 = new Rational(arg.getNominator(), arg.getDenominator());
        equalDenominator(tmp1, tmp2);
        return tmp1.getNominator().equals(tmp2.getNominator());
    }
    
    public int compareTo(Rational arg) {
        Rational tmp1 = new Rational(nominator, denominator);
        Rational tmp2 = new Rational(arg.getNominator(), arg.getDenominator());
        equalDenominator(tmp1, tmp2);
        if(tmp1.getNominator().equals(tmp2.getNominator())) return 0;
        else if(tmp1.getNominator() > tmp2.getNominator()) return 1;
        else return -1;
    }
    
    public String toString() {
        return nominator.toString() + "/" + denominator.toString();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("przyklad dodawania:");
        Rational x1 = new Rational(2, 5);
        Rational x2 = new Rational(1, 2);
        System.out.println(x1.toString() + " + " + x2.toString() + " = " + x1.add(x2).toString());
        System.out.println("przyklad mnozenia:");
        System.out.println(x1.toString() + " + " + x2.toString() + " = " + x1.mul(x2).toString());
        System.out.println("przyklad odejmowania:");
        System.out.println(x1.toString() + " + " + x2.toString() + " = " + x1.sub(x2).toString());
        System.out.println("przyklad dzielenia:");
        System.out.println(x1.toString() + " + " + x2.toString() + " = " + x1.div(x2).toString());
        System.out.println("sprawdzenie rownosci:");
        System.out.print(x1.toString());
        if(!x1.equals(x2)) System.out.print(" nie");
        System.out.println(" jest rowne " + x2.toString());
        System.out.println("sprawdzenie porownania:");
        System.out.println("porownanie " + x1.toString() + " oraz " + x2.toString() + " daje rezultat " + x1.compareTo(x2));
    }
    
}
