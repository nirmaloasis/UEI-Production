/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uei;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class ContactController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button back;
     @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) back.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("home_new1.fxml"));
        String image = getClass().getResource("home.gif").toExternalForm();
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
