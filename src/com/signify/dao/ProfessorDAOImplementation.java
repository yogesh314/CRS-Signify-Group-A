
	package com.signify.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import com.signify.bean.Professor;
    import com.signify.service.ProfessorInterface;

	/**
	 * @author prati
	 *
	 */
	public class ProfessorDAOImplementation implements ProfessorDAOInterface{
		
		 private Connection conn;
			public ProfessorDAOImplementation(Connection conn) {
		        this.conn = conn;
		    }
			
			@Override
			public boolean addProfessorDAO(Professor professor) throws SQLException 
			{
			       
					String sql = "INSERT IGNORE INTO user (userID, password, userName, roleId) VALUES (?, ?,?, ?)";
			        PreparedStatement stmt = conn.prepareStatement(sql);
			        
			        stmt.setLong(1, professor.getUserId());
			        stmt.setString(2, professor.getPassword());     
			        stmt.setString(3,professor.getName());
			        stmt.setLong(4, 3);
			        stmt.executeUpdate();
			               
		        
			        String sql2 = "INSERT IGNORE INTO professor (name, professorID, password, designation, department, DOJ) VALUES (?, ?, ?,?,?,?)";
			        PreparedStatement stmt2 = conn.prepareStatement(sql2);
			        stmt2.setString(1, professor.getName());
			        stmt2.setLong(2, professor.getUserId());
			        stmt2.setString(3, professor.getPassword());
			        stmt2.setString(4, professor.getDesignation());
			        stmt2.setString(5, professor.getDepartment());
			        stmt2.setString(6, professor.getDOJ());
			        stmt2.executeUpdate();
		 
		        
			        int rowsInserted = stmt.executeUpdate();
			        return rowsInserted > 0;
			}
		

	}
