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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Add_reportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    int j_num=0;
    dbcon db=new dbcon();
    @FXML
   public ComboBox combobox;
    @FXML
    public ComboBox combo_job;
    @FXML
    Button add;
    @FXML
    TextField number;
    @FXML
    DatePicker dp;
     @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) dp.getScene().getWindow();
        
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
    public void action_add() throws SQLException
    { int i=0,comp_goods=0,remaining_goods=0,c=0;
    
    String e_id = null;
     String sql_querry = "select * from job where job_name='"+combo_job.getSelectionModel().getSelectedItem().toString()+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                ResultSet rs = db.select(sql_querry);
        
            while(rs.next())
            {
                j_num=rs.getInt("job_no");
                comp_goods=rs.getInt("completed_goods");
                remaining_goods=rs.getInt("remaining_remaining");
                c=rs.getInt("completed_mark");
                
                
            } 
        
            if(c==1)
            {
                JOptionPane.showMessageDialog(null,"It is a Completed Job");   
            }
            else
            {
            comp_goods=comp_goods+Integer.parseInt(number.getText());
            remaining_goods=remaining_goods-Integer.parseInt(number.getText());
            if(remaining_goods==0)
            {    
                sql_querry = "update job set completed_goods='"+comp_goods+"',remaining_remaining='"+remaining_goods+"',completed_mark='"+1+"' ,completed_date='"+dp.getValue().toString()+"' where job_name='"+combo_job.getSelectionModel().getSelectedItem().toString()+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
               int  j= db.update(sql_querry);
        
            if(j!=-1)
            {
               JOptionPane.showMessageDialog(null,"JOB COMPLETED SUCCESSFULLY");
            } 
                
                
                
                
            }
            else
            {
                
                sql_querry = "update job set completed_goods='"+comp_goods+"',remaining_remaining='"+remaining_goods+"',completed_mark='"+0+"' where job_name='"+combo_job.getSelectionModel().getSelectedItem().toString()+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
               int  j= db.update(sql_querry);
        
            if(j!=-1)
            {
               //JOptionPane.showMessageDialog(null,"JOB COMPLETED SUCCESSFULLY");
            } 
                
                
                
                
                
            }
              sql_querry = "select * from employee where emp_name='"+combobox.getSelectionModel().getSelectedItem().toString()+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                 rs = db.select(sql_querry);
        
            while(rs.next())
            {
                i=rs.getInt("completed_work");
                e_id=rs.getString("emp_id");
            } 
            i=i+Integer.parseInt(number.getText());
            
          sql_querry = "update employee set completed_work='"+i+"' where emp_name='"+combobox.getSelectionModel().getSelectedItem().toString()+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
               int  j= db.update(sql_querry);
        
            if(j!=-1)
            {
               System.out.println("success");
            } 
            
            sql_querry = "select * from report where comp_date='"+dp.getValue()+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                 rs = db.select(sql_querry);
        
            if(rs.next())
            {
                j=rs.getInt("comp_amt");
                j=j+Integer.parseInt(number.getText());
                  
          sql_querry = "update report set comp_amt='"+j+"' where emp_name='"+combobox.getSelectionModel().getSelectedItem().toString()+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                j= db.update(sql_querry);
        
            if(j!=-1)
            {
               System.out.println("success");
                JOptionPane.showMessageDialog(null,"Updated Succcessfully");
            } 
                
            } 
            else
            {
            
            sql_querry = "INSERT INTO report (job_name,job_no,emp_id,emp_name,comp_date,comp_amt) VALUES ('"+combo_job.getSelectionModel().getSelectedItem().toString()+"','"+j_num+"' , '"+e_id+"','"+combobox.getSelectionModel().getSelectedItem().toString()+"','"+dp.getValue()+"', '"+number.getText()+"'  )";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
             int   r = db.insert(sql_querry);
              if(r!=-1){ 
                     JOptionPane.showMessageDialog(null,"Inserted Succcessfully");
              
              }         
            }
            
            }  
         add.setDisable(true);
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
                    combobox.getItems().add(rs.getString("emp_name"));
                    System.out.println("success");
                } catch (SQLException ex) {
                    Logger.getLogger(Add_reportController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("success");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Add_reportController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("success");
        }
         
            
         sql_querry = "select * from job where completed_mark='"+0+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
            
                rs = db.select(sql_querry);
       
        try {
            while(rs.next())
            {
                try {
                    combo_job.getItems().add(rs.getString("job_name"));
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
