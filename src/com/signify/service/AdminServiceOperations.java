/**
 * 
 */
package com.signify.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.collections.AdminCollection;
import com.signify.collections.CourseCollection;
import com.signify.collections.ProfessorCollection;
import com.signify.collections.StudentCollection;
import com.signify.dao.AdminDAOImplementation;
import com.signify.dao.AdminDAOInterface;
import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;

/**
 * @author hp
 *
 */
public class AdminServiceOperations implements AdminInterface {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/crs";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "YogeshKingh123";
	
	public void addAd() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter new Admin Name:  ");
		String userName = scan.nextLine();
		
		System.out.print("Enter new Admin Password:  ");
		String password = scan.next();
		
		System.out.print("Enter user ID:  ");
		int userId = scan.nextInt();
		
		AdminDAOInterface obj = new AdminDAOImplementation();
		obj.addAdmin(userName, password, userId);

	}
	
	public void viewAdmins() {
		AdminDAOImplementation viewAdminObj= new AdminDAOImplementation();
		viewAdminObj.viewAdmins();
	}
	
//	public ProfessorCollection addProfessor() {
//		
//		Professor newProfessorObject = new Professor();
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Enter Name of Professor:  ");
//		String professorName = scan.nextLine();
//		
//		Scanner scan1 = new Scanner(System.in);
//		System.out.print("Enter user ID:  ");
//		int userId = scan1.nextInt();
//		
//		System.out.print("Enter Password: ");
//		Scanner scan2 = new Scanner(System.in);
//		String userPassword = scan2.nextLine();
//		
//		System.out.print("Enter Designation: ");
//		Scanner scan3 = new Scanner(System.in);
//		String professorDesignation = scan3.nextLine();
//		
//		System.out.print("Enter Department: ");
//		Scanner scan4 = new Scanner(System.in);
//		String professorDepartment = scan4.nextLine();
//		
//		System.out.print("Enter DOJ: ");
//		Scanner scan5 = new Scanner(System.in);
//		String professorDoj = scan5.nextLine();
//		
//		newProfessorObject.setName(professorName);
//		newProfessorObject.setUserId(userId);
//		newProfessorObject.setPassword(userPassword);
//		newProfessorObject.setDesignation(professorDesignation);
//		newProfessorObject.setDepartment(professorDepartment);
//		newProfessorObject.setDOJ(professorDoj);
//		
//		 System.out.println("Professor has been added...... Success !!");
//		
//		professorData.professorObject.add(newProfessorObject);
//		
//
//		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
//		{
////			Class.forName("com.mysql.jdbc.Driver");
//
//			ProfessorDAOInterface professorDao = new ProfessorDAOImplementation(conn);
//			boolean registered = professorDao.addProfessorDAO(newProfessorObject);
//			
//			if (registered) {
//				System.out.println("\nSuccess !! You are registered.....Redirecting to Main Menu\n");
//            } else {
//                System.out.println("Failed to register professor");
//            }
//		}
//		
//		catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//		professorData.professorObject.add(newProfessorObject);
//		
//		return professorData;
//	 
//	}
	
	public void assignCourse() {
		
		 System.out.println("Course assigned");
		 
	}
	
	public void approveStudent() {
	 
	 AdminDAOInterface adminobj = new AdminDAOImplementation();
	 adminobj.approveStudent();
		 
	}
	
	public void addProfessor() {
		AdminDAOInterface addProfObj = new AdminDAOImplementation();
		addProfObj.addProfessor();
	}
	
	
	public void addCourse() {
		AdminDAOInterface addCourseObj = new AdminDAOImplementation();
		addCourseObj.addCourse();
	}
	
	public void dropCourse(String courseCode) {
		
		AdminDAOImplementation dropCourseObj= new AdminDAOImplementation();
		dropCourseObj.dropCourses(courseCode);
	}
	
	
	public void viewCourseDetails() {
		AdminDAOImplementation viewCourseObj= new AdminDAOImplementation();
		viewCourseObj.viewCourses();
	}
	
	
	public void generateReportCard() {
		
		 System.out.println("Report Card is --->");
		 
	}


}
