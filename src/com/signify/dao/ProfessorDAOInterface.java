/**
 * 
 */
package com.signify.dao;

import java.sql.SQLException;

import com.signify.bean.Professor;

/**
 * @author HP
 *
 */
public interface ProfessorDAOInterface {
	public boolean addProfessorDAO(Professor professor) throws SQLException ;
	public void viewEnrolledStudents(int professorId);
	public void addGrade(int professorId, int studentId,String grade);
	//public void addGrade();
}
