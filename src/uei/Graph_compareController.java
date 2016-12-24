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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static uei.Compare_employeesController.e;
import static uei.Compare_employeesController.e1;
import static uei.Compare_employeesController.e2;
import static uei.Compare_employeesController.e3;
import static uei.Compare_employeesController.s;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Graph_compareController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    dbcon db=new dbcon();
    Date d;
    int i=0,j=0,ans=0;
    @FXML
    LineChart<String,Number> linechart;
    @FXML
    Button generate;
     @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) generate.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("compare_employees.fxml"));
        String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
    //
    
    
     @FXML
    public void action_graph() throws SQLException
    {
        linechart.getData().clear();
        XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series1=new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series2=new XYChart.Series<String,Number>();
           String sql_querry = "SELECT DATEDIFF('"+e+"','"+s+"') AS DiffDate";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
        
            while(rs.next())
            {
                
               i=rs.getInt("DiffDate");
            } 
         
          if(i<0)
          {
               JOptionPane.showMessageDialog(null,"Enter the date Properly");   
          }
          else
          {
              
              sql_querry = "insert into dummy(date_add2,no) values('"+s+"' ,'"+1+"')" ;
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
               int r = db.insert(sql_querry);
        
             if(r!=-1)
             {
                
                
             }  
              
            while(i>-1)
            {
             
                
                
                sql_querry ="SELECT DATE_ADD(date_add2,INTERVAL '"+j+"' DAY)  FROM dummy";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                 rs = db.select(sql_querry);
        
             if(rs.next())
             { //System.out.println("kunna");
                d=rs.getDate(1);
                //System.out.println("kunna4");
                //System.out.println(d.toString());
             }
             
               sql_querry = "select * from report where comp_date='"+d+"' and emp_name='"+e1+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                 rs = db.select(sql_querry);
        
            if(rs.next())
            {
             ans=rs.getInt("comp_amt");
            } 
             else
            {
                ans=0;
            }
             series.getData().add(new XYChart.Data<String,Number>(d.toString(),ans));
             //
            sql_querry = "select * from report where comp_date='"+d+"' and emp_name='"+e2+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                 rs = db.select(sql_querry);
        
            if(rs.next())
            {
             ans=rs.getInt("comp_amt");
            } 
             else
            {
                ans=0;
            }
             series1.getData().add(new XYChart.Data<String,Number>(d.toString(),ans)); 
             
             //
             
             
             sql_querry = "select * from report where comp_date='"+d+"' and emp_name='"+e3+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                 rs = db.select(sql_querry);
        
            if(rs.next())
            {
             ans=rs.getInt("comp_amt");
            } 
             else
            {
                ans=0;
            }
             series2.getData().add(new XYChart.Data<String,Number>(d.toString(),ans));
             
            i--; 
            j++;
            
            }
              
              
             sql_querry = "delete from dummy where no='"+1+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                 r = db.insert(sql_querry);
        
//            if(r!=-1)
//            {
//             System.out.println(rs.getInt("polayadi"));
//            }  
//        
           series.setName(e1);
          series1.setName(e2);
           series2.setName(e3);
          linechart.getData().addAll(series,series1,series2);
          generate.setDisable(true);
          
          }
          
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
