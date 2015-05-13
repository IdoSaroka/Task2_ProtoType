package SQL; // <- when you are copying the functions copy them with out this package it is only for the current use

import java.util.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlConnection {

	public static void main(String[] args) {

		/**Importent: Make sure you add the mySQL controller external jar file to the project before compiling otherwise you will get error: 
		 * No suitable driver found for jdbc:mysql://localhost/dbname**/
		try 
		{
          Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {/* handle the error*/}
        
        try 
        {
          // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","Braude"); // for the computers in the campus
        	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","123456"); //for my lap-top
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed\n");
     
           printFiles(conn);
           addNewValue(conn); 
            
        } catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
	}
	
	
	
	public static void createTableFiles(Connection conn){
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("create table files(fileName VARCHAR(25), path VARCHAR(50));");
			stmt.executeUpdate("load data local infile \"files.txt\" into table files"); 
		} catch (SQLException e) {	e.printStackTrace();}
	}
	
	
	public static void printFiles(Connection conn){
		 Statement stmt;
		   try{
		       stmt = conn.createStatement();
		       ResultSet rs = stmt.executeQuery("SELECT * FROM files;");
			   System.out.println("------------------Current files in the system:------------------");
		       while(rs.next()){
		    	   System.out.println("File Name: "+rs.getString(1)+"    File Path: "+rs.getString(2));
		       }
		       rs.close();
		       System.out.println("----------------------------------------------------------------\n");
		   }catch(SQLException e) {e.printStackTrace();
		   }  
	}
	
	public static void addNewValue(Connection conn){
		Statement stmt;
		try {
			stmt = conn.createStatement();
			
		} catch (SQLException e) {	e.printStackTrace();
		
		}
	}


/** -------------------------------Server Methods------------------------------------- **/	
	
/** -------------------------------Client Methods------------------------------------- **/
/** -------------------------------Client Methods------------------------------------- **/
}

