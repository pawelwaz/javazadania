/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5_1;

/**
 *
 * @author pawel
 */
class Wspolrzedna implements Comparable<Wspolrzedna> {
    
    private int x, y;
    
    public Wspolrzedna(int _x, int _y) {
        x = _x;
        y = _y;
    }
    
    @Override
    public int compareTo(Wspolrzedna other) {
        if(x > other.x) return 1;
        else if(x < other.x) return -1;
        else {
            if(y > other.y) return 1;
            else if(y < other.y) return -1;
            else return 0;
        }
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
}
