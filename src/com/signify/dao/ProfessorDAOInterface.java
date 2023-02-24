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
	public void viewEnrolledStudents(int professorId);
	public void addGrade(int professorId, int studentId,String grade);
}
