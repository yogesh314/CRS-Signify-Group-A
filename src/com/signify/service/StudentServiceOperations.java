/**
 * 
 */
package com.signify.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.signify.bean.Student;
import com.signify.collections.StudentCollection;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;

/**
 * @author HP
 *
 */

public class StudentServiceOperations implements StudentInterface {
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/crs";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "YogeshKingh123";

	
	public StudentCollection studentData = new StudentCollection();
	
	public void changePassword() {
		
		System.out.println("password changed");
	}
	
	public StudentCollection getStudentData()
	{
		return studentData; 
	}
	
	public StudentCollection register() {
		
		Student newStudentObject = new Student();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter user ID:  ");
		int userId = scan.nextInt();
		
		System.out.print("Enter your Name:  ");
		Scanner scan1 = new Scanner(System.in);
		String  studentName = scan1.nextLine();
		
		System.out.print("Enter your Password: ");
		Scanner scan2 = new Scanner(System.in);
		String studentPassword = scan2.nextLine();
		
		System.out.print("Enter Student ID: ");
		Scanner scan3 = new Scanner(System.in);
		int studentId = scan3.nextInt();
		
		System.out.print("Enter Branch: ");
		Scanner scan4 = new Scanner(System.in);
		String studentBranch = scan4.nextLine();
		
		System.out.print("Enter Batch: ");
		Scanner scan5 = new Scanner(System.in);
		int studentBatch = scan5.nextInt();
		
		newStudentObject.setUserId(userId);
		newStudentObject.setName(studentName);
		newStudentObject.setPassword(studentPassword);
		newStudentObject.setRole(1);
		newStudentObject.setStudentId(studentId);
		newStudentObject.setRegistered(false);
		newStudentObject.setBranch(studentBranch);
		newStudentObject.setBatch(studentBatch);
		newStudentObject.setIsApproved(0);
		
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
		{
//			Class.forName("com.mysql.jdbc.Driver");

			StudentDAOInterface userDao = new StudentDAOImplementation(conn);
			boolean registered = userDao.registerDAO(newStudentObject);
			
			if (registered) {
				System.out.println("Failed to register user");
            } else {
                System.out.println("\nSuccess !! You are registered.....Redirecting to Main Menu\n");
            }
		}
		
		catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		
		
		studentData.studentObject.add(newStudentObject);
		
		
		return studentData;
		
//		System.out.println("Success !! Student registered");
	}
	
    public void viewGradeCard() {
    	System.out.println("Grade card can be viewed");
    }
    
public void registerCourses() {
		
		System.out.println("course registered");
	}
	
	public void addCourse() {
			
			System.out.println("courses added");
		}
	public void dropCourse() {
			
			System.out.println("courses dropped");
		}
	public void payFees() {
			
			System.out.println("Fees paid");
		}
	
	public void viewRegisteredCourses() {
		
		System.out.println("courses viewed");
	}
	
	
}
