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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sirine
 */
public class AjouterVilleController implements Initializable {

    @FXML
    private TextField nom; 
    
    @FXML
    private ComboBox pays;
    
    @FXML
    private TextField latitude;
    
    @FXML
    private TextField longitude;
    
    @FXML
    private TextArea description;
    
    @FXML
    private TextField type;
    
    @FXML
    private ComboBox langue;
    
    @FXML
    private Button add;
   

        @FXML
    public void AjouterVille(ActionEvent event){
        
        ville h = new ville();
        villeDAO hd = new villeDAO();
        
 
        h.setNom(nom.getText());
        h.setPays(pays.getValue().toString());
        h.setLatitude(Double.parseDouble(latitude.getText())); 
        h.setLongitude(Double.parseDouble(longitude.getText()));
        h.setDescription(description.getText());
        
        h.setType(type.getText());
        h.setLangue(langue.getValue().toString());
        
        

       
        hd.insertVille(h);        
        
    }
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        ObservableList<String> sirina = FXCollections.<String>observableArrayList();
        sirina.add("France");
        sirina.add("Tunisie");
        sirina.add("Allemagne");
        sirina.add("Dubai");
        sirina.add("Italie");
        sirina.add("Espagne");
        sirina.add("Algerie");
        sirina.add("Australie");
        sirina.add("Belgique");
        sirina.add("Maroc");
        sirina.add("Chine");
        sirina.add("Irlande");
        sirina.add("Japon");
        sirina.add("Mexique");
        sirina.add("Portugal");
        sirina.add("Espagne");
        sirina.add("Suède");
        sirina.add("Suisse");
        sirina.add("Turquie");
        sirina.add("Thaïlande");
        
        pays.setItems(sirina);
        
        ObservableList<String> sirina2 = FXCollections.<String>observableArrayList();
        sirina2.add("Arabe");
        sirina2.add("Français");
        sirina2.add("Allemand");
        sirina2.add("brésilien");
        sirina2.add("Arabe");
        sirina2.add("Français");
        sirina2.add("Coreen");
        sirina2.add("Hindi");
        sirina2.add("Roumain");
        sirina2.add("Italien");
        
        langue.setItems(sirina2);
    }    
    
}
