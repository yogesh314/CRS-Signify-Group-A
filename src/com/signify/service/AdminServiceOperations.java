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
	
	public CourseCollection courseData = new CourseCollection();
	
	public AdminCollection adminData = new AdminCollection();
	public ProfessorCollection professorData = new ProfessorCollection();
	
	public AdminCollection getAdminData()
	{
		return adminData; 
	}
	
	public CourseCollection getCourseData()
	{
		return courseData; 
	}
	
public ProfessorCollection addProfessor() {
		
		Professor newProfessorObject = new Professor();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Name of Professor:  ");
		String professorName = scan.nextLine();
		
		Scanner scan1 = new Scanner(System.in);
		System.out.print("Enter user ID:  ");
		int userId = scan1.nextInt();
		
		System.out.print("Enter Password: ");
		Scanner scan2 = new Scanner(System.in);
		String userPassword = scan2.nextLine();
		
		System.out.print("Enter Designation: ");
		Scanner scan3 = new Scanner(System.in);
		String professorDesignation = scan3.nextLine();
		
		System.out.print("Enter Department: ");
		Scanner scan4 = new Scanner(System.in);
		String professorDepartment = scan4.nextLine();
		
		System.out.print("Enter DOJ: ");
		Scanner scan5 = new Scanner(System.in);
		String professorDoj = scan5.nextLine();
		
		newProfessorObject.setName(professorName);
		newProfessorObject.setUserId(userId);
		newProfessorObject.setPassword(userPassword);
		newProfessorObject.setDesignation(professorDesignation);
		newProfessorObject.setDepartment(professorDepartment);
		newProfessorObject.setDOJ(professorDoj);
		
		 System.out.println("Professor has been added...... Success !!");
		
		professorData.professorObject.add(newProfessorObject);
		

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
		{
//			Class.forName("com.mysql.jdbc.Driver");

			ProfessorDAOInterface professorDao = new ProfessorDAOImplementation(conn);
			boolean registered = professorDao.addProfessorDAO(newProfessorObject);
			
			if (registered) {
				System.out.println("\nSuccess !! You are registered.....Redirecting to Main Menu\n");
            } else {
                System.out.println("Failed to register professor");
            }
		}
		
		catch (SQLException ex) {
            ex.printStackTrace();
        }
		professorData.professorObject.add(newProfessorObject);
		
		return professorData;
	 
	}
	
	public void assignCourse() {
		
		 System.out.println("Course assigned");
		 
	}
	
	public void approveStudent() {
//		
//		for(int i=0;i<obj.studentObject.size();i++)
//		{
//			if(obj.studentObject.get(i).get)
//		}
//		
//		
		 System.out.println("Student approved");
		 
	}
	
	public CourseCollection addCourse(ProfessorCollection obj) {
		
		Course newCourseObject = new Course();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Course Code:  ");
		String courseCode = scan.nextLine();
		
		System.out.print("Enter Course Name:  ");
		Scanner scan1 = new Scanner(System.in);
		String  courseName = scan1.nextLine();
		
		System.out.println("Is Course Being Offered ? ");
		System.out.println("1. For Yes: Press 1 ");
		System.out.println("2. For No: Press 2");
		Scanner scan2 = new Scanner(System.in);
		int courseOffered = scan2.nextInt();
		
		boolean isOffered = false; 
		
		if(courseOffered == 1)
		{
			isOffered = true;
		}
		else
		{
			isOffered = false;
		}
		
		
		System.out.print("Enter Name of Instructor: ");
		Scanner scan3 = new Scanner(System.in);
		String instructorName = scan3.nextLine();
		
		boolean isProfessorThere = false;
		
		for(int i=0;i<obj.professorObject.size();i++)
		{
			if(obj.professorObject.get(i).getName().equals(instructorName))
			{
				isProfessorThere=true;
				break;
			}
			
		}
		
		if(isProfessorThere==false)
		{
			System.out.print("\nProfessor Not Found !.. Try Again\n");
			return courseData;
		}
		
		newCourseObject.setCourseCode(courseCode);
		newCourseObject.setName(courseName);
		newCourseObject.setOffered(isOffered);
		newCourseObject.setInstructor(instructorName);
		
		courseData.courseObject.add(newCourseObject);
			
		System.out.println("Course Added !");
		
		
		return courseData;
		}
	
	public CourseCollection deleteCourse(CourseCollection obj) {
		
		System.out.print("Enter Course ID to delete: ");
		Scanner scan4 = new Scanner(System.in);
		String courseToDelete = scan4.nextLine();
		
		boolean isDeleted = false;
		
		for(int i=0;i<obj.courseObject.size();i++)
		{
			System.out.println(obj.courseObject.get(i).getCourseCode());
			if(obj.courseObject.get(i).getCourseCode().equals(courseToDelete))
			{
				obj.courseObject.remove(i);
				System.out.println("Course Deleted !");
				isDeleted = true;
			}
		
		}
		
		if(isDeleted==false)
		{
			System.out.println("Course Not Found... Try Again");
		}
		
		return courseData;
		
	}
	
	public void viewCourseDetails() {
		AdminDAOImplementation viewCourse= new AdminDAOImplementation();
		System.out.println("\nCOURSES");
		System.out.print("==========================================\n");
		viewCourse.viewCourses();
		}
	
	public void generateReportCard() {
		
		 System.out.println("Report Card is --->");
		 
	}


}
