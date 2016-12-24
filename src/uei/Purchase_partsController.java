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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static uei.IntroductionController.user_static;
import static uei.PuchaseController.date_static;
import static uei.PuchaseController.name_static;
import static uei.PuchaseController.no;
import static uei.PuchaseController.today;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Purchase_partsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    dbcon db = new dbcon();
  //DateFormat df=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//  
//   Date date;
//    
    
    
    
   // Calendar cal=new Calender();
    //PuchaseController pc=new PuchaseController();
    //IntroductionController ic=new IntroductionController();
    @FXML
    Label part_name,part_code,part_date,emp_id,emp_name,dept,part_no,req_date;
  
    @FXML
    public void action_back() throws IOException
     {
          Stage stage=(Stage) part_name.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("purchase.fxml"));
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
      
       part_date.setText(date_static);
        part_name.setText(name_static);
        part_no.setText(no);
        req_date.setText(today);
 
          // String abc=
     
//       
//       
//       
     String sql_querry = "select * from partsdb where item_name='"+name_static+"'";
    // String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
//     
     ResultSet rs = null;
     try{         
     rs = db.select(sql_querry);
     }catch(NullPointerException ex){
         System.out.println("db null pointeer");
     }
        try {
            while(rs.next())
            {
               
                part_code.setText(rs.getString("item_code"));
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Purchase_partsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       // String u_name=ic.getUsername().toString();
        
             sql_querry = "select * from login where username='"+user_static+"'";
            //String sql_querry = "select * from tbl_students where name like '%"+search_name+"%'";
           try{
                rs = db.select(sql_querry); 
           }
           catch(NullPointerException ex)
           {
               System.out.println("db null pointeer 2222");
           }
        try {
            while(rs.next())
            {
                
                emp_id.setText(rs.getString("emp_id"));
                emp_name.setText(rs.getString("emplyee_name"));
                dept.setText(rs.getString("department"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Purchase_partsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
    
}
 