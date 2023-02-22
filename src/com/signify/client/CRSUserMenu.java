/**
 * 
 */

package com.signify.client;
import java.util.Scanner;

import com.signify.collections.AdminCollection;
import com.signify.collections.StudentCollection;

import com.signify.client.CRSStudentMenu;
import com.signify.service.StudentServiceOperations;
import com.signify.service.UserInterface;
import com.signify.service.UserServiceOperations;
import com.signify.bean.User;
import com.signify.client.CRSAdminMenu;
import com.signify.client.CRSProfessorMenu;
/**
 * @author hp
 *
 */
public class CRSUserMenu {
	public void updatePasswordMenu() {
		UserInterface userObject1 = new UserServiceOperations();
		userObject1.updatePassword();
	}
	
	public void displayUserMenu() {

		
		//		boolean loginFlag = false;
//		
		CRSStudentMenu ob1=new CRSStudentMenu();
		CRSAdminMenu ob2=new CRSAdminMenu();
		CRSProfessorMenu ob3=new CRSProfessorMenu();
//		
		UserInterface userObject = new UserServiceOperations();
		User user  = userObject.login();
		
		if(user.getRole()== 1) {
			System.out.println(user.getRole());
			ob1.displayStudentMenu(user);
		}
		if(user.getRole()==2) {
			ob2.displayAdminMenu();
		}
		if(user.getRole()==3) {
			ob3.displayProfessorMenu();
		}
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Enter Id:  ");
//		int userId = scan.nextInt();
//		
//		
//		System.out.print("Enter Password:  ");
//		Scanner scan2 = new Scanner(System.in);
//		String userPassword = scan2.nextLine();
//	
//		
//		int flag = 0;
//		int userMenuFlag=0;
//		
//		do {
//			
//			if(loginFlag==false && flag==1)
//			{
//			scan = new Scanner(System.in);
//			System.out.print("Enter Id:  ");
//			userId = scan.nextInt();
//			
//			
//			System.out.print("Enter Password:  ");
//			scan2 = new Scanner(System.in);
//			userPassword = scan2.nextLine();
//			}
//			
//		System.out.print("Enter User Role\n"
//				+"======================"+ "\n-Student "
//				+ "\n-Professor "
//				+ "\n-Admin " + "\n======================\n");
//		System.out.print("\nEnter Your Choice: ");
//		Scanner scan3 = new Scanner(System.in);
//		String userRole = scan3.nextLine();
//		
////		for (int i = 0; i < object.studentObject.size(); i++) {
////		    System.out.println(object.studentObject.get(i).getName());
////		}
//		
//		int i=0;
//		if (userRole.equalsIgnoreCase("Student"))
//		{
//		for(i=0;i<object.studentObject.size();i++)
//		{
//			System.out.println(object.studentObject.get(i).getUserId());
////			System.out.println(object.studentObject.get(i).getPassword());
//			System.out.println(userId);
////			System.out.println(userPassword);
//			if(object.studentObject.get(i).getUserId()==userId)
//			{
//				if(object.studentObject.get(i).getPassword().equals(userPassword))
//				{
//					loginFlag=true;
//					break;
//			}
//			}
//			
//		}
//		}
//		
//		if (userRole.equalsIgnoreCase("Admin"))
//		{
//		for(i=0;i<adminObjectCollection.adminObject.size();i++)
//		{
//			System.out.println(adminObjectCollection.adminObject.get(i).getUserId());
////			System.out.println(object.studentObject.get(i).getPassword());
//			System.out.println(userId);
////			System.out.println(userPassword);
//			if(adminObjectCollection.adminObject.get(i).getUserId()==userId)
//			{
//				if(adminObjectCollection.adminObject.get(i).getPassword().equals(userPassword))
//				{
//					loginFlag=true;
//					break;
//			}
//			}
//			
//		}
//		}
//		
//		
//		
//		
////		System.out.println(loginFlag);
//		
//		if(userRole.equalsIgnoreCase("Student") && loginFlag==true)
//		{
//			ob1.displayStudentMenu(object, i);
//			flag = 2;
//		}
//		
//		else if(userRole.equalsIgnoreCase("Professor") && loginFlag==true)
//		{
//			ob3.displayProfessorMenu();
//			flag = 2;
//		}
//		
//		else if(userRole.equalsIgnoreCase("Admin") && loginFlag==true)
//		{
//			ob2.displayAdminMenu(adminObjectCollection, i,null,null);
//			flag = 2;
//		}
//		
//		else
//		{
//			if (loginFlag==false)
//			{
//				System.out.println("\n Please Enter Valid Credentials\n\n");
//			}
//	
//			else {
//				System.out.println("\n Please Enter Valid User Role\n\n");
//			}
//			
//			flag=1;
//		}
//		
//		
//		}while(flag==1);
//		
//		scan.close();
//		
//	}
//
//	
//	
	
	
	}
}
