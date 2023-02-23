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
import com.signify.utils.DBUtils;

/**
 * @author hp
 *
 */
	public class UserDAOImplementation implements UserDAOInterface {
		
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/crs";

		   static final String USER = "root";
		   static final String PASS = "root";
		   private Connection conn;
		
		@SuppressWarnings("resource")
		public User loginDAO(int userId, String password)
		{
			Connection conn = null;
			   
			    PreparedStatement stmt = null;
			    ResultSet rs = null;
			    User user = null;
			    try {
			        conn = DriverManager.getConnection(DB_URL, USER, PASS);

			        stmt = conn.prepareStatement("SELECT * FROM user WHERE userID=? AND password=?");
			        stmt.setLong(1, userId);
			        stmt.setString(2, password);

			        rs = stmt.executeQuery();

			        if (rs.next()) {
			        	user = new User();
			        	
			            user.setUserId(rs.getInt(1));
			            user.setPassword(rs.getString(2));
			            user.setName(rs.getString(3));
			            user.setRole(rs.getInt(4));
			            user.setIsApproved(rs.getInt(5));
			        }
			        	 

			    } catch (SQLException e) {
			        e.printStackTrace();
			    } finally {
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
		        conn = DriverManager.getConnection(DB_URL, USER, PASS);

		        stmt = conn.prepareStatement("SELECT * FROM user WHERE userId=? AND password=?");
		        stmt.setLong(1, userId);
		        stmt.setString(2, password);

		        rs = stmt.executeQuery();

		        if (rs.next()) {
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
