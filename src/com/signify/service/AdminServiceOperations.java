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
	   static final String PASS = "root";
	
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
	
	public void addProfessor() {
		AdminDAOInterface addProfObj = new AdminDAOImplementation();
		addProfObj.addProfessor();
	}
	
	public void assignCourse() {
		System.out.println("Course assigned");
	}
	
	public void dropCourse(String courseCode) {
		
		AdminDAOImplementation DropCourse= new AdminDAOImplementation();
		DropCourse.DropCourses(courseCode);
	}
	
	public void approveStudent() {
		AdminDAOInterface adminobj = new AdminDAOImplementation();
		adminobj.approveStudent();
	}
	
	public void viewCourseDetails() {
		AdminDAOImplementation viewCourse= new AdminDAOImplementation();
		viewCourse.viewCourses();
	}
	
	public void viewAdmins() {
		AdminDAOImplementation viewAdmin= new AdminDAOImplementation();
		viewAdmin.viewAdmins();
	}
	
	public void generateReportCard() {
		 System.out.println("Report Card is --->");
	}
	
	
	
	
	
	
//	public CourseCollection addCourse(ProfessorCollection obj) {
//		
//		Course newCourseObject = new Course();
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Enter Course Code:  ");
//		String courseCode = scan.nextLine();
//		
//		System.out.print("Enter Course Name:  ");
//		Scanner scan1 = new Scanner(System.in);
//		String  courseName = scan1.nextLine();
//		
//		System.out.println("Is Course Being Offered ? ");
//		System.out.println("1. For Yes: Press 1 ");
//		System.out.println("2. For No: Press 2");
//		Scanner scan2 = new Scanner(System.in);
//		int courseOffered = scan2.nextInt();
//		
//		boolean isOffered = false; 
//		
//		if(courseOffered == 1)
//		{
//			isOffered = true;
//		}
//		else
//		{
//			isOffered = false;
//		}
//		
//		
//		System.out.print("Enter Name of Instructor: ");
//		Scanner scan3 = new Scanner(System.in);
//		String instructorName = scan3.nextLine();
//		
//		boolean isProfessorThere = false;
//		
//		for(int i=0;i<obj.professorObject.size();i++)
//		{
//			if(obj.professorObject.get(i).getName().equals(instructorName))
//			{
//				isProfessorThere=true;
//				break;
//			}
//			
//		}
//		
//		if(isProfessorThere==false)
//		{
//			System.out.print("\nProfessor Not Found !.. Try Again\n");
//			return courseData;
//		}
//		
//		newCourseObject.setCourseCode(courseCode);
//		newCourseObject.setName(courseName);
//		newCourseObject.setOffered(isOffered);
//		newCourseObject.setInstructor(instructorName);
//		
//		courseData.courseObject.add(newCourseObject);
//			
//		System.out.println("Course Added !");
//		
//		
//		return courseData;
//		}
//	
//	public CourseCollection deleteCourse(CourseCollection obj) {
//		
//		System.out.print("Enter Course ID to delete: ");
//		Scanner scan4 = new Scanner(System.in);
//		String courseToDelete = scan4.nextLine();
//		
//		boolean isDeleted = false;
//		
//		for(int i=0;i<obj.courseObject.size();i++)
//		{
//			System.out.println(obj.courseObject.get(i).getCourseCode());
//			if(obj.courseObject.get(i).getCourseCode().equals(courseToDelete))
//			{
//				obj.courseObject.remove(i);
//				System.out.println("Course Deleted !");
//				isDeleted = true;
//			}
//		
//		}
//		
//		if(isDeleted==false)
//		{
//			System.out.println("Course Not Found... Try Again");
//		}
//		
//		return courseData;
//		
//	}1
	
	
	
	
	
	


}
