/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uei;

import db.dbcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Add_new_productController implements Initializable {

    /**
     * Initializes the controller class.
     */
    dbcon db=new dbcon();
    @FXML
    TextField id,p_name,g_number;
    @FXML
    public void action_add()
    {
        String sql_querry = "INSERT INTO product_address (product_id,product_name,group_no) VALUES ('"+id.getText()+"','"+p_name.getText()+"' , '"+g_number.getText()+"')";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
             int   r = db.insert(sql_querry);
              if(r!=-1){ 
                     JOptionPane.showMessageDialog(null,"Inserted Succcessfully");
              
              }
            
    }
     @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) p_name.getScene().getWindow();
        
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
