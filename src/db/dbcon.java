/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NIRMAL
 */
public class dbcon {
public  Connection con =null;
public  Statement stmt=null;
public ResultSet rs=null;
    public dbcon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/uei_ltd", "root", "wiser2010");
        stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(dbcon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int insert(String sql)
    {
        int r=0;
        try
        {
            r=stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return r;
    }
    
 public ResultSet select(String sql){
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(dbcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        }
 public int update(String sql){
     int a=0;
        try {
            a = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(dbcon.class.getName()).log(Level.SEVERE, null, ex);
        }
     return a;
 }
}
    

