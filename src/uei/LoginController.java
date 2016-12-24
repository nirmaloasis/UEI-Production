/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uei;

import com.mysql.jdbc.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
    @FXML
    Label comp_name;
 
    
    @FXML        
    Label department;
     
  
    
    @FXML
    Button button_log;      
     @FXML
  public  void login_action() throws Exception
    {
        Stage stage=(Stage) department.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("introduction.fxml"));
        String image = getClass().getResource("admin.png").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
