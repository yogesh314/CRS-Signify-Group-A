package com.signify.service;
import java.util.List;
import com.signify.bean.Student;
import com.signify.exception.ProfessorNotTeachingException;
import com.signify.exception.StudentNotRegisteredException;

public interface ProfessorInterface {

	/** 
	 * Method to viewEnrolledStudents
	 * @param  professorId
	 * @return List<student>
	 * @throws ProfessorNotTeachingException
	 */
	public List<Student> viewEnrolledStudents(String professorId) throws ProfessorNotTeachingException;
	
	/** 
	 * Method to addGrades
	 * @param  professorId,studentId,grade
	 * @return void
	 * @throws StudentNotRegisteredException, ProfessorNotTeachingException
	 */
	public void addGrades(String professorId , String studentId , String grade) throws StudentNotRegisteredException, ProfessorNotTeachingException;


}
