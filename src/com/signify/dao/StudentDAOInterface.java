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
	
	//public boolean loginDAO(Student student) throws SQLException;

}
