/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author mecic
 */
public class Testing extends Application {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        launch(args);
        
        /////////* TESTING STUFF *///////////
        ////////*****************///////////
        
        // load the spinners if it exists
        ArrayList<Spinner> spinners = IOUtil.load();
        
        getSpinnerNames(spinners);

        System.out.println("Create a new Spinner!");
        System.out.println();
        // get info for new spinner object
        //String name = Console.getString("What would you like to name the Spinner?: ");
        //int numberFields = Console.getInt("How many slots do you want for this Spinner?: ");
        
        // create spinner object from user input
        //Spinner spinner = new Spinner(name, numberFields);
        //ArrayList <String> fields = new ArrayList<>();
        
        //getFieldContent(numberFields, fields);
        
        //spinner.setField(fields); // save fields to spinner object
        //spinners.add(spinner); // add spinner object to arraylist
        //IOUtil.save(spinners);        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        primaryStage.setTitle("Spinner Of Doom");
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add("/styles/styles.css");
        
        String musicFile = "src/media/Underworld.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private static void getFieldContent(int numberFields, ArrayList<String> fields) {
        // get field info from user
        //for (int i = 0; i < numberFields; i++) {
        //    String field = Console.getString("Field " + (i+1) + ": ");
        //    fields.add(field);
        //} 
    } // end getFieldContent method
    
    private static void getSpinnerNames(ArrayList<Spinner> spinners) {
        // display spinner names
        int numSpinners = spinners.size();
        
        for (int i = 0; i < numSpinners; i++) {
            Spinner spinner = spinners.get(i);
            System.out.println(spinner.getSpinnerName());
        }
    } // end getSpinnerNames method
}
