package com.sms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection con = null;
	  
   
    public static Connection getConnection()
    
    {
    	 if(con==null)
    	    {
    	        String url = "jdbc:mysql:// localhost:3306/sms";
    	        String user = "root";
    	        String pass = "batheJa6271@";
    	        try {
    	            Class.forName("com.mysql.cj.jdbc.Driver");
    	            con = DriverManager.getConnection(url, user, pass);
    	        }
    	        catch (ClassNotFoundException | SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	 
    	
    	return con;
    }
	
    
	
}

