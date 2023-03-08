package com.signify.service;

import com.signify.bean.*;
import com.signify.dao.AdminDAOImplementation;
import com.signify.exception.*;

import helper.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author dp201
 *
 */
public class AdminServiceOperation extends UserServiceOperation implements AdminInterface {

	public AdminDAOImplementation adi = new AdminDAOImplementation();
	
	/** 
	 * Method to listOfUnapprovedStudents
	 * @param 
	 * @return List
	 */

	public List<Student> listOfUnapprovedStudents() {
		return adi.listOfUnapprovedStudents();
	}

	
	/** 
	 * Method to approveAllStudents
	 * @param  
	 * @return void 
	 */
	
	public void approveAllStudents() {
		adi.approveAllStudents();
		return;
	}
	
	/** 
	 * Method to approveAllStudentById
	 * @param studentid
	 * @return void
	 * @throws StudentNotFoundForVerificationException
	 */
	
	public void approveStudentById(String studentid) {
		try {
			adi.approveStudentById(studentid);
		} catch (StudentNotFoundForVerificationException e) {
			System.out.println(e.getMessage());
		}
		return;
	}

	/** 
	 * Method to addProfessor
	 * @param  p
	 * @return void
	 * @throws ProfessorNotAddedException, UserAlreadyExistException
	 */
	
	
	public void addProfessor(Professor newProfessor) {
		try {
			adi.addProfessor(newProfessor);
			System.out.println("\nNEW PROFESSOR ADDED TO DB SUCCESSFULLY!\n");
		} catch (ProfessorNotAddedException | UserAlreadyExistException e) {
			System.out.println(e.getMessage());
		}
		return;
	}
	
	/** 
	 * Method to viewProfessors
	 * @param  
	 * @return List 
	 */

	public List<Professor> viewProfessors() {
		return adi.viewProfessors();
	}

	/** 
	 * Method to viewAdmins
	 * @param  
	 * @return List
	 */
	
	public List<Admin> viewAdmins() {
		return adi.viewAdmins();
	}

	/** 
	 * Method to assignProfessorToCourse
	 * @param  professorid,courseCode
	 * @return void
	 * @throws CourseNotAssignedToProfessorException
	 */
	
	public void assignProfessorToCourse(String professorId, String courseCode) {
		try {
			adi.assignProfessorToCourse(professorId, courseCode);
			System.out.println("\nProfessor Assigned To Course Successfully!\n");
		} catch (CourseNotAssignedToProfessorException e) {
			System.out.println(e.getMessage());
		}
	}

	/** 
	 * Method to  addAdmin
	 * @param  a
	 * @return void
	 * @throws UserAlreadyExistException
	 */
	
	public void addAdmin(Admin newAdmin) {
		try {
			adi.addAdmin(newAdmin);
			System.out.println("\nNEW ADMIN ADDED TO DB SUCCESSFULLY!\n");

		} catch (UserAlreadyExistException e) {
			System.out.println(e.getMessage());
		}

		return;
	}

	/** 
	 * Method to addCourse
	 * @param  c
	 * @return void
	 * @throws AddCourseException, ProfessorNotFoundException, CourseFoundException
	 */
	
	public void addCourse(Course c) {
		try {
			adi.addCourse(c);
			System.out.println("\nCOURSE ADDED TO CATALOG SUCCESSFULLY!\n");
		} catch (CourseFoundException | ProfessorNotFoundException | AddCourseException e) {
			System.out.println(e.getMessage());
		}
		return;
	}
	
	/** 
	 * Method to removeCourse
	 * @param  courseCode
	 * @return void
	 * @throws CourseNotFoundException, CourseNotDeletedException
	 */

	public void removeCourse(String courseCode) {
		try {
			adi.removeCourse(courseCode);
			System.out.println("\nCOURSE REMOVED FROM CATALOG SUCCESSFULLY!\n");
		} catch (CourseNotFoundException | CourseNotDeletedException e) {
			System.out.println(e.getMessage());
		}
		return;
	}
	
	/** 
	 * Method to viewCourseDetails
	 * @param  courseCode
	 * @return void
	 * @throws CourseNotFoundException
	 */

	public Course viewCourseDetails(String courseCode) {
		Course c = null;
		try {
			c = adi.viewCourseDetails(courseCode);
		} catch (CourseNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return c;
	}


	/** 
	 * Method to calculateCpi
	 * @param  studentid
	 * @return void
	 * @throws StudentNotRegisteredException
	 */
	
	public void calculateCpi(String studentid) {
		double cpi = 0.0;
		try {
			cpi = adi.calculateCpi(studentid);
			System.out.print("\nTHE CPI FOR STUDENT WITH STUDENT ID \""+studentid+"\" IS "+cpi+"\n\n");
		} catch (StudentNotRegisteredException e) {
			System.out.println(e.getMessage());
		}
	}

	/** 
	 * Method to generateReportCard
	 * @param  studentid
	 * @return void
	 * @throws 
	 */
	
	public void generateReportCard(String studentId) {
//		System.out.println("\nREPORT CARD FOR STUDENT (STUDENT ID: "+studentId+")\n");
//		Student currStudent = UserData.students.get(studentId);
//		HashMap<String, RegisteredCourse> hmp = currStudent.getRegCourses();
//		System.out.println("Course Code\tCourse Name\tGrade Awarded\n");
//		for(Map.Entry<String, RegisteredCourse> m:hmp.entrySet())
//		{
//			RegisteredCourse rc = m.getValue();
//			System.out.println(rc.getCourseCode()+"\t"+rc.getName()+"\t"+rc.getGrade());
//		}
	}
}

//	public void generateReportCard(int adminId, int studentId, String courseCode, int semester)
//	{
//		Scanner sc = new Scanner(System.in);
//		System.out.print("\nEnter Grade Received by Student (Student Id: "+studentId+") in Course (Course Code: "+courseCode+"): ");
//		String grade = sc.next();
//		Student s = UserData.students.get(studentId);
//		s.get
//		System.out.println("Report Card Generated!");
//	}
