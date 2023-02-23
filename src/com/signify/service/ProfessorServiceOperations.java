/**
 * 
 */
package com.signify.service;

import java.util.Scanner;

import com.signify.dao.ProfessorDAOImplementation;
import com.signify.dao.ProfessorDAOInterface;

/**
 * @author hp
 *
 */
public class ProfessorServiceOperations implements ProfessorInterface{
	ProfessorDAOInterface Obj = new ProfessorDAOImplementation();
	Scanner scan = new Scanner(System.in);
	public void viewEnrollStudents(int professorId) {
		 System.out.println("\nEnrolled students are -->");
		 //ProfessorDAOInterface enrolledStudentsObj = new ProfessorDAOImplementation();
		 //Scanner scan = new Scanner(System.in);
		 Obj.viewEnrolledStudents(professorId);
	}
	public void addGradeService(int professorId) {
	
		 //ProfessorDAOInterface gradeObj = new ProfessorDAOImplementation();
		System.out.println("\nEnter student id: ");
		int sid = scan.nextInt();
		System.out.println("\nEnter grade: ");
		String grade = scan.next();
		 Obj.addGrade(professorId,sid,grade);
		System.out.println("\nGrade Added");
	};
	
	public void calculateCpi() {
		System.out.println("Cpi calculated");
	}
	
}
