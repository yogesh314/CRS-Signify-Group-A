/**
 * 
 */
package com.signify.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;
import com.signify.dao.StudentDAOImplementation;
import com.signify.dao.StudentDAOInterface;

/**
 * @author hp
 *
 */

public class ProfessorServiceOperations implements ProfessorInterface{
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/crs";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "YogeshKingh123";
	   
 
	public void viewEnrollStudents(int professorId) {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
		{
//			Class.forName("com.mysql.jdbc.Driver");

			ProfessorDAOInterface Obj = new ProfessorDAOImplementation(conn);
			Obj.viewEnrolledStudents(professorId);

		}
		
		catch (SQLException ex) {
            ex.printStackTrace();
        }
			 
	}
		
	public void addGrade(int professorId) {
		
		 //ProfessorDAOInterface gradeObj = new ProfessorDAOImplementation();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))
		{
//			Class.forName("com.mysql.jdbc.Driver");
			ProfessorDAOInterface Obj = new ProfessorDAOImplementation(conn);
			Scanner scan = new Scanner(System.in);
			System.out.println("\nEnter student id: ");
			int sid = scan.nextInt();
			System.out.println("\nEnter grade: ");
			String grade = scan.next();
			Obj.addGrade(professorId,sid,grade);
			System.out.println("\nGrade Added");

		}
		
		catch (SQLException ex) {
            ex.printStackTrace();
        }
		

		
	}
	
	public void calculateCpi() {
		System.out.println("Cpi calculated");
	}

}
