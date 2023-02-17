/**
 * 
 */
package com.signify.client;
import java.util.Scanner;

import com.signify.service.AdminInterface;
import com.signify.service.AdminServiceOperation;
/**
 * @author prati
 *
 */
public class CRSAdminMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
         public static void dis() {
        	 
         
    	String p = "Welcome to Admin Menu"; 
    	Scanner scan1 = new Scanner(p); 
		    System.out.println("String: " +scan1.nextLine());  
	        scan1.close();
	        String name = " ";
    	//AdminServiceOperation service = new AdminServiceOperation();
	        AdminInterface service = new AdminServiceOperation();
    	service.approveStudent(name);
    	service.assignCourse(name);
    	service.addProfessor(name);
    	service.addAdmin(name);
         }
	}


