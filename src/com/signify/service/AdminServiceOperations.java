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
 * @author pratik
 *
 */
public class AdminServiceOperations implements AdminInterface {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/crs";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	
	public void addAdmin() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter new Admin Name:  ");
		String userName = scan.nextLine();
		
		System.out.print("Enter new Admin Password:  ");
		String password = scan.next();
		
		System.out.print("Enter user ID:  ");
		int userId = scan.nextInt();
		
		AdminDAOInterface addAdminObj = new AdminDAOImplementation();
		addAdminObj.addAdmin(userName, password, userId);

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
	
	public void approveStudent() {
		AdminDAOInterface approveStudentObj = new AdminDAOImplementation();
		approveStudentObj.approveStudent();
	}
	
	public void viewCourseDetails() {
		AdminDAOImplementation viewCourseObj= new AdminDAOImplementation();
		viewCourseObj.viewCourses();
	}
	
	public void viewAdmins() {
		AdminDAOImplementation viewAdminObj= new AdminDAOImplementation();
		viewAdminObj.viewAdmins();
	}

	public void assignCourse() {
		System.out.println("Course assigned");
	}
	
	public void generateReportCard() {
		 System.out.println("Report Card is --->");
	}
	
}
