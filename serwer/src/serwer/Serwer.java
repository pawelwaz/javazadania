/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serwer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pawel
 */
public class Serwer {
    
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(9696);
            while(true) {
                Socket polaczenie = server.accept();
                Thread t = new Thread(
                new Gracz(polaczenie));
                t.start();
            }
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
