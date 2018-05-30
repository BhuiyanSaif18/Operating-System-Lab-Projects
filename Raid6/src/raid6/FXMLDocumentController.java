/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raid6;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import static raid6.StartController.Data;
/**
 *
 * @author Saif
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    AnchorPane menupane;
    @FXML 
    Button Back;
    @FXML
    private Label label;
    @FXML
    public Label labelp1;
    @FXML
    public Label labelp2;
    @FXML
    public Label labelp3;
    @FXML
    public Label labelp4;
    @FXML
    public Label labelq1;
    @FXML
    public Label labelq2;
    @FXML
    public Label labelq3;
    @FXML
    public Label labelq4;
    @FXML
    public List<Label> labelList ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         int count = -1,i=0,e=0,m=0;
        for (Label label : labelList) {
            count++;
            if(count<Data.length())
            {
                i++;
                if(Data.charAt(count)=='1')
                {
                 e++;
                }
                if(i==4){
                    
                    m++;
                    if(e%2==0){
                        if(m==1)
                        {
                            labelp1.setText("0");
                            labelq1.setText("1");
                        }
                        else if(m==2){
                        labelp2.setText("0");
                        labelq2.setText("1");
                        }
                        else if(m==3){
                        labelp3.setText("0");
                        labelq3.setText("1");
                        }
                        else if(m==4){
                        labelp4.setText("0");
                        labelq4.setText("1");
                        }
                        e=0;    
                    }
                    else {
                        if(m==1)
                        {
                            labelp1.setText("1");
                            labelq1.setText("0");
                        }
                        else if(m==2){
                        labelp2.setText("1");
                        labelq2.setText("0");
                        }
                        else if(m==3){
                        labelp3.setText("1");
                        labelq3.setText("0");
                        }
                        else if(m==4){
                        labelp4.setText("1");
                        labelq4.setText("0");
                        }
                            e=0;
                    }
                    i=0;
                }
                label.setText(""+Data.charAt(count));
            }
        }
    }
public void loadScene(ActionEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getClassLoader().getResource("raid6/Start.fxml"));
        menupane.getChildren().setAll(pane);
    }    
}
