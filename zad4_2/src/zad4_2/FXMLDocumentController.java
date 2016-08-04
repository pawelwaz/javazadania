/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author pawel
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label path;
    @FXML private ToggleGroup tg;
    @FXML private AnchorPane ap;
    @FXML private Button jobButton;
    @FXML private RadioButton zip, unzip;
    private String filePath;
    
    @FXML
    private void chooseFile(ActionEvent event) {
        Stage st = (Stage) ap.getScene().getWindow();
        FileChooser fc = new FileChooser();
        File choice = fc.showOpenDialog(st);
        if(choice != null) {
            filePath = choice.getPath();
            path.setText(filePath);
            jobButton.setDisable(false);
            zip.setDisable(false);
            unzip.setDisable(false);
        }
    }
    
    @FXML
    private void doJob(ActionEvent event) {
        if(zip.isSelected()) {
            zipFile();
        }
        else {
            unzipFile();
        }
    }
    
    private void zipFile() {
        try {
            String newPath = filePath + ".gzip";
            FileInputStream fis = new FileInputStream(filePath);
            byte[] content = new byte[fis.available()];
            fis.read(content);
            fis.close();
            
            FileOutputStream fos = new FileOutputStream(newPath);  
            GZIPOutputStream gzip = new GZIPOutputStream(fos);
            gzip.write(content);
            gzip.close();
            fos.close();
            
            showAlert("sukces", "Utworzono spakowany plik " + newPath, Alert.AlertType.INFORMATION);
        }
        catch(Exception e) {
            showAlert("ooops", "problem z kompresją pliku!", Alert.AlertType.ERROR);
        }
    }
    
    private void unzipFile() {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            GZIPInputStream gzip = new GZIPInputStream(fis);
            int len = gzipSize(filePath);
            byte[] content = new byte[len];
            gzip.read(content, 0, len);
            gzip.close();
            fis.close();
            
            String newPath = filePath.substring(0, filePath.lastIndexOf(".gzip"));
            FileOutputStream fos = new FileOutputStream(newPath);  
            fos.write(content);
            fos.close();
            
            showAlert("sukces!", "Rozpakowano plik !" + newPath, Alert.AlertType.INFORMATION);
        }
        catch(Exception e) {
            showAlert("ooops", "problem z dekompresją pliku!", Alert.AlertType.ERROR);
        }
    }
    
    private int gzipSize(String file) {
        int len = 0;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            GZIPInputStream gzip = new GZIPInputStream(fis);
            while(gzip.read() != -1) len++;
            gzip.close();
            fis.close();   
        }
        catch(Exception e) {
            showAlert("ooops", "problem z dekompresją pliku!", Alert.AlertType.ERROR);
        }
        return len;
    }
    
    private void showAlert(String title, String content, Alert.AlertType ico) {
        Alert alert = new Alert(ico);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filePath = null;
    }    
    
}