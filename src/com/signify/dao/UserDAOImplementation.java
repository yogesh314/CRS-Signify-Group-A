/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.signify.bean.User;

/**
 * @author hp
 *
 */
	public class UserDAOImplementation implements UserDAOInterface {
		
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/crs";

		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "YogeshKingh123";
		
		@SuppressWarnings("resource")
		public User loginDAO(int userId, String password)
		{
			   Connection conn = null;
			    PreparedStatement stmt = null;
			    ResultSet rs = null;
			    User user = null;
//			    boolean success = false;

			    try {
			        // Step 1: Establish a database connection
			        conn = DriverManager.getConnection(DB_URL, USER, PASS);

			        // Step 2: Prepare the query
			        stmt = conn.prepareStatement("SELECT * FROM user WHERE userID=? AND password=?");
			        stmt.setLong(1, userId);
			        stmt.setString(2, password);

			        // Step 3: Execute the query
			        rs = stmt.executeQuery();

			        // Step 4: Process the result
			        if (rs.next()) {
			            // Login successful
//			        	success = true;
			        	user = new User();
			        	
//			        	System.out.println(rs.getInt(1));
			            user.setUserId(rs.getInt(1));
			            user.setPassword(rs.getString(2));
			            user.setName(rs.getString(3));
			            user.setRole(rs.getInt(4));
			            user.setIsApproved(rs.getInt(5));
			        }
			        	 

			    } catch (SQLException e) {
			        e.printStackTrace();
			    } finally {
			        // Step 5: Close the resources
			        try {
			            rs.close();
			            stmt.close();
			            conn.close();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }

			    return user;
			}
		
		public boolean updatepasswordDAO(int userId, String password) {
			Connection conn = null;
		    PreparedStatement stmt = null;
		    PreparedStatement stmt2 = null;
		    ResultSet rs = null;
		    ResultSet rs1 = null;
		    User user = null;
		    boolean success = false;

		    try {
		        // Step 1: Establish a database connection
		        conn = DriverManager.getConnection(DB_URL, USER, PASS);

		        // Step 2: Prepare the query
		        stmt = conn.prepareStatement("SELECT * FROM user WHERE userId=? AND password=?");
		        stmt.setLong(1, userId);
		        stmt.setString(2, password);

		        // Step 3: Execute the query
		        rs = stmt.executeQuery();

		        // Step 4: Process the result
		        if (rs.next()) {
		            // Login successful
//		        	success = true;
//		        	user = new User();
		        	Scanner scan = new Scanner(System.in);
		        	System.out.print("Enter New Password: ");
		        	String newPassword = scan.nextLine();
		        	
		        	stmt2 = conn.prepareStatement("UPDATE user SET password = ? WHERE userId=? ");
			        stmt2.setString(1, newPassword);
			        stmt2.setInt(2, userId);
			        stmt2.executeUpdate();

		        	success = true;
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        // Step 5: Close the resources
		        try {
		            rs.close();
		            stmt.close();
		            conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		  
		  return success;

}
	}
