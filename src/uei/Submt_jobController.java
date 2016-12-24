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
import static javafx.beans.binding.Bindings.select;
import static javafx.beans.binding.Bindings.select;
import static javafx.beans.binding.Bindings.select;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static uei.JobController.product_name;
import static uei.JobController.target_static;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Submt_jobController implements Initializable {

    /**
     * Initializes the controller class.
     */
    dbcon db=new dbcon();
    int p=0;
    private final ObservableList<item_class> data =
        FXCollections.observableArrayList();
     ObservableList<PieChart.Data> list =
        FXCollections.observableArrayList();
     @FXML
    private TableView<item_class> table=new TableView<item_class>();
     @FXML
     TextField job_name;
     @FXML
     DatePicker cutoff;
     @FXML
    PieChart piechart;
     @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) job_name.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("job.fxml"));
        String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
    @FXML
    public void action_newjob() throws SQLException, IOException
    {
       String sql_querry = "SELECT MAX(job_no) FROM job";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
                while(rs.next())
                {
                p= rs.getInt(1);
                
                }
                ++p;
                sql_querry = "INSERT INTO job (job_no,job_name,target,completed_goods,remaining_remaining,cutoff_date,completed_mark) VALUES ('"+p+"' , '"+job_name.getText()+"' , '"+target_static+"' , '"+0+"' , '"+target_static+"' , '"+cutoff.getValue().toString()+"' , '"+0+"' )";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
             int   r = db.insert(sql_querry);
              if(r!=-1){Stage stage=(Stage) cutoff.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("finish_job1.fxml"));
        String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
              }
    }
     
      public static class item_class{
 
        private final SimpleStringProperty part_name;
        private final SimpleStringProperty number;
       
 
        item_class(String fName, String lName) {
            this.part_name= new SimpleStringProperty(fName);
            this.number = new SimpleStringProperty(lName);
            
        }

        public String getPart_name() {
            return part_name.get();
        }

        public String getNumber() {
            return number.get();
        }
        public void setPart_name(String fvalue) {
            part_name.set(fvalue);
        }

        public void setNumber(String fvalue) {
            number.set(fvalue);
        }
        
      
 
       
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table.setEditable(true);
        
        TableColumn firstNameCol = new TableColumn("Parts Name");
        firstNameCol.setMinWidth(300);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<item_class, String>("part_name"));
 
        TableColumn lastNameCol = new TableColumn("Number");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<item_class, String>("number"));
        int i=0,j=0;
        String sql_querry = "select * from product_address where product_name='"+product_name+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
        try {
            while(rs.next())
            {
                i=rs.getInt("group_no");
                System.out.println(Integer.toString(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
       sql_querry = "select * from partsdb where group_no='"+i+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                rs = db.select(sql_querry);
        try {
            while(rs.next())
            {  
              j=rs.getInt("no_required");
              j=j*(Integer.parseInt(target_static));
            data.add(new item_class(rs.getString("item_name"),Integer.toString(j)));
              list.add(new PieChart.Data(rs.getString("item_name"),j));  
            
            
            System.out.println(rs.getString("item_name"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        table.setItems(data);
        table.getColumns().addAll(firstNameCol,lastNameCol);
        
        
        
        
        //piechart
        
       
         
       piechart.setData(list);
        
        
        
        
        
        
        
        
        
        
    }    
    
}
