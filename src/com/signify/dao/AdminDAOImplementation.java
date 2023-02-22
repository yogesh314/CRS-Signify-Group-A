/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HP
 *
 */
public class AdminDAOImplementation {
	/**
	 * @param args
	 */
	
	// Step 1
		// JDBC driver name and database URL
		   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/crs";

		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "root";
	
		   public static void main(String[] args) {
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
		   public void DropCourses(String courseCode)
		   {
			   Connection conn = null;
			   PreparedStatement stmt = null;
			   
			   try{
				   
				   // Step 3 Regiater Driver here and create connection 
				   
				   Class.forName("com.mysql.cj.jdbc.Driver");

				   // Step 4 make/open  a connection 
				   
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);
				   
				    
				     String sql1="delete from courses where courseCode=" + "\""+courseCode+ "\"";
				     
				    
				      stmt = conn.prepareStatement(sql1);
				   
				      // Hard coded data 
//				      
//				      int id=629;
//				      String name="Vabhav";
//				      String address="Delhi";
//				      String location="india";
//				      //Bind values into the parameters.
//				      stmt.setInt(1, id);  // This would set age
//				      stmt.setString(2,name);
//				      stmt.setString(3, address);
//				      stmt.setString(4, location);
//				      stmt.executeUpdate();
//				           
				   
				   
				   
				   // Let us update age of the record with ID = 102;
//				      int rows = stmt.executeUpdate();
//				      System.out.println("Rows impacted : " + rows );

				      // Let us select all the records and display them.
				     // sql = "SELECT coursecode, coursename ,isOffered, instructor FROM courses";
				      //ResultSet rs = stmt.executeQuery(sql1);
				      	stmt.executeUpdate();
				      //STEP 5: Extract data from result set
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
