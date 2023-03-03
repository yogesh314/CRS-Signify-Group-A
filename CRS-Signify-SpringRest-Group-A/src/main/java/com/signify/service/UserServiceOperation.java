/**
 * 
 */
package com.signify.service;
import org.jvnet.hk2.annotations.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.signify.dao.UserDAOImplementation;
import com.signify.exception.UserNotFoundException;
/**
 * @author dp201
 *
 */
@Primary
@org.springframework.stereotype.Service
public class UserServiceOperation implements UserInterface{
	
	UserDAOImplementation udi = new UserDAOImplementation();

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
	
	public void logout()
	{
		System.out.println("\nYOU WILL BE LOGGED OUT!\n");
	}
		
	public void updateDetails()
	{
		System.out.println("\nDETAILS UPDATED!\n");
	}
	
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
