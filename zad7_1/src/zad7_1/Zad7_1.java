/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad7_1;
import java.net.*;
import java.io.*;
/**
 *
 * @author pawel
 */
public class Zad7_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nazwahosta;
        if (args.length > 0) {
            nazwahosta = args[0];
        }
        else {
            nazwahosta = "time.nist.gov";
        }
        try {
            Socket gniazdo = new Socket(nazwahosta, 37);
            InputStream strumien = gniazdo.getInputStream();
            int pobrane[] = new int[4];
            for(int i = 0; i < 4; i++) {
                pobrane[i] = strumien.read();
            }
            long wynik = pobrane[0];
            wynik = (wynik << 24) | (pobrane[1] << 16) | (pobrane[2] << 8) | pobrane[3];
            System.out.println("" + wynik);
        }
        catch (UnknownHostException e) {
            System.err.println(e);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
    
}
