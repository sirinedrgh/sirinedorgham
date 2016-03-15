
package GoVoyage.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController implements Initializable {
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField pwd;
    
    @FXML
    private Label msg;
    
   
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }    
    
    @FXML
    private void loginAction(ActionEvent event){
        
    }
    
}
