/**
 * 
 */
package com.signify.client;
import java.util.Scanner;

import java.lang.Thread;
import com.signify.client.CRSUserMenu;
import com.signify.collections.AdminCollection;
import com.signify.collections.StudentCollection;
import com.signify.bean.Admin;
import com.signify.bean.User;
import com.signify.client.CRSApplicationMenu;
import java.io.IOException;

import com.signify.service.AdminServiceOperations;
import com.signify.service.StudentServiceOperations;

/**
 * @author hp
 *
 */
public class CRSApplicationMenu {
	
	public static StudentServiceOperations StudentServiceObj = new StudentServiceOperations();
	public static AdminServiceOperations AdminServiceObj = new AdminServiceOperations();
	
	
	public static void main(String[] args) {
		
		StudentCollection stuObject = StudentServiceObj.getStudentData();
		Admin admin = new Admin();
		admin.setUserId(12345);
		admin.setPassword("12345");
		admin.setName("ADMIN");
		admin.setRole(1);
		AdminCollection adminObjectCollection = new AdminCollection();
		adminObjectCollection.adminObject.add(admin);
		
		
		
		System.out.println("WELCOME TO THE CRS APPLICATION");
		System.out.println("========================================\n");
		System.out.println("MAIN MENU");
		System.out.println("1. Login");
		System.out.println("2. Registration for Student");
		System.out.println("3. Update Password");
		System.out.println("4. Exit\n");
		
		
//		Scanner scan = new Scanner(System.in);
		int userChoice=0;
		
		boolean flag;
		
		do
		{
			try {
				System.out.print("Enter your Choice: ");
				Scanner scan = new Scanner(System.in);
//				System.out.println("Enter Integer Value only");
				userChoice = scan.nextInt();
				flag=false;
			}
			catch(Exception e)
			{
				System.out.println("======================================================");
				System.out.println("Please Select from above options only, try again");
				System.out.println("======================================================");
				flag = true;
			}
		}
		
		while(flag);
		
//		StudentServiceOperations StudentServiceObj = new StudentServiceOperations();
////		StudentCollection object = StudentServiceObj.register();
//		StudentServiceOperations StudentServiceObj = new StudentServiceOperations();
//		StudentServiceOperations StudentServiceObj = new StudentServiceOperations();
		
		
		
		switch(userChoice) {
		
		case 1: System.out.println("\nLogin As: ");
		System.out.println("1.STUDENT ");
		System.out.println("2.ADMIN ");
		System.out.println("3.PROFESSOR");
		System.out.println("============================");
		CRSUserMenu obj = new CRSUserMenu();
//		StudentCollection object1 = StudentServiceObj;
//		StudentCollection object1 = StudentServiceObj.getStudentData();
		obj.displayUserMenu();
		break;
		
		case 2: System.out.println("Registration");
//		StudentServiceOperations StudentServiceObj = new StudentServiceOperations();
//		CRSUserMenu obj1 = new CRSUserMenu();
//		StudentCollection object = StudentServiceObj.register();
		StudentCollection object = StudentServiceObj.register();
		main(null);
		break;
		
		case 3: System.out.println("Password Update");
		CRSUserMenu obj1 = new CRSUserMenu();
		obj1.updatePasswordMenu();
		break;
		
		case 4: CRSApplicationMenu exitobj= new CRSApplicationMenu();
		exitobj.main(null);
		break;
		
		default: System.out.println("Wrong Choice Selected, press ENTER to retry.");
		try{System.in.read();}
		catch(Exception e) {}
		main(null);
		}
		
//		scan.close();
	}

}
