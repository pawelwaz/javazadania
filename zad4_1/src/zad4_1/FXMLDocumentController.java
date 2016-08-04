/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.RandomAccessFile;
import javafx.scene.control.ToggleGroup;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javafx.scene.control.Alert;

/**
 *
 * @author pawel
 */
public class FXMLDocumentController implements Initializable {
    private String path, encoding;
    
    @FXML private TextArea mainText;
    @FXML private AnchorPane ap;
    @FXML private ToggleGroup groupMenu;
    
    @FXML
    private void zamknij(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void nowy(ActionEvent event) {
        refreshPath(null);
        mainText.setText("");
    }
    
    @FXML
    private void otworz(ActionEvent event) {
        Stage st = (Stage) ap.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("otwórz plik");
        File choice = fileChooser.showOpenDialog(st);
        if(choice != null) wczytaj(choice.getPath());
    }
    
    @FXML
    private void zmienKodowanie(ActionEvent event) {
        String typ = groupMenu.getSelectedToggle().toString();
        if(typ.contains("utf")) encoding = "UTF8";
        else if(typ.contains("iso")) encoding = "ISO8859-2";
        else encoding = "Cp1250";
        if(path != null) {
            wczytaj(path);
        }
    }
    
    @FXML
    private void zapisz(ActionEvent event) {
        if(path != null) {
            zapiszPlik(path);
        }
        else {
            zapiszJako(null);
        }
    }
    
    @FXML
    private void zapiszJako(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Stage st = (Stage) ap.getScene().getWindow();
        File choice = fc.showSaveDialog(st);
        if(choice != null) {
            refreshPath(choice.getPath());
            zapiszPlik(path);
        }
    }
    
    private void zapiszPlik(String file) {
        try{
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, encoding);
            osw.write(mainText.getText());
            osw.close();
            fos.close();
        }
        catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ooops!");
            alert.setHeaderText(null);
            alert.setContentText("problem z zapisaniem pliku!");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void info(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("info");
        alert.setHeaderText("prosty edytorek tekstu");
        alert.setContentText("autor: Paweł Wąż");
        alert.showAndWait();
    }
    
    private void wczytaj(String plik) {
        try {
            RandomAccessFile raf = new RandomAccessFile(plik, "r");
            byte[] znaki = new byte[(int) raf.length()];
            raf.readFully(znaki);
            String text = new String(znaki, encoding);
            mainText.setText(text);
            raf.close();
            refreshPath(plik);
        }
        catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ooops!");
            alert.setHeaderText(null);
            alert.setContentText("problem z wyświetleniem pliku!");
            alert.showAndWait();
        }
    }
    
    private void refreshPath(String newPath) {
        Stage st = (Stage) ap.getScene().getWindow();
        path = newPath;
        if(newPath == null) {
            path = null;
            st.setTitle("nowy plik tekstowy");
        }
        else {
            path = newPath;
            st.setTitle(path);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        encoding = "UTF8";
    }    
    
}
