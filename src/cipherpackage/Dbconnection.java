/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherpackage;

/**
 *
 * @author user
 */
import java.sql.*;
import java.sql.DriverManager;

public class Dbconnection {
    public Connection con;
    public Dbconnection()
    {
        try{
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
            System.out.println("connection");
        }
        catch(Exception e)
        {
            System.out.println("Exception::::"+e);
        }
    }
    
    public static void main(String[] args) 
    {
     new Dbconnection();   
    }
    
}
