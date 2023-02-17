/**
 * 
 */
package com.signify.client;

import java.util.Scanner;

import com.signify.service.AdminServiceOperation;
import com.signify.service.StudentServiceOperation;

/**
 * @author prati
 *
 */
public class CRSApplicationMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean check = true;
	while(check) {
		String s = "Welcome to the CRS application"; 
		 Scanner scan = new Scanner(s); 
		 System.out.println("String: " +scan.nextLine());  
	     scan.close(); 
	     System.out.println("MAIN MENU");
	     System.out.println("1.LOGIN\n"+ "2.REGISTRATION FOR STUDENT\n"+ "3.UPDATE PASSWORD\n"+"4.EXIT");
		 Scanner in = new Scanner(System.in); 
		 System.out.println("Enter your choice: ");
		 int option=in.nextInt();
		 switch(option) {
		 case 1:
			System.out.println("LOGIN");
	        System.out.print("Enter  username: ");    
	        String name = in.next();   
	        System.out.println("Name: " + name);           
	        System.out.print("Enter password: ");  
	        String i = in.next();  
	        System.out.println("Password: " + i);  
	        System.out.print("Enter your role: ");  
	        String d = in.next();  
//	        System.out.println("Role: " + d);
//	        System.out.println(d);
	        if (d.equals("Admin"))
	        {
               CRSAdminMenu.dis();
	        }
	        if(d.equals("Student"))
	        {
	        	CRSStudentMenu.dis3();;
	        }
	        if(d.equals("Professor"))
	        {
	        	CRSProfessorMenu.dis1();;
	        }
	   	    break;
	      
		 case 2:
			 
			 break;
		 
		 case 3:
		 
			 System.out.println("Enter your current passowrd");
			 break;
		 
		 case 4:
	 check = false;
		 System.out.println("exit");
		 break;
		
	}
	}
	}
}



