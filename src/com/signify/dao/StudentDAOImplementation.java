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

import com.signify.bean.Student;
import com.signify.collections.StudentCollection;
import com.signify.constents.SQLConstants;
import com.signify.utils.DBUtils;

/**
 * @author hp
 *
 */
public class StudentDAOImplementation implements StudentDAOInterface {
	
//	JDBC driver name and database URL
    private Connection conn;
	public StudentDAOImplementation(Connection conn) {
        this.conn = conn;
    }

	  
	@Override
	public boolean registerDAO(Student student) throws SQLException 
	{
	       // conn = DBUtils.getConnection();
			String sql = "INSERT IGNORE INTO user (userId, password, userName, roleId) VALUES (?, ?, ?,?)";
	        PreparedStatement stmt = conn.prepareStatement(SQLConstants.RIGISTER_USER);
	        
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
	
	public boolean studentRegitration(int sid, int curr, String doj)  throws SQLException {
		String sql = "INSERT IGNORE INTO semesterregistration (studentId, semester, dateofRegistration) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, sid);
        stmt.setInt(2, curr);
        stmt.setString(3, doj);
        stmt.executeUpdate();
        
        System.out.println(
				"\nPRESS 1 TO SEE AVAILABLE COURSES\nPRESS 2 TO SELECT COURSES\nPRESS 3 TO GO BACK\n");
        Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			String sql1 = "select courseCode , courseName from courses where isOffered=?";
			stmt = conn.prepareStatement(sql1);
			stmt.setString(1, "yes");

			System.out.println("\nList Of Availabe Course:");
			System.out.println("\ncourseCode\t courseName\n");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String c_id = rs.getString("courseCode");
				String c_name = rs.getString("courseName"); 	

				System.out.println(c_id + "\t" + c_name);
			}
			rs.close();
			stmt.close();
			
			int i = 4,j=2;
			boolean f = true, g= true;
			System.out.println("Select Four Primary Courses: ");
			Scanner sc2 = new Scanner(System.in);
			while(f) {
				System.out.println("Enter CourseCode");
				String cCode = sc2.next();
				String sql2 = "INSERT IGNORE INTO registeredcourse (courseCode, semester, studentId, grade, paymentStatus) VALUES (?, ?, ?,?,?)";
		        PreparedStatement stmt2 = conn.prepareStatement(sql2);
		        
		        stmt2.setString(1, cCode);
		        stmt2.setInt(2, curr);
		        stmt2.setInt(3, sid);
		        stmt2.setString(4, "NULL");
		        stmt2.setInt(5, 0);
		        stmt2.executeUpdate();
		        i--;
		        if(i==0) {
		        	f = false;
		        	break;
		        }
			}
			System.out.println("Select Two Alternate Courses: ");
			while(g) {
				System.out.println("Enter CourseCode");
				String cCode = sc2.next();
				String sql3 = "INSERT IGNORE INTO registeredcourse (courseCode, semester, studentId, grade, paymentStatus) VALUES (?, ?, ?,?,?)";
		        PreparedStatement stmt3 = conn.prepareStatement(sql3);
		        
		        stmt3.setString(1, cCode);
		        stmt3.setInt(2, curr);
		        stmt3.setInt(3, sid);
		        stmt3.setString(4, "NULL");
		        stmt3.setInt(5, 0);
		        stmt3.executeUpdate();
		        j--;
		        if(j==0) {
		        	g = false;
		        	break;
		        }
			}
	        break;
		}
		case 2: {
//			int i = 4,j=2;
//			boolean flag = true;
//			System.out.println("Select Four Primary Courses: ");
//			while(flag) {
//				System.out.println("Enter CourseCode");
//				Scanner sc2 = new Scanner(System.in);
//				String cCode = sc.nextLine();
//				String sql3 = "INSERT IGNORE INTO registerdcourse (courseCode, semester, studentID, grade, paymentStatus) VALUES (?, ?, ?,?,?)";
//		        PreparedStatement stmt2 = conn.prepareStatement(sql3);
//		        
//		        stmt2.setString(1, cCode);
//		        stmt2.setInt(2, curr);
//		        stmt2.setInt(3, sid);
//		        stmt2.setString(4, "NULL");
//		        stmt2.setInt(5, 0);
//		        stmt2.executeUpdate();
//		        i--;
//		        if(i==0) break;
//			}
//			System.out.println("Select Two Alternate Courses: ");
//			while(flag) {
//				System.out.println("Enter CourseCode");
//				Scanner sc2 = new Scanner(System.in);
//				String cCode = sc.nextLine();
//				String sql3 = "INSERT IGNORE INTO registerdcourse (courseCode, semester, studentID, grade, paymentStatus) VALUES (?, ?, ?,?,?)";
//		        PreparedStatement stmt3 = conn.prepareStatement(sql3);
//		        
//		        stmt3.setString(1, cCode);
//		        stmt3.setInt(2, curr);
//		        stmt3.setInt(3, sid);
//		        stmt3.setString(4, "NULL");
//		        stmt3.setInt(5, 0);
//		        stmt3.executeUpdate();
//		        j--;
//		        if(j==0) break;
//			}
			break;
		}
		case 3: {
		     break;
		}
		default: {
			System.out.println("\nInvalid Input Received!\n");
			break;
		}
		}
		
        return true;
	}
	
	public void addStudentCourse() throws SQLException {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter Course Code:  ");
			String cCode = scan.nextLine();
			
			System.out.print("Enter Current Semester:  ");
			int  curr = scan.nextInt();
			
			System.out.print("Enter StudentId:  ");
			int  sid = scan.nextInt();
		
				String sql3 = "INSERT IGNORE INTO registeredcourse (courseCode, semester, studentId, grade, paymentStatus) VALUES (?, ?, ?,?,?)";
		        PreparedStatement stmt3 = conn.prepareStatement(sql3);
		        
		        stmt3.setString(1, cCode);
		        stmt3.setInt(2, curr);
		        stmt3.setInt(3, sid);
		        stmt3.setString(4, "NULL");
		        stmt3.setInt(5, 0);
		        stmt3.executeUpdate();
		        
		        return;
	}
	
	public void dropStudentCourse() throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Course Code:  ");
		String cCode = scan.nextLine();
		
		System.out.print("Enter StudentId:  ");
		int  sid = scan.nextInt();
	
			String sql3 = "delete from registeredcourse where courseCode = ? and studentId = ?";
	        PreparedStatement stmt3 = conn.prepareStatement(sql3);
	        stmt3.setString(1, cCode);
	        stmt3.setInt(2, sid);
            stmt3.executeUpdate();
	        
	        return;
}
	
//	public int addfees() {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		int total = 0;
//		
//		
// try {
//			        // Step 1: Establish a database connection
//			        conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//			String sql = "select studentId,semester from registeredcourses r inner join coursefee c on"
//					+ "r.courseCode=c.courseCode";
//			stmt = conn.prepareStatement(sql);
//
//			ResultSet rs = stmt.executeQuery(sql);
//			if (rs == null) {
//				System.out.println("No courses found!");
//			} else {
//				System.out.println("Course Code\t CourseName\t Course fee");
//				while (rs.next()) {
//					String coursecode = rs.getString("courseCode");
//					String coursename = rs.getString("courseName");
//					Integer fee = rs.getInt("coursefee");
//					total += fee;
//					System.out.println(coursecode + "\t" + coursename + "\t" + fee);
//				}
//			}
//
//			System.out.println("Total Fees : \t" + total + "\n");
//			rs.close();
//			stmt.close();
//			conn.close();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (SQLException se2) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//		return total;
//
//		// TODO Auto-generated method stub
//		
//	}

}


