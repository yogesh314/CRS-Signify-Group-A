/**
 * 
 */
package com.signify.service;
import com.signify.dao.UserDAOImplementation;
import com.signify.exception.UserNotFoundException;
/**
 * @author dp201
 *
 */
public class UserServiceOperation implements UserInterface{
	
	UserDAOImplementation udi = new UserDAOImplementation();

	/** 
	 * Method to login
	 * @param  username,password
	 * @return String[]
	 * @throws UserNotFoundException
	 */
	public String[] login(String username, String password) 
	{	
		String[] userLoginDetails = {"",""};
		try {
			userLoginDetails = udi.login(username, password);
		}
		catch(UserNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return userLoginDetails;
	}
	/** 
	 * Method to logout
	 * @param  
	 * @return void
	 * @throws
	 */
	
	public void logout()
	{
		System.out.println("\nYOU WILL BE LOGGED OUT!\n");
	}
		
	/** 
	 * Method to updateDetails
	 * @param  
	 * @return void
	 * @throws
	 */
	public void updateDetails()
	{
		System.out.println("\nDETAILS UPDATED!\n");
	}
	
	/** 
	 * Method to updatePassword
	 * @param  username,oldPassword,newPassword
	 * @return boolean
	 * @throws UserNotFoundException
	 */
	public boolean updatePassword(String username, String password, String newPassword) {
		UserDAOImplementation udi = new UserDAOImplementation();
		try {
			udi.updatePassword(username, password, newPassword);
			System.out.println("YOUR PASSWORD HAS BEEN UPDATE SUCCESSFULLY!\n");
		}
		catch(UserNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return true;
	}
}
