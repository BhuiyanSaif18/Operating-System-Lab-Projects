/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raid6;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Saif
 */
public class StartController implements Initializable {
    public static String Data = "                ";
    @FXML
    AnchorPane menu2Pane;
    @FXML
    Button GO;
    @FXML
     public TextField txt;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void loadScene(ActionEvent event) throws IOException {
       Data= txt.getText();
        AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("raid6/FXMLDocument.fxml"));
        menu2Pane.getChildren().setAll(pane);
    }
    
}
