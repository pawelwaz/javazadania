/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5_2;

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
    public int hashCode() {
        int hash = 1;
        hash += x * 5;
        hash += y * 10;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wspolrzedna other = (Wspolrzedna) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
}
