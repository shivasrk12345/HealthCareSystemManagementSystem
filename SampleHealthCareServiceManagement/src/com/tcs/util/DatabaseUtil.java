package com.tcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tcs.exception.DataLayerException;

public class DatabaseUtil {
	
	
	

	private static final String DRIVER_NAME="oracle.jdbc.OracleDriver";
	 private static final String URL="jdbc:oracle:thin:@intvmoradb04:1521:ORAJAVADB";
	 private static final String USERNAME="TVM1718_TVM08_TJA54_DEV";
	 private static final String PASSWORD="tcstvm08";
	 
	 
	 public static Connection getConnection()
	 {
		 Connection con=null;
		 try {
			   Class.forName(DRIVER_NAME);
				con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			    System.out.println("Connection established");
		 } 
		 catch (ClassNotFoundException e) {
			 
				
				e.printStackTrace();
			}
		 catch (SQLException e) {
				
			 throw new DataLayerException(e.getMessage());
			}
		
	  
		 
		return con; 
		 
	 }
	 
	 public static void closeConnection(Connection con)
	 {
		 if(con!=null)
		 {
			 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e.getMessage());
			}
		 }
	 }
	 public static void closeStatement(PreparedStatement ps)
	 {
		 if(ps!=null)
		 {
			 try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DataLayerException(e.getMessage());
			}
		 }
	 }
	}

