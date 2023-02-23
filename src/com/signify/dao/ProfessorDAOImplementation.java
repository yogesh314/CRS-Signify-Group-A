
	package com.signify.dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.utils.DBUtils;

	/**
	 * @author prati
	 *
	 */
	public class ProfessorDAOImplementation implements ProfessorDAOInterface{
		
		 private Connection conn;
		 
		 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/crs";

		   static final String USER = "root";
		   static final String PASS = "root";
		   
//			
			@Override
			public boolean addProfessorDAO(Professor professor) throws SQLException 
			{
				Connection conn = null;
					String sql = "INSERT IGNORE INTO user (userID, password, userName, roleId) VALUES (?, ?,?, ?)";
			        PreparedStatement stmt = conn.prepareStatement(sql);
			        
			        stmt.setLong(1, professor.getUserId());
			        stmt.setString(2, professor.getPassword());     
			        stmt.setString(3,professor.getName());
			        stmt.setLong(4, 3);
			        stmt.executeUpdate();
			               
		        
			        String sql2 = "INSERT IGNORE INTO professor (name, professorID, password, designation, department, DOJ) VALUES (?, ?, ?,?,?,?)";
			        PreparedStatement stmt2 = conn.prepareStatement(sql2);
			        stmt2.setString(1, professor.getName());
			        stmt2.setLong(2, professor.getUserId());
			        stmt2.setString(3, professor.getPassword());
			        stmt2.setString(4, professor.getDesignation());
			        stmt2.setString(5, professor.getDepartment());
			        stmt2.setString(6, professor.getDOJ());
			        stmt2.executeUpdate();
		 
		        
			        int rowsInserted = stmt.executeUpdate();
			        return rowsInserted > 0;
			}
			public void viewEnrolledStudents(int professorId) {
				
				Connection conn = null;
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;

				try {

					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					
					String sql = "select * from registeredcourse inner join professor on registeredcourse.courseCode = professor.courseCode where professorId = "+professorId;
					stmt = conn.prepareStatement(sql);					
					ResultSet rs = stmt.executeQuery(sql);
					
					System.out.printf(" List Of Students %n");
				    System.out.printf("| %-10s |%n", "StudentID");
				    System.out.printf("--------------------------------%n");

				    while(rs.next()){
				        
				    int studentId  = rs.getInt("studentID");
				    System.out.printf("| %-10s |%n", studentId);
				    }
				      
					rs.close();
					stmt.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null) {
							stmt.close();
						}
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e) {
						System.out.println("Exception " + e.getMessage());
					} finally {
					}
				}
			}
			public void addGrade(int professorId, int studentId, String grade) {
				String coursecode = "";
				
				Connection conn = null;
				PreparedStatement stmt = null;
				PreparedStatement stmt_s = null;

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					String sql = "select courseCode from professor where professorId = ?";
					String sql_grade = "update registeredcourse set grade = ? where studentID = ? and courseCode = ?";
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, professorId);
					ResultSet rs = stmt.executeQuery();
					
					stmt_s = conn.prepareStatement(sql_grade);
					while(rs.next()) {
						coursecode = rs.getString("courseCode");
					}
					
					rs.close();
					stmt.close();
					
					stmt_s.setString(1, grade);
					stmt_s.setInt(2, studentId);
					stmt_s.setString(3, coursecode);
					stmt_s.executeUpdate();
					stmt_s.close();

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

	}
