/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoVoyage.GUI;

import GoVoyage.DAO.villeDAO;
import GoVoyage.ENTITIES.ville;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author sirine
 */
public class AfficherListeVilleController implements Initializable {

    
    
    @FXML
    ListView villelist;
  
    @FXML
    Button homeBtn;

    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        villeDAO hd = new villeDAO();

        ObservableList<Pane> panes = FXCollections.observableArrayList();
        ArrayList<ville> listville = hd.displayAllvilles();

        for (int i = 0; i < listville.size(); i++) {
                
                panes.add(loadOneHotel(listville.get(i)));

                villelist.setItems(panes);
                villelist.setSelectionModel(null);
            }
        }

                
    

    
    private Pane loadOneHotel(ville v) {

        villeDAO DAO = new villeDAO();

        Pane pane = new Pane();
        Image img = new Image("/GoVoyage/IDAO/pays.png");
        ImageView imageView = new ImageView(img);

        // Pane Size
        pane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        pane.setPrefWidth(422);
        pane.setPrefHeight(114);
        String style = "-fx-padding: 8 15 15 15;\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-font-weight: bold;\n"
                + "    -fx-font-size: 1.1em;";
        pane.setStyle(style);
        pane.setId("pane_oneHotel");

        // ImageView Proprieties
        imageView.setFitHeight(65);
        imageView.setFitWidth(65);

        imageView.setLayoutX(14);
        imageView.setLayoutY(7);
        //setPicture(img, imageView);
        String style_btn = "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 0 0;\n"
                + "    -fx-background-radius: 8;\n"
                + "    -fx-font-size: 0.8em;";
        Label nom = new Label("nom :");
        Label nom_hotel = new Label(v.getNom());
        
        Label pays = new Label("Pays :");
        Label note = new Label(v.getPays());
        
        
        Label desc = new Label("Description :");
        Label description = new Label(v.getDescription());
        
        Label ty = new Label("Type:");
        Label type = new Label(v.getType());
        
        Label lan = new Label("Langue :");
        Label langue = new Label(v.getLangue());
        
        Button btn = new Button("Visiter");
        btn.getStyleClass().add("btn-primary");


            // Label Proprieties
        //nom_pays.setPrefSize(314, 61);
        nom.setLayoutX(93);
        nom.setLayoutY(7);
        nom_hotel.setLayoutX(200);
        nom_hotel.setLayoutY(7);
        nom_hotel.setId("nom_Hotel");

        
        pays.setLayoutX(93);
        pays.setLayoutY(25);
        note.setLayoutX(200);
        note.setLayoutY(25);
        
        desc.setLayoutX(93);
        desc.setLayoutY(40);
        description.setLayoutX(200);
        description.setLayoutY(40);
        
        ty.setLayoutX(93);
        ty.setLayoutY(60);
        type.setLayoutX(200);
        type.setLayoutY(60);
        
        
        lan.setLayoutX(93);
        lan.setLayoutY(80);
        langue.setLayoutX(200);
        langue.setLayoutY(80);

        // Button Position
        btn.setLayoutX(341);
        btn.setLayoutY(78);
        btn.setId("btn_visiter");
        btn.setStyle(style_btn);
        

        pane.getChildren().add(imageView);
        pane.getChildren().add(nom);
        pane.getChildren().add(nom_hotel);
        pane.getChildren().add(pays);
        pane.getChildren().add(note);
        pane.getChildren().add(desc);
        pane.getChildren().add(description);
        pane.getChildren().add(ty);
        pane.getChildren().add(type);
        pane.getChildren().add(lan);
        pane.getChildren().add(langue);
        pane.getChildren().add(btn);

        return pane;

        
    } 
    
  
}
