/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3_2;

/**
 *
 * @author pawel
 */
class Wyrazenie {
    private Wierzcholek korzen;
    
    private Wierzcholek utworzDrzewo(String w, int p, int q) throws InvalidExpressionException {
        if (p == q) return new Stala(Character.digit(w.charAt(p), 10));
        else {
            try {
                int i = p+1, nawiasy = 0;
                while ((nawiasy != 0) || (w.charAt(i) == '(') || (w.charAt(i) == ')') || (Character.isDigit(w.charAt(i)))) {
                    if (w.charAt(i) == '(') ++nawiasy;
                    if (w.charAt(i) == ')') --nawiasy;
                    ++i;
                }
                Dzialanie nowy = new Dzialanie(w.charAt(i));
                nowy.dodajLewyArg(utworzDrzewo(w, p+1, i - 1));
                nowy.dodajPrawyArg(utworzDrzewo(w, i+1, q - 1));
                return nowy;   
            }
            catch(Exception e) {
                throw new InvalidExpressionException();
            }
        }
    }
    
    public Wyrazenie(String w) {
        try {
            korzen = utworzDrzewo(w, 0, w.length() - 1);
        }
        catch(InvalidExpressionException e) {
            System.out.println("Twoje wyrazenie jest inwalida!");
        }
    }
    
    public int oblicz() {
        try {
            return korzen.wartosc();
        }
        catch(NullPointerException e) {
            System.out.println("Nie ma czego obliczac");
            return 0;
        }
    }
}