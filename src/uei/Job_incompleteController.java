/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uei;

import com.sun.glass.events.MouseEvent;
import db.dbcon;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.T;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Job_incompleteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    dbcon db=new dbcon();
    @FXML
    public Label display;
    @FXML 
    public ComboBox combobox;
    @FXML
    PieChart piechart;
   
    
    @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) display.getScene().getWindow();
        
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
    public void action_button()
    {  
        ObservableList<Data> list =
        FXCollections.observableArrayList();
        String sql_querry = "select * from job where job_name='"+combobox.getSelectionModel().getSelectedItem().toString()+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
       //String date="12/12/2016";
        try {
            while(rs.next())
            {  
              
               list.add(new PieChart.Data("Remaining Goods -"+String.valueOf(rs.getInt("remaining_remaining"))+"",rs.getInt("remaining_remaining")));
               list.add(new PieChart.Data("Completed Goods -"+String.valueOf(rs.getInt("completed_goods"))+"",rs.getInt("completed_goods")));
              // System.out.println(rs.getString("job_name"));
                display.setText(rs.getString("cutoff_date"));
                
                 System.out.println(rs.getInt("completed_goods"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        } 
       piechart.setData(list);
       
       
       
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     String sql_querry = "select * from job where completed_mark='"+0+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
        try {
            while(rs.next())
            {
                combobox.getItems().add(rs.getString("job_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
        
        
        
        
    }    
    

