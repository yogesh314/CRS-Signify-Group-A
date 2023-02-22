/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author HP
 *
 */
public class AdminDAOImplementation implements AdminDAOInterface {
	/**
	 * @param args
	 */
	
	// Step 1
		// JDBC driver name and database URL
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/crs";

		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "YogeshKingh123";
	
		   public static void main(String[] args) {
		   }
		   
		   public void approveStudent() {
				Scanner sc = new Scanner(System.in);
				Connection conn = null;
				PreparedStatement stmt = null;
				PreparedStatement stmt_1 = null;
				PreparedStatement stmt_2 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					String sql = "select userId , userName from user where isApproved=?";
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, 0);

					System.out.println("\nUserId\t userName\n");
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {

						int u_id = rs.getInt("userId");
						String u_name = rs.getString("userName"); 	

						System.out.println(u_id + "\t" + u_name);
					}
					rs.close();
					stmt.close();

					System.out.println(
							"\nPRESS 1 TO APPROVE ALL STUDENTS\nPRESS 2 TO APPROVE STUDENT BY ID\nPRESS 3 TO GO BACK\n");
					int choice = sc.nextInt();
					switch (choice) {
					case 1: {
						String sql_1 = "update user set isApproved=?";
						stmt_1 = conn.prepareStatement(sql_1);
						stmt_1.setInt(1, 1);
						stmt_1.executeUpdate();
						stmt_1.close();
						break;
					}
					case 2: {
						System.out.print("\nEnter Student ID to Approve: ");
						int u_id = sc.nextInt();
						String sql_2 = "update user set isApproved=? where userId=" + u_id;
						stmt_2 = conn.prepareStatement(sql_2);
						stmt_2.setInt(1, 1);
						stmt_2.executeUpdate();
						stmt_2.close();
						break;
					}
					case 3: {
						return;
					}
					default: {
						System.out.println("\nInvalid Input Received!\n");
						break;
					}
					}

					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se2) {
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
		   }
		   
		   public void addAdmin(String username, String password, int userId) {
				Connection conn = null;
				PreparedStatement stmt = null;
				PreparedStatement stmt_id = null;
				PreparedStatement stmt_admin = null;
				int id = -1;

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					String sql = "insert into user (userId, password,username,roleID, isApproved) values(?,?,?,?,?)";
					String sql_id = "select userId from user where userName=" + "\"" + username + "\"" + " and password="
							+ "\"" + password + "\"";
					String sql_admin = "insert into admin values(?,?)";
					stmt = conn.prepareStatement(sql);
					stmt_id = conn.prepareStatement(sql_id);
					stmt_admin = conn.prepareStatement(sql_admin);

					String doj = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

					stmt.setInt(1, userId);
					stmt.setString(2, password);
					stmt.setString(3, username);
					stmt.setInt(4, 2);
					stmt.setInt(5,1);
					stmt.executeUpdate();
					stmt.close();

					ResultSet rs = stmt_id.executeQuery(sql_id);

					while (rs.next()) {
						id = rs.getInt("userId");
					}

					stmt_id.close();

					stmt_admin.setInt(1, id);
					stmt_admin.setDate(2,Date.valueOf(doj));
					stmt_admin.executeUpdate();
					stmt_admin.close();

					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se2) {
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
			}
		   
		   public void viewCourses() {
				// Step 2 
				// Declare the Coneection or prepaidstatement variable here 
				   Connection conn = null;
				   PreparedStatement stmt = null;
				   
				   try{
					   
					   // Step 3 Regiater Driver here and create connection 
					   
					   Class.forName("com.mysql.jdbc.Driver");

					   // Step 4 make/open  a connection 
					   
					      System.out.println("Connecting to database...");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);
					   
					      //STEP 4: Execute a query
					      System.out.println("View Course Details...");
					     // String sql="insert into employee values(?,?,?,?)";
					      String sql="SELECT from courses values(?,?,?,?)";
					      //String sql = "UPDATE Employees set age=? WHERE id=?";
					     // String sql1="delete from employee where id=?";
					     // stmt.setInt(1, 101);
					      stmt = conn.prepareStatement(sql);
					   
					      // Hard coded data 
//					      
//					      int id=629;
//					      String name="Vabhav";
//					      String address="Delhi";
//					      String location="india";
//					      //Bind values into the parameters.
//					      stmt.setInt(1, id);  // This would set age
//					      stmt.setString(2,name);
//					      stmt.setString(3, address);
//					      stmt.setString(4, location);
//					      stmt.executeUpdate();
//					           
					   
					   
					   
					   // Let us update age of the record with ID = 102;
//					      int rows = stmt.executeUpdate();
//					      System.out.println("Rows impacted : " + rows );

					      // Let us select all the records and display them.
					      sql = "SELECT coursecode, coursename ,isOffered, instructor FROM courses";
					      ResultSet rs = stmt.executeQuery(sql);

					      //STEP 5: Extract data from result set
					      while(rs.next()){
					         //Retrieve by column name
					         String coursecode  = rs.getString("coursecode");
					         String coursename = rs.getString("coursename");
					         String isOffered = rs.getString("isOffered");
					         String instructor = rs.getString("instructor");

					         //Display values
					         System.out.print("CourseCode: " + coursecode);
					         System.out.print(", CourseName: " + coursename);
					         System.out.print(", Offered: " + isOffered);
					         System.out.println(", Instructor: " + instructor);
					      }
					      //STEP 6: Clean-up environment
					     // rs.close();
					      stmt.close();
					      conn.close();
					   }catch(SQLException se){
					      //Handle errors for JDBC
					      se.printStackTrace();
					   }catch(Exception e){
					      //Handle errors for Class.forName
					      e.printStackTrace();
					   }finally{
					      //finally block used to close resources
					      try{
					         if(stmt!=null)
					            stmt.close();
					      }catch(SQLException se2){
					      }// nothing we can do
					      try{
					         if(conn!=null)
					            conn.close();
					      }catch(SQLException se){
					         se.printStackTrace();
					      }//end finally try
					   }//end try
					   System.out.println("Goodbye!");
					}//end main

		public String getCourseCode() {
			// TODO Auto-generated method stub
			return null;
		}

}
