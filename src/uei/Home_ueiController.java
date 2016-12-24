/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uei;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author NIRMAL
 */
public class Home_ueiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label head;
    @FXML
    public void action_graph() throws IOException
    {
        Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root =FXMLLoader.load(getClass().getResource("report_graph.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    } 
    
    @FXML
    public void add_report() throws IOException
    {
        Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root =FXMLLoader.load(getClass().getResource("add_report.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    } 
    @FXML
    public void action_purchase() throws IOException
    {
        Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root =FXMLLoader.load(getClass().getResource("purchase.fxml"));
        String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    } 
    @FXML
     public void action_job() throws IOException
    {
        Stage stage=(Stage) head.getScene().getWindow();
        
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
     public void action_add_product() throws IOException
    {
        Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("add_new_product1.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }   
       @FXML
     public void action_add_parts() throws IOException
    {
        Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("add_new_parts1.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }   
     @FXML
     public void action_completed() throws IOException
     {
          Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("job_completed2.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
      @FXML
     public void action_incomplete() throws IOException
     {
          Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("job_incomplete_2.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
     
      @FXML
     public void action_total() throws IOException
     {
          Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("total_work_status.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
     
     
     
      @FXML
     public void action_contact() throws IOException
     {
          Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("contact.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
    
     
      @FXML
     public void action_logout() throws IOException
     {
          Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
         String image = getClass().getResource("splash.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
     
   
    @FXML
    public void action_compare() throws IOException
     {
          Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("compare_employees.fxml"));
         String image = getClass().getResource("new.jpg").toExternalForm();
root.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     }
     @FXML
    public void action_emp() throws IOException
     {
          Stage stage=(Stage) head.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("add_new_emp.fxml"));
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
    }    
    
}
