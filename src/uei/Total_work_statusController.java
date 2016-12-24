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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Total_work_statusController implements Initializable {

    /**
     * Initializes the controller class.
     */
    dbcon db=new dbcon();
     @FXML
    PieChart piechart;
     @FXML
             Button g;
     ObservableList<PieChart.Data> list =
        FXCollections.observableArrayList();
    @FXML
    public void generate()
    {
        
         String sql_querry = "select * from employee";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
       //String date="12/12/2016";
        try {
            while(rs.next())
            {  
              
               list.add(new PieChart.Data(rs.getString("emp_name")+"-"+String.valueOf(rs.getInt("completed_work"))+" items",rs.getInt("completed_work")));
             
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        } 
       piechart.setData(list);
       g.setDisable(true);
        
    }    
    
        
    
             
     @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) piechart.getScene().getWindow();
        
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
