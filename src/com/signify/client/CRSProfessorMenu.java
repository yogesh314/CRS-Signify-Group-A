/**
 * 
 */
package com.signify.client;
import java.util.Scanner;

import com.signify.service.ProfessorServiceOperation;

/**
 * @author prati
 *
 */
public class CRSProfessorMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static void dis1() {
		String p = "Welcome to Professor Menu"; 
    	Scanner scan1 = new Scanner(p); 
		    System.out.println("String: " +scan1.nextLine());  
	        scan1.close();
		ProfessorServiceOperation service = new ProfessorServiceOperation();
		service.updateDetails(null);
		service.addGrade(null);
		service.updatePassword(null);
		service.viewEnrolledStudents(null);
	}

}
