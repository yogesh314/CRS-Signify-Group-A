/**
 * 
 */
package com.signify.dao;

import java.sql.SQLException;

import com.signify.bean.Student;

/**
 * @author hp
 *
 */
public interface StudentDAOInterface {
	
	public boolean registerDAO(Student student) throws SQLException ;
	
	public boolean studentRegitration(int sid, int curr, String doj) throws SQLException ;
	
	public void addStudentCourse() throws SQLException;
	
	public void dropStudentCourse() throws SQLException;
	
	//public boolean loginDAO(Student student) throws SQLException;

}
