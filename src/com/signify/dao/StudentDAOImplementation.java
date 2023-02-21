/**
 * 
 */
package com.signify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.signify.bean.Student;
import com.signify.collections.StudentCollection;

/**
 * @author hp
 *
 */
public class StudentDAOImplementation implements StudentDAOInterface {
	
//	JDBC driver name and database URL
	 private Connection conn;
	public StudentDAOImplementation(Connection conn) {
        this.conn = conn;
    }
	  
	@Override
	public boolean registerDAO(Student student) throws SQLException 
	{
	       
			String sql = "INSERT IGNORE INTO user (userId, password, userName, roleId) VALUES (?, ?, ?,?)";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        
	        stmt.setLong(1, student.getUserId());
	        stmt.setString(2, student.getPassword());
	        stmt.setString(3, student.getName());
	        stmt.setLong(4, student.getRole());
	        stmt.executeUpdate();
	                
        
	        String sql2 = "INSERT IGNORE INTO student (userId, studentName, studentId, branch, batch) VALUES (?, ?, ?,?,?)";
	        PreparedStatement stmt2 = conn.prepareStatement(sql2);
	        stmt2.setLong(1, student.getUserId());
	        stmt2.setString(2, student.getName());
	        stmt2.setLong(3, student.getStudentId());
	        stmt2.setString(4, student.getBranch());
	        stmt2.setLong(5, student.getBatch());
	        stmt2.executeUpdate();
 
        
	        int rowsInserted = stmt.executeUpdate();
	        return rowsInserted > 0;
	}

}


