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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static uei.PuchaseController.name_static;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Job_completedController implements Initializable {

    /**
     * Initializes the controller class.
     */
    dbcon db=new dbcon();
    private final ObservableList<completed_class> data =
        FXCollections.observableArrayList();
     @FXML
    private  TableView<completed_class> table_job;
     @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) table_job.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("home_new1.fxml"));
        String image = getClass().getResource("home.gif").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
      public static class completed_class{
 
        private final SimpleStringProperty job_no;
        private final SimpleStringProperty job_name;
         private final SimpleStringProperty completed_goods;
         private final SimpleStringProperty completed_date;

        public completed_class(String job_no, String job_name, String completed_goods, String completed_date) {
            this.job_no = new SimpleStringProperty(job_no);
            this.job_name = new SimpleStringProperty(job_name);;
            this.completed_goods =new SimpleStringProperty(completed_goods);
            this.completed_date =new SimpleStringProperty(completed_date);
                   
            
        }

        public String getJob_no() {
            return job_no.get();
        }

        public String getJob_name() {
            return job_name.get();
        }

        public String getCompleted_goods() {
            return completed_goods.get();
        }

        public String getCompleted_date() {
            return completed_date.get();
        }
         
         public void setJob_no(String fvalue) {
            job_no.set(fvalue);
        }

        public void setJob_name(String fvalue) {
             job_name.set(fvalue);
        }
 
        public void setCompleted_goods(String fvalue) {
             completed_goods.set(fvalue);
        }

        public void setCompleted_date(String fvalue) {
             completed_date.set(fvalue);
        }
         

      }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table_job.setEditable(true);
        
        TableColumn firstNameCol = new TableColumn("Job Number");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<completed_class, String>("job_no"));
 
        TableColumn lastNameCol = new TableColumn("Job Name");
        lastNameCol.setMinWidth(200);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<completed_class, String>("job_name"));
        TableColumn newNameCol = new TableColumn("Finished Goods");
        newNameCol.setMinWidth(100);
        newNameCol.setCellValueFactory(
                new PropertyValueFactory<completed_class, String>("completed_goods"));
        TableColumn NameCol = new TableColumn("Completed Date");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<completed_class, String>("completed_date"));
        int i=0,j=0;
        String sql_querry = "select * from job where completed_mark='"+1+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
    //   String date="12/12/2016";
        try {
            while(rs.next())
            {  
              
            data.add(new completed_class(rs.getString("job_no"),rs.getString("job_name"),Integer.toString(rs.getInt("completed_goods")),rs.getString("completed_date")));
               System.out.println(rs.getString("job_name"));
            //    System.out.println(date);
                 System.out.println(rs.getInt("completed_goods"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        table_job.setItems(data);
        table_job.getColumns().addAll(firstNameCol,lastNameCol,newNameCol,NameCol);
    }    
        
        
    }    
    

