/**
 * 
 */
package com.signify.service;

import java.util.Scanner;

import com.signify.bean.User;
import com.signify.dao.UserDAOImplementation;
import com.signify.dao.UserDAOInterface;


public class UserServiceOperations implements UserInterface{

	
	public User login() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Id:  ");
		int userId = scan.nextInt();
		
		
		System.out.print("Enter Password:  ");
		Scanner scan2 = new Scanner(System.in);
		String userPassword = scan2.nextLine();
		
		UserDAOInterface userDao = new UserDAOImplementation();
		
		User user = userDao.loginDAO(userId, userPassword);
		
		return user;
	}
	
//	public void logout() {
//		
//		
//		
////		System.out.println("details updated");
//	}
	

//	public void updateDetails(String name, String role) {
//	
//		System.out.println("details updated");
//	}
//	
	public void updatePassword() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Id:  ");
		int userId = scan.nextInt();
		
		
		System.out.print("Enter Password:  ");
		Scanner scan2 = new Scanner(System.in);
		String userPassword = scan2.nextLine();
		
		UserDAOInterface userDao = new UserDAOImplementation();
		
		User user = userDao.loginDAO(userId, userPassword);
		
		if(user != null) {

			UserDAOInterface userDao1 = new UserDAOImplementation();
			boolean status = userDao1.updatepasswordDAO(userId, userPassword);
			if(status == true) {
				System.out.println("password updated");	
			}
		}
		else {
			System.out.print("Invalid Credentials:  ");
		}
		
	}
}
