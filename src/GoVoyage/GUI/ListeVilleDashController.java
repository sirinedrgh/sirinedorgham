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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author sirine
 */
public class ListeVilleDashController implements Initializable {
    
    @FXML
    ListView showPane;
  


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setVillePane(); //
    }    
    
    
    public void setVillePane() {
        villeDAO ville = new villeDAO();
        ArrayList<ville> listeville = ville.displayAllvilles();
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        for (int i = 0; i < listeville.size(); i++) {
            panes.add(getVilleInPane(listeville.get(i)));
        }

        showPane.setItems(panes);
        showPane.setSelectionModel(null);

       
    }
    
    
        public Pane getVilleInPane(ville P) {
        villeDAO pays = new villeDAO();
        Pane pane = new Pane();

        Label nom = new Label("Nom : " + P.getNom());
        nom.setLayoutX(5);
        nom.setLayoutY(5);

        Label Pays = new Label("Pays : " + P.getPays());
        Pays.setLayoutX(200);
        Pays.setLayoutY(5);
   /*     
        Label latitude = new Label("latitude : " + P.getLatitude());
        Pays.setLayoutX(700);
        Pays.setLayoutY(5);
        
        Label longitude = new Label("longitude : " + P.getLongitude());
        Pays.setLayoutX(500);
        Pays.setLayoutY(5);
        

*/
        Label description = new Label("Description : " + P.getDescription());
        description.setLayoutX(350);
        description.setLayoutY(5);
       
        Label type = new Label("Type : " + P.getType());
        type.setLayoutX(550);
        type.setLayoutY(5);

        Label languePays = new Label("Langue : " + P.getLangue());
        languePays.setLayoutX(750);
        languePays.setLayoutY(5);

        Button remove = new Button("Supprimer");
        remove.setLayoutX(950);
        remove.setLayoutY(5);
        remove.getStyleClass().add("btn-danger");
        
        Button update = new Button("Modifier");
        update.setLayoutX(1050);
        update.setLayoutY(5);
        update.getStyleClass().add("btn-danger");

        remove.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
               pays.deleteVille(P.getId());
                setVillePane();
            }
        });
        
          update.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
 
                System.out.println("sirine");
                setEditvillePane(P);
                
            }
        });

        pane.getChildren().addAll(nom ,Pays,description,type,languePays, remove, update);
        pane.setStyle("-fx-border-style: dotted; -fx-border-radius: 5px; -fx-padding: 5px; -fx-font-size: 16px;");

        return pane;
        
    }
      public void setEditvillePane(ville c) {
        ObservableList<Pane> panes = FXCollections.observableArrayList();
        panes.add(modifPane(c));
        showPane.setItems(panes);
        showPane.setSelectionModel(null);

  

    }  
      
        
        
    public Pane modifPane(ville c){
        villeDAO crDAO = new villeDAO();
        Pane pane = new Pane();

        Label nom = new Label("Nom ville");
        nom.setLayoutX(50);
        nom.setLayoutY(50);

        TextField nomP = new TextField(c.getNom());
        nomP.setPromptText("Nom de pays . . .");
        nomP.setLayoutX(200);
        nomP.setLayoutY(50);
 

        Label Pays = new Label("Nom Pays");
        Pays.setLayoutX(50);
        Pays.setLayoutY(100);

       TextField PaysP = new TextField(c.getNom());
        PaysP.setPromptText("Nom de ville . . .");
        PaysP.setLayoutX(200);
        PaysP.setLayoutY(100);
        

       

        Label latitude = new Label("Latitude");
        latitude.setLayoutX(50);
        latitude.setLayoutY(150);

        TextField latitudeP = new TextField(String.valueOf(c.getLatitude()));
        latitudeP.setPromptText("latitudeP. . .");
        latitudeP.setLayoutX(200);
        latitudeP.setLayoutY(150);

        
        Label longitude = new Label("longitude");
        longitude.setLayoutX(50);
        longitude.setLayoutY(200);

        TextField longitudeP = new TextField(String.valueOf(c.getLongitude()));
        longitudeP.setPromptText("Nouveau longitude . . .");
        longitudeP.setLayoutX(200);
        longitudeP.setLayoutY(200);
       
         Label description = new Label("description");
        description.setLayoutX(50);
        description.setLayoutY(250);

         TextArea  descriptionP = new  TextArea (c.getDescription());
        descriptionP.setPromptText("nouvelle description. . .");
        descriptionP.setPrefWidth(300);
        descriptionP.setPrefHeight(90);
        descriptionP.setLayoutX(200);
        descriptionP.setLayoutY(250);
        
      
   
        
        Label type = new Label("type");
        type.setLayoutX(50);
        type.setLayoutY(350);

        TextField typeP = new TextField(c.getType());
        typeP.setPromptText("Nouveau type . . .");
        typeP.setLayoutX(200);
        typeP.setLayoutY(350);
        
        Label langue = new Label("langue");
        langue.setLayoutX(50);
        langue.setLayoutY(400);

        TextField langueP = new TextField(c.getLangue());
        langueP.setPromptText("Nouvelle langue . . .");
        langueP.setLayoutX(200);
        langueP.setLayoutY(400);
        
        
        
       
        
        Button edit = new Button("Modifier");
        edit.getStyleClass().add("btn-success");
        edit.setLayoutX(200);
        edit.setLayoutY(500);
       
        
        TextField si = new TextField(c.getNom());
        si.setPrefWidth(80); 
        si.setPrefHeight(40);
        si.setLayoutX(200);
        si.setLayoutY(500);
         //
        Label info = new Label();
        info.setLayoutX(200);
        info.setLayoutY(20);

        edit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                ville c = new ville();

                c.setNom(nomP.getText());
                c.setPays(PaysP.getText());
                c.setLatitude(Double.parseDouble(latitudeP.getText()));
                c.setLongitude(Double.parseDouble(longitudeP.getText()));
                c.setDescription(descriptionP.getText());
                c.setType(typeP.getText());
                c.setLangue(langueP.getText());
                c.setId(crDAO.findvilleBynom(si.getText()).getId());
                crDAO.updateVille(c);

                System.out.println(c.toString());

                if (crDAO.updateVille(c)) {
                    System.out.println("succes");
                    info.setText("Modification Efféctué!");
                    info.getStyleClass().add("label-success");
                }

            }
        });

        pane.getChildren().addAll(nom,nomP,Pays, PaysP,latitude,latitudeP,longitude,longitudeP,description,descriptionP,type,typeP,langue,langueP,si,edit, info);
      
        pane.setStyle("-fx-font-size: 18px;");

        return pane;
    }
      
}
