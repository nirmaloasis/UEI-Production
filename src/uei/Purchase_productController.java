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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static uei.PuchaseController.date_static;
import static uei.PuchaseController.name_static;
import static uei.PuchaseController.no;
import static uei.PuchaseController.today;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Purchase_productController implements Initializable {

    /**
     * Initializes the controller class.
     */
    dbcon db=new dbcon();
    private final ObservableList<product_class> data =
        FXCollections.observableArrayList();
    @FXML
    Label req_date;
     @FXML
    private  TableView<product_class> table_product;
     @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) table_product.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("purchase.fxml"));
        String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
      public static class product_class{
 
        private final SimpleStringProperty part_name;
        private final SimpleStringProperty number;
         private final SimpleStringProperty date;

        public  product_class(String part_name, String number, String date) {
            this.part_name = new SimpleStringProperty(part_name);
            this.number =new SimpleStringProperty(number);
            this.date =new SimpleStringProperty(date);
        }

        public String getPart_name() {
            return part_name.get();
        }

        public String getNumber() {
            return number.get();
        }

        public String getDate() {
            return date.get();
        }
         public void setPart_name(String fvalue) {
            part_name.set(fvalue);
        }

        public void setNumber(String fvalue) {
             number.set(fvalue);
        }

        public void setDate(String fvalue) {
            date.set(fvalue);
        }
      
      
      
      }
      
      
        
        
        
        
        
        
        
        
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                table_product.setEditable(true);
                req_date.setText(today);
        
        TableColumn firstNameCol = new TableColumn("Parts Name");
        firstNameCol.setMinWidth(300);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<product_class, String>("part_name"));
 
        TableColumn lastNameCol = new TableColumn("Number");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<product_class, String>("number"));
        TableColumn newNameCol = new TableColumn("Cut off Date");
        newNameCol.setMinWidth(110);
        newNameCol.setCellValueFactory(
                new PropertyValueFactory<product_class, String>("date"));
        int i=0,j=0;
        String sql_querry = "select * from product_address where product_name='"+name_static+"'";
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
              j=j*(Integer.parseInt(no));
            data.add(new product_class(rs.getString("item_name"),Integer.toString(j),date_static));
               System.out.println(rs.getString("item_name"));
                System.out.println(j);
                 System.out.println(date_static);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuchaseController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        table_product.setItems(data);
        table_product.getColumns().addAll(firstNameCol,lastNameCol,newNameCol);
    }    
    
}
