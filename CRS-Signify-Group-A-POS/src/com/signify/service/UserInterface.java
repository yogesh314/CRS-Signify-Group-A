package com.signify.service;

import com.signify.exception.UserNotFoundException;

public interface UserInterface {

	
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
	
    
	
	/** 
	 * Method to logout
	 * @param  
	 * @return void
	 */
    public void logout();
    

	/** 
	 * Method to updateDetails
	 * @param  
	 * @return void
	 */
	public void updateDetails();	
	
	
}
