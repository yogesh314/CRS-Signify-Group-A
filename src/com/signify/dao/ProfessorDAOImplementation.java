
	package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	import com.signify.bean.Professor;
    import com.signify.service.ProfessorInterface;

	/**
	 * @author prati
	 *
	 */
	public class ProfessorDAOImplementation implements ProfessorDAOInterface{
		
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   static final String DB_URL = "jdbc:mysql://localhost/crs";

		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "YogeshKingh123";
		
		 private Connection conn;
			public ProfessorDAOImplementation(Connection conn) {
		        this.conn = conn;
		    }
			
			@Override

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
				PreparedStatement stmt1 = null;
				PreparedStatement stmt_s = null;
				PreparedStatement stmt_s1 = null;

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

//					String sql1 = "select courseCode from professor where professorId = ?";
//					String sql_grade1 = "INSERT IGNORE INTO user (userId, password, userName, roleId) VALUES (?, ?, ?,?)";
//					stmt1 = conn.prepareStatement(sql1);
//					stmt.setInt(1, professorId);
//					ResultSet rs1 = stmt1.executeQuery();
//					
//					stmt_s1 = conn.prepareStatement(sql_grade1);
//					while(rs.next()) {
//						coursecode = rs1.getString("courseCode");
//					}
//					
//					rs1.close();
//					stmt1.close();
//					
//					stmt_s1.setString(1, grade);
//					stmt_s1.setInt(2, studentId);
//					stmt_s1.setString(3, coursecode);
//					stmt_s1.executeUpdate();
//					stmt_s.close();

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
