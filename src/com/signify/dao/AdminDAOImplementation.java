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
		   static final String PASS = "root";
		   
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
				   Connection conn = null;
				   PreparedStatement stmt = null;
				   try{
					   Class.forName("com.mysql.jdbc.Driver");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);
					      
	
					      String sql="SELECT from courses values(?,?,?,?)";
					      sql = "SELECT coursecode, coursename ,isOffered, instructor FROM courses";
					      stmt = conn.prepareStatement(sql);
					      ResultSet rs = stmt.executeQuery(sql);
					      
					      System.out.printf(" Courses Offered by Institution %n");
					      System.out.printf("| %-8s | %-10s | %4s | %10s |%n", "CourseCode", "CourseName", "Offered","Instructor");
					      System.out.printf("--------------------------------%n");

					      while(rs.next()){
					        
					         String coursecode  = rs.getString("coursecode");
					         String coursename = rs.getString("coursename");
					         String isOffered = rs.getString("isOffered");
					         String instructor = rs.getString("instructor");
					         
					         System.out.printf("| %-8s | %-10s | %4s | %10s |%n", coursecode ,coursename, isOffered, instructor);

//					         System.out.print("CourseCode: " + coursecode);
//					         System.out.print(", CourseName: " + coursename);
//					         System.out.print(", Offered: " + isOffered);
//					         System.out.println(", Instructor: " + instructor);
					      }
					      System.out.printf("--------------------------------%n");
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
		}
		   
		   public void viewAdmins() {
				Connection conn = null;
				PreparedStatement stmt = null;
				try{
					   Class.forName("com.mysql.jdbc.Driver");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);
					      
	
					      String sql="SELECT * from user where roleId=?";
					      
					      stmt = conn.prepareStatement(sql);
					      stmt.setInt(1, 2);
					      ResultSet rs = stmt.executeQuery();
					      
					      System.out.printf(" List Of Admins %n");
					      System.out.printf("| %-10s | %-10s |%n", "AdminId", "AdminName");
					      System.out.printf("--------------------------------%n");

					      while(rs.next()){
					        
					         int adminId  = rs.getInt("userId");
					         String adminName = rs.getString("userName");
					         
					         System.out.printf("| %-10s | %-10s |%n", adminId ,adminName);

//					         System.out.print("CourseCode: " + coursecode);
//					         System.out.print(", CourseName: " + coursename);
//					         System.out.print(", Offered: " + isOffered);
//					         System.out.println(", Instructor: " + instructor);
					      }
					      System.out.printf("--------------------------------%n");
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
				}
		   }
		   
		   public void addProfessor() {
			   Connection conn = null;
			   PreparedStatement stmt_user = null;
			   PreparedStatement stmt_professor = null;
			   
			   Scanner scan = new Scanner(System.in);
			   System.out.print("Enter Name of Professor:  ");
			   String professorName = scan.nextLine();
				
				Scanner scan1 = new Scanner(System.in);
				System.out.print("Enter Professor ID:  ");
				int professorId = scan1.nextInt();
				
				System.out.print("Enter Password: ");
				Scanner scan2 = new Scanner(System.in);
				String password = scan2.nextLine();
				
				System.out.print("Enter Designation: ");
				Scanner scan3 = new Scanner(System.in);
				String designation = scan3.nextLine();
				
				System.out.print("Enter Department: ");
				Scanner scan4 = new Scanner(System.in);
				String department = scan4.nextLine();
				
//				System.out.print("Enter DOJ: ");
//				Scanner scan5 = new Scanner(System.in);
//				String professorDoj = scan5.nextLine();
			   
			   try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					
					String sql_user = "insert into user (userId, password ,username , roleId, isApproved) values(?,?,?,?,?)";
					
					String sql_professor = "insert into professor (professorName, professorId ,password , designation, department, DOJ) values(?,?,?,?,?,?)";
					stmt_user = conn.prepareStatement(sql_user);
					stmt_professor = conn.prepareStatement(sql_professor);

					String doj = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

					stmt_user.setInt(1, professorId);
					stmt_user.setString(2, password);
					stmt_user.setString(3, professorName);
					stmt_user.setInt(4, 3);
					stmt_user.setInt(5,1);
					stmt_user.executeUpdate();
					stmt_user.close();

					stmt_professor.setString(1, professorName);
					stmt_professor.setInt(2, professorId);
					stmt_professor.setString(3, password);
					stmt_professor.setString(4, designation);
					stmt_professor.setString(5, department);
					stmt_professor.setDate(6,Date.valueOf(doj));
					stmt_professor.executeUpdate();
					stmt_professor.close();
					
					System.out.println("Professor has been added successfully!! ");
					conn.close();
			   }
					
					 catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt_user != null)
							stmt_user.close();
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
		   
		   public void DropCourses(String courseCode)
		   {
			   Connection conn = null;
			   PreparedStatement stmt = null;
			   
			   try{
				   Class.forName("com.mysql.cj.jdbc.Driver");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				      String sql1="delete from courses where courseCode=" + "\""+courseCode+ "\"";
				      stmt = conn.prepareStatement(sql1);
				      stmt.executeUpdate();
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
				}

		   public String getCourseCode() {
			// TODO Auto-generated method stub
			return null;
		}

}
