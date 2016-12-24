/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uei;

import db.dbcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Compare_employeesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static String e1,e2,e3;
    static LocalDate s,e;
    dbcon db=new dbcon();
    @FXML
    DatePicker start,end;
    @FXML
    ComboBox emp_1,emp_2,emp_3;
   public void action_back() throws IOException
     {
          Stage stage=(Stage) start.getScene().getWindow();
        
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
       public void action_button() throws IOException
       {
                   e1=emp_1.getSelectionModel().getSelectedItem().toString();
        e2=emp_2.getSelectionModel().getSelectedItem().toString();
        e3=emp_3.getSelectionModel().getSelectedItem().toString();
       
        s=start.getValue();
        e=end.getValue();
            Stage stage=(Stage) emp_1.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("graph_compare.fxml"));
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
        // TODO
       
           String sql_querry = "select * from employee";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
        
        try {
            while(rs.next())
            {
                try { 
                    emp_1.getItems().add(rs.getString("emp_name"));
                    emp_2.getItems().add(rs.getString("emp_name"));
                    emp_3.getItems().add(rs.getString("emp_name"));
                  
                   // System.out.println("success");
                } catch (SQLException ex) {
                    Logger.getLogger(Add_reportController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("success");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Add_reportController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("success");
        }
        
       
        
    }    
    
}
