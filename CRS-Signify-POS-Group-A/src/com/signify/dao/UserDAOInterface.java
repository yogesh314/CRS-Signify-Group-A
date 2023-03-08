package com.signify.dao;
import com.signify.exception.ProfessorNotTeachingException;
import com.signify.exception.UserNotFoundException;

public interface UserDAOInterface {
	

	/** 
	 * Method to login
	 * @param  username,password
	 * @return String[]
	 * @throws UserNotFoundException
	 */
	public String[] login(String username, String password) throws UserNotFoundException;
	
	/** 
	 * Method to updatePassword
	 * @param  username,oldPassword,newPassword
	 * @return boolean
	 * @throws UserNotFoundException
	 */
    public boolean updatePassword(String username,String oldPassword,String newPassword) throws UserNotFoundException;
}
