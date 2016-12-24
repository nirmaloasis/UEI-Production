/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uei;

import db.dbcon;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class JobController implements Initializable {

    /**
     * Initializes the controller class.
     */
    dbcon db=new dbcon();
    static String target_static;
    static String product_name;
    @FXML
    public ComboBox combo_product;
    @FXML
    TextField target;
     public ComboBox getCombo_product() {
        return combo_product;
    }

    public TextField getTarget() {
        return target;
    }
    @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) target.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("home_new1.fxml"));
        String image = getClass().getResource("home.gif").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
    @FXML
    void action_submit() throws IOException
    {
      target_static=target.getText();
      product_name=combo_product.getSelectionModel().getSelectedItem().toString();
       Stage stage=(Stage) target.getScene().getWindow();
                    Parent root =FXMLLoader.load(getClass().getResource("submit_2.fxml"));
                    String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
      
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       
          String sql_querry = "select * from product_address";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
        try {
            while(rs.next())
            {
                combo_product.getItems().add(rs.getString("product_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    

   
    
}
