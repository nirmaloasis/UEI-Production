/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uei;


import db.dbcon;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class IntroductionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    dbcon db=new dbcon();
    static String user_static;
    @FXML
    TextField username;
    @FXML
    PasswordField pass;
    @FXML
    Button sign;
// Date date;
//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
    public TextField getUsername() {
        return username;
    }

    public PasswordField getPass() {
        return pass;
    }
    
   


    

   
    @FXML
    public  void sign_action() throws Exception
    {   
        String sql="select * from login WHERE username='"+username.getText()+"' AND password='"+pass.getText()+"';";
    
       ResultSet rs = db.select(sql);
        if(rs.next())
      {     
//String formattedDate = sdf.format(date);
//System.out.println(formattedDate); 
            user_static=username.getText();
            Stage stage=(Stage) username.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("home_new1.fxml"));
         String image = getClass().getResource("home.gif").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"invalid username and password");
        }
         
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
 }    

   
}    
    

