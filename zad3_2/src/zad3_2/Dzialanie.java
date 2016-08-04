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
class Dzialanie extends Wierzcholek {
    private char op; // operator +, -, / lub *
    
    public Dzialanie(char znak) {
        op = znak;
    }
    
    public void dodajLewyArg(Wierzcholek arg) {
        lewy = arg;
    }
    
    public void dodajPrawyArg(Wierzcholek arg) {
        prawy = arg;
    }
    
    public int wartosc() throws DivideZeroException {
        switch (op) {
            case '+': return lewy.wartosc() + prawy.wartosc();
            case '-': return lewy.wartosc() - prawy.wartosc();
            case '/': 
                try {
                    return lewy.wartosc() / prawy.wartosc();
                }
                catch(ArithmeticException e) {
                    throw new DivideZeroException();
                }
            case '*': return lewy.wartosc() * prawy.wartosc();
        }
        return 0;
    }
}
