/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoVoyage.TEST;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sirine
 */
public class test extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/GoVoyage/GUI/ListeVilleDash.fxml"));
     //Parent root = FXMLLoader.load(getClass().getResource("/GoVoyage/GUI/AfficherListeVille.fxml"));
      //Parent root = FXMLLoader.load(getClass().getResource("/GoVoyage/GUI/AjouterVille.fxml"));
      //Parent root = FXMLLoader.load(getClass().getResource("/GoVoyage/GUI/RechercherVille.fxml"));
      Scene scene = new Scene(root);
      
      primaryStage.setTitle("sirine");// nom de la palete
      primaryStage.setScene(scene); 
      primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
