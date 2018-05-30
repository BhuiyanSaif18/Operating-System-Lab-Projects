/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_demo1;

/**
 * @author Saif R
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
public class Maincontroller {
    @FXML
    private ListView listview;
    @FXML
    private Label label;
    @FXML
    private Button destination;
    @FXML
    private ComboBox<String> drivers;
    @FXML
    private TextField ext;
    ObservableList<String> list = FXCollections.observableArrayList("C:", "D:", "E:", "G:");
    //Testing
    @FXML 
    private void initialize (){
        drivers.setValue("Select Drive");
        drivers.setItems(list);
    }
    @FXML
    private Button copy;
    @FXML
    private Button btn1;
    public void Button1Action(ActionEvent event) throws IOException{
        String text = ext.getText();
        FileChooser fc = new FileChooser();
        //for C
        if("C:".equals(drivers.getValue()))
            {
            fc.setInitialDirectory(new File ("C:\\"));
            fc.getExtensionFilters().addAll(new ExtensionFilter(text, "*"+text));
            List<File> selectedFile = fc.showOpenMultipleDialog(null);
            if (selectedFile !=null){
                for(int i=0;i<selectedFile.size();i++){
                listview.getItems().add(selectedFile.get(i).getAbsolutePath());
                }
            }
            else {
                System.out.println("file is not valid");
            }
            listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                listview.setOnMouseClicked(new EventHandler<Event>() {

                    @Override
                    public void handle(Event event) {
                        ObservableList<String> selectedItems =  listview.getSelectionModel().getSelectedItems();
//copy check
                        
                    }
                });
             
        }
        else if("D:".equals(drivers.getValue()))
            {
             fc.setInitialDirectory(new File ("D:\\"));
            fc.getExtensionFilters().addAll(
                new ExtensionFilter(text, "*"+text));
            List<File> selectedFile = fc.showOpenMultipleDialog(null);
            if (selectedFile !=null){
                for(int i=0;i<selectedFile.size();i++){
                    
                listview.getItems().add(selectedFile.get(i).getAbsolutePath());  
                
                }
            }
            else {
                System.out.println("file is not valid");
            }
            //selecting items in list view
                listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                listview.setOnMouseClicked(new EventHandler<Event>() {

                    @Override
                    public void handle(Event event) {
                        ObservableList<String> selectedItems =  listview.getSelectionModel().getSelectedItems();

                        for(String s : selectedItems){
                            System.out.println("selected item " + s);
                        }
                    }
                });
            // selected items
            //copy checq
                
            //copy checq
        }
        else if("E:".equals(drivers.getValue()))
            {
             fc.setInitialDirectory(new File ("E:\\"));
            fc.getExtensionFilters().addAll(
                new ExtensionFilter(text, "*"+text));
            List<File> selectedFile = fc.showOpenMultipleDialog(null);
            if (selectedFile !=null){
                for(int i=0;i<selectedFile.size();i++){
                listview.getItems().add(selectedFile.get(i).getAbsolutePath());
                }
            }
            else {
                System.out.println("file is not valid");
            }
            listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                listview.setOnMouseClicked(new EventHandler<Event>() {

                    @Override
                    public void handle(Event event) {
                        ObservableList<String> selectedItems =  listview.getSelectionModel().getSelectedItems();

                        for(String s : selectedItems){
                            System.out.println("selected item " + s);
                        }
                    }
                });
        }
        else if("G:".equals(drivers.getValue()))
            {
             fc.setInitialDirectory(new File ("G:\\"));
            fc.getExtensionFilters().addAll(
                new ExtensionFilter(text, "*"+text));
            List<File> selectedFile = fc.showOpenMultipleDialog(null);
            if (selectedFile !=null){
                for(int i=0;i<selectedFile.size();i++){
                listview.getItems().add(selectedFile.get(i).getAbsolutePath());
                }
            }
            else {
                System.out.println("file is not valid");
            }
            listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                listview.setOnMouseClicked(new EventHandler<Event>() {

                    @Override
                    public void handle(Event event) {
                        ObservableList<String> selectedItems =  listview.getSelectionModel().getSelectedItems();

                        for(String s : selectedItems){
                            System.out.println("selected item " + s);
                        }
                    }
                });
        }
        //
    }
    public void Destination(ActionEvent event) throws IOException
     {
          DirectoryChooser chooser = new DirectoryChooser();
          File selectedDirectory = chooser.showDialog(null);
          if(selectedDirectory!=null){                      
          label.setText(selectedDirectory.getPath());
          }
    }
    public void Button2Action(ActionEvent event) throws IOException{
      /* List<Integer> selectedItemsCopy = new ArrayList<>(listview.getSelectionModel().getSelectedItems());
listview.getItems().removeAll(selectedItemsCopy);*/
      // ObservableList clip = (ObservableList) clip.getSelectionModel().getSelectedItems();
      //copy chq
        ObservableList<String> selectedItems =  listview.getSelectionModel().getSelectedItems();
        for(int i=0;i<selectedItems.size();i++){
            try{
                        FileSystem system = FileSystems.getDefault();
                         Path path = Paths.get(""+selectedItems.get(i));
                        Path original = system.getPath(""+selectedItems.get(i));
                        Path target = system.getPath(label.getText()+""+path.getFileName());

                        Files.copy(original, target);
                        System.out.println("File copied!");
                        }
                    catch (IOException e){
                        e.printStackTrace();
                    }
        }
      
      //copy chq
     /*final Clipboard clipboard = Clipboard.getSystemClipboard();
     final ClipboardContent content = new ClipboardContent();
     content.putString(""+listview.getSelectionModel().getSelectedItems());
     //content.putHtml("<b>Some</b> text");
     clipboard.setContent(content);*/
    }
}
