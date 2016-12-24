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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 


/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class PuchaseController implements Initializable
{

    /**
     * Initializes the controller class.
     */
    static String type,date_static,name_static,no,today;
    dbcon db=new dbcon();
    @FXML
    TextField items;
    @FXML
    DatePicker date,date_today;
    
    

    @FXML
    public Button req;

    public String getType() {
        return type;
    }

    public TextField getItems() {
        return items;
    }

    public DatePicker getDate() {
        return date;
    }

    public ComboBox getCombo_name() {
        return combo_name;
    }
  
    @FXML 
    public ComboBox combobox;
    @FXML 
    public ComboBox combo_name;
    @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) combo_name.getScene().getWindow();
        
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
    public void action_type() throws SQLException
    {
        type=combobox.getSelectionModel().getSelectedItem().toString();
        if(type.equals("Parts"))
                {      
                    String sql_querry = "select * from partsdb";
                    //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
                    ResultSet rs = db.select(sql_querry);
                    while(rs.next())
                    {  
                    combo_name.getItems().add(rs.getString("item_name"));
                    }
                }
        else if(type.equals("Product"))
                {   combo_name.getItems().clear();
                    String sql_querry = "select * from product_address";
                    //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
                    ResultSet rs = db.select(sql_querry);
                    while(rs.next())
                    {   
                    combo_name.getItems().add(rs.getString("product_name"));
                 }  
                }
        }
    
         
     
    /**
     *
     */
   
        
        
    
  /*  @FXML
    public void action_parts()
    {
        type="parts";
        button_product.setDisable(true);
        
    }*/

    /**
     *
     */
    /*@FXML
    public void action_product()
    {
        type="product";
        button_parts.setDisable(true);
    }*/

    /**
     *
     * @throws SQLException
     */
   
     
     


    /**
     *
     * @throws java.io.IOException
     */
  @FXML
  public void action_request() throws IOException
    {
        switch (combobox.getSelectionModel().getSelectedItem().toString()) {
            case "Parts":
                {   
                    date_static=date.getValue().toString();
                    no=items.getText();
                    name_static=combo_name.getSelectionModel().getSelectedItem().toString();
                    today=date_today.getValue().toString();
                    
                    Stage stage=(Stage) items.getScene().getWindow();
                    
                   
                    Parent root =FXMLLoader.load(getClass().getResource("purchase_parts_1.fxml"));
                   String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
                    Scene scene = new Scene(root);
                    
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
            case "Product":
                {    name_static=combo_name.getSelectionModel().getSelectedItem().toString();
                      no=items.getText();
                      date_static=date.getValue().toString();
                      today=date_today.getValue().toString();
                      
                    Stage stage=(Stage) items.getScene().getWindow();
                    Parent root =FXMLLoader.load(getClass().getResource("purchase_product_2.fxml"));
                    String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    break;
                }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //    combobox.getItems().clear();
        combobox.getItems().addAll("Parts","Product"); 
          String sql_querry = "select * from partsdb";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
        try {
            while(rs.next())
            {
                combo_name.getItems().add(rs.getString("item_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
   
                     
        
     
}

    
}
