/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad7_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author pawel
 */
public class FXMLDocumentController implements Initializable {
    
    private int iloscKlik;
    private PrintWriter out;
    private BufferedReader in;
    private Socket polaczenie;
    
    @FXML private Button pole[];
    @FXML private AnchorPane ap;
    
    @FXML
    private void sprawdzPole(ActionEvent event) {
        String id = ((Control) event.getSource()).getId();
        try {
            int numer = Integer.parseInt(id);
            ++numer;
            out.println(numer);
            String odp = in.readLine();
            if(odp.equals("bum")) {
                showAlert("BOOOOOOOOOM!!!!", "Trafiłeś na minę!", Alert.AlertType.INFORMATION);
                System.exit(0);
            }
            else {
                ((Button)((Control) event.getSource())).setText(odp);
                if(wygrana()) {
                    showAlert("HUURRRAA!", "Wygrałeś!", Alert.AlertType.INFORMATION);
                    System.exit(0);
                }
            }
        }
        catch(NumberFormatException e) {
            
        }
        catch(IOException e) {
            
        }
    }
    
    private boolean wygrana() {
        ++iloscKlik;
        if(iloscKlik == 71) return true;
        else return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iloscKlik = 0;
        try {
            polaczenie = new Socket("127.0.0.1", 9696);
            in = new BufferedReader(new InputStreamReader(polaczenie.getInputStream()));
            out = new PrintWriter(polaczenie.getOutputStream(), true);
            String ok = in.readLine();
            if("OK.".equals(ok)) showAlert("Nawiązano połączenie", "Poprawne połączenie z serwerem", Alert.AlertType.INFORMATION);
        }
        catch(IOException e) {
            showAlert("Problem z połączeniem", "Nie udało się nawiązać połączenia z serwerem", Alert.AlertType.ERROR);
            System.exit(1);
        }
        pole = new Button[81];
        int lX = 0;
        int lY = 0;
        for(int i = 0; i < pole.length; i++) {
            pole[i] = new Button();
            pole[i].setLayoutX(lX);
            pole[i].setLayoutY(lY);
            pole[i].setMinWidth(30);
            pole[i].setMinHeight(30);
            Integer id = i;
            pole[i].setId(id.toString());
            pole[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    sprawdzPole(e);
                }
            });
            lX += 30;
            if(lX == 270) {
                lX = 0;
                lY += 30;
            }
            ap.getChildren().add(pole[i]);
        }
        
    }  
    
    private void showAlert(String title, String content, Alert.AlertType ico) {
        Alert alert = new Alert(ico);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
