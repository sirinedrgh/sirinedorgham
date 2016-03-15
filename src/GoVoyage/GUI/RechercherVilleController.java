/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoVoyage.GUI;

import GoVoyage.DAO.villeDAO;
import GoVoyage.ENTITIES.ville;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author sirine
 */


public class RechercherVilleController implements Initializable {

    @FXML
    private TextField rech;
    
    @FXML
    private Button add;
    
    @FXML
    ListView showPane;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void action(){
       String h;
       h=rech.getText();
       sir(h) ;
        
    }
    
            public void sir(String h){
         
        villeDAO ville = new villeDAO();

        ObservableList<Pane> pane = FXCollections.observableArrayList();
        ville listecircuit = ville.findvilleBynom(h);
     
       
                pane.add(getPaysInPane(listecircuit));
        
                showPane.setItems(pane);
                showPane.setSelectionModel(null);
           
    }
            
            
     public Pane getPaysInPane(ville c) {
         
        villeDAO ville = new villeDAO();
        Pane pane = new Pane();

        Label nomPays = new Label("Nom : " + c.getNom());
        nomPays.setLayoutX(5);
        nomPays.setLayoutY(5);

        Label capitalePays = new Label("Pays : " + c.getPays());
        capitalePays.setLayoutX(300);
        capitalePays.setLayoutY(5);

        Label languePays = new Label("latitude: " + c.getLatitude());
        languePays.setLayoutX(600);
        languePays.setLayoutY(5);
        
        Label lat = new Label("longitude : " + c.getLongitude());
        lat.setLayoutX(900);
        lat.setLayoutY(5);
        
        Label lon = new Label("Description: " + c.getDescription());
        lon.setLayoutX(1200);
        lon.setLayoutY(5);


        Button remove = new Button("Supprimer");
        remove.setLayoutX(1500);
        remove.setLayoutY(5);
        remove.getStyleClass().add("btn-danger");
        
        Button modif = new Button("MOdifier");
        modif.setLayoutX(1800);
        modif.setLayoutY(5);
        modif.getStyleClass().add("btn-danger");

        
        pane.getChildren().addAll(nomPays, capitalePays,languePays,lat ,lon,remove, modif);
        pane.setStyle("-fx-border-style: dotted; -fx-border-radius: 5px; -fx-padding: 5px; -fx-font-size: 16px;");

        return pane;
    }
        
    
}

    
    

