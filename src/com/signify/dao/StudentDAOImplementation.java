/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.bean.OnlinePayment;
import com.signify.bean.Payment;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.collections.StudentCollection;

/**
 * @author hp
 *
 */
public abstract class StudentDAOImplementation implements StudentDAOInterface {
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/crs";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
//	JDBC driver name and database URL
	 private Connection conn;
	public StudentDAOImplementation(Connection conn) {
        this.conn = conn;
    }
	  
	@Override
	public boolean registerDAO(Student student) throws SQLException 
	{
	       
			String sql = "INSERT IGNORE INTO user (userId, password, userName, roleId) VALUES (?, ?, ?,?)";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        
	        stmt.setLong(1, student.getUserId());
	        stmt.setString(2, student.getPassword());
	        stmt.setString(3, student.getName());
	        stmt.setLong(4, student.getRole());
	        stmt.executeUpdate();
	                
        
	        String sql2 = "INSERT IGNORE INTO student (userId, studentName, studentId, branch, batch) VALUES (?, ?, ?,?,?)";
	        PreparedStatement stmt2 = conn.prepareStatement(sql2);
	        stmt2.setLong(1, student.getUserId());
	        stmt2.setString(2, student.getName());
	        stmt2.setLong(3, student.getStudentId());
	        stmt2.setString(4, student.getBranch());
	        stmt2.setLong(5, student.getBatch());
	        stmt2.executeUpdate();
 
        
	        int rowsInserted = stmt.executeUpdate();
	        return rowsInserted > 0;
	}
	

	public int addfees() {
		Connection conn = null;
		PreparedStatement stmt = null;
		int total = 0;
		
		
 try {
			        // Step 1: Establish a database connection
			        conn = DriverManager.getConnection(DB_URL, USER, PASS);

			String sql = "select studentId,semester from registeredcourses r inner join coursefee c on"
					+ "r.courseCode=c.courseCode";
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);
			if (rs == null) {
				System.out.println("No courses found!");
			} else {
				System.out.println("Course Code\t CourseName\t Course fee");
				while (rs.next()) {
					String coursecode = rs.getString("courseCode");
					String coursename = rs.getString("courseName");
					Integer fee = rs.getInt("coursefee");
					total += fee;
					System.out.println(coursecode + "\t" + coursename + "\t" + fee);
				}
			}

			System.out.println("Total Fees : \t" + total + "\n");
			rs.close();
			stmt.close();
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
		return total;

		// TODO Auto-generated method stub
		
	}

}


