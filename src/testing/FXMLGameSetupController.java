/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mecic
 */
public class FXMLGameSetupController implements Initializable {

    @FXML
    public void mainSceneButtonAction(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(stage, 1000, 600);
        scene.getStylesheets().add("/styles/styles.css");
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    public void inGameSceneButtonAction(ActionEvent event) throws IOException {
        Parent stage = FXMLLoader.load(getClass().getResource("FXMLInGame.fxml"));
        Scene scene = new Scene(stage, 1000, 600);
        scene.getStylesheets().add("/styles/styles.css");
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
