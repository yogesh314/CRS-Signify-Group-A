package com.signify.dao;
import java.util.List;
import com.signify.exception.*;
import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;

/**
 * @author dp201
 *
 */

public interface AdminDAOInterface{
	/** 
	 * Method to approveAllStudents
	 * @param  
	 * @return void
	 */

	public void approveAllStudents();
	
	/** 
	 * Method to approveAllStudentById
	 * @param studentid
	 * @return void
	 * @throws StudentNotFoundForVerificationException
	 */
	
	public void approveStudentById(String studentid) throws StudentNotFoundForVerificationException;

	/** 
	 * Method to listOfUnapprovedStudents
	 * @param 
	 * @return List<Student>
	 */
	
	public List<Student> listOfUnapprovedStudents();
	
	/** 
	 * Method to  addAdmin
	 * @param  a
	 * @return void
	 * @throws UserAlreadyExistException
	 */
		
	public void addAdmin(Admin a) throws UserAlreadyExistException;
	
	/** 
	 * Method to viewAdmins
	 * @param  
	 * @return List
	 */
	
	public List<Admin> viewAdmins();
	
	/** 
	 * Method to viewProfessors
	 * @param  
	 * @return List
	 * @throws 
	 */
	public List<Professor> viewProfessors();
	
	/** 
	 * Method to addProfessor
	 * @param  p
	 * @return void
	 * @throws ProfessorNotAddedException, UserAlreadyExistException
	 */
	
	public void addProfessor(Professor p) throws ProfessorNotAddedException, UserAlreadyExistException;
	
	/** 
	 * Method to assignProfessorToCourse
	 * @param  professorid,courseCode
	 * @return void
	 * @throws CourseNotAssignedToProfessorException
	 */
	public void assignProfessorToCourse(String professorid, String courseCode) throws CourseNotAssignedToProfessorException;
	
	/** 
	 * Method to addCourse
	 * @param  c
	 * @return void
	 * @throws AddCourseException, ProfessorNotFoundException, CourseFoundException
	 */
	public void addCourse(Course c) throws AddCourseException, ProfessorNotFoundException, CourseFoundException;
	
	/** 
	 * Method to removeCourse
	 * @param  courseCode
	 * @return void
	 * @throws CourseNotFoundException, CourseNotDeletedException
	 */
	public void removeCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException;
	
	/** 
	 * Method to viewCourseDetails
	 * @param  courseCode
	 * @return void
	 * @throws CourseNotFoundException
	 */
	public Course viewCourseDetails(String coursecode) throws CourseNotFoundException;
	
	/** 
	 * Method to calculateCpi
	 * @param  studentid
	 * @return double
	 * @throws StudentNotRegisteredException
	 */
	public double calculateCpi(String studentid) throws StudentNotRegisteredException;
	
	/** 
	 * Method to generateReportCard
	 * @param  studentid
	 * @return double
	 * @throws StudentNotRegisteredException
	 */
	public void generateReportCard(String studentId) throws StudentNotRegisteredException;
	
}
