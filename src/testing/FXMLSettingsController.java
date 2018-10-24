/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mecic
 */
public class FXMLSettingsController implements Initializable {
    
    //ObservableList<Spinner> categoryList;
    
   /* private void loadSpinnerData() {
        ArrayList<Spinner> spinners = IOUtil.load();
        if(spinners == null) {
            System.out.println("Failed to load the file");
        }
        ObservableList<Spinner> categoryList = FXCollections.observableArrayList(spinners);
    }*/
    //@FXML
    //ObservableList<String> categoryList = FXCollections.observableArrayList();
    
    
    
    @FXML
    private ComboBox categoryComboBox;
    
    @FXML
    private ScrollPane gridContainer;
    
    private static void getSpinnerNames(ArrayList<Spinner> spinners) {
        // display spinner names
        int numSpinners = spinners.size();
        
        for (int i = 0; i < numSpinners; i++) {
            Spinner spinner = spinners.get(i);
            System.out.println(spinner.getSpinnerName());
        }
    }
    
    @FXML
    public void mainSceneButtonAction(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(stage, 1000, 600);
        scene.getStylesheets().add("/styles/styles.css");
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    private void createTextFields(int x, ArrayList<Spinner> spinners){
        System.out.println(x);
        
        Spinner spinner = spinners.get(x);
        
        spinner.setNumFields(10);
        spinner.getNumFields();
        
        ArrayList<String> items = spinner.getFields();
        
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.getStyleClass().add("grid-pane");
        grid.setMinWidth(980);
        TextField textField[] = new TextField[items.size()];
        Label textLabel[] = new Label[items.size()];
        int column = 0;
        int row = 0;
        int labelNumber = 1;
        int labelCount = 0;
        int textFieldCount = 0;
        for(int i = 0; i < items.size() * 2; i++) {
            if(i % 4 == 0 && column != 0) {
                column = 0;
                row++;
            }
            if(i % 2 == 0) {
                textLabel[labelCount] = new Label("Item" + labelNumber + ":");
                textLabel[labelCount].getStyleClass().add("text-label");
                grid.setConstraints(textLabel[labelCount], column, row);
                grid.getChildren().add(textLabel[labelCount]);
                GridPane.setHalignment(textLabel[labelCount], HPos.RIGHT);
                labelCount++;
                labelNumber++;
            } else {
                textField[textFieldCount] = new TextField();
                grid.setConstraints(textField[textFieldCount], column, row);
                grid.getChildren().add(textField[textFieldCount]);
                textFieldCount++;
            }
            column++;
        }
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(10);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(10);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(25);
        grid.getColumnConstraints().addAll(column1, column2, column3, column4);
        gridContainer.setContent(grid);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.getProperty("user.dir");

        categoryComboBox.setPromptText("Select Category...");
        categoryComboBox.setItems(createString());
        categoryComboBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> createTextFields(categoryComboBox.getSelectionModel().getSelectedIndex(), loadALL()));
    }  
    
    public ObservableList<String> createString(){
        ArrayList<Spinner> spinnersArray = loadALL();
        int countArray = 0;
        countArray = spinnersArray.size();
        ArrayList<String> spinnerNames = new ArrayList<>();
        for (int i = 0; i < countArray; i++) {
            Spinner spinner = spinnersArray.get(i);
            System.out.println(spinner.getSpinnerName() + "HAH");
            spinnerNames.add(spinner.getSpinnerName());
        }
        
        ObservableList<String> categoryList = FXCollections.observableArrayList(spinnerNames);
        
        return categoryList;
    }
    
    public ArrayList<Spinner> loadALL() {
        return IOUtil.load();
    }
    
    
}
