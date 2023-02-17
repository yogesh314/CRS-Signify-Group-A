/**
 * 
 */
package com.signify.client;

import java.util.Scanner;

import com.signify.service.StudentServiceOperation;

/**
 * @author prati
 *
 */
public class CRSStudentMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static void dis3() {
		String t = "Welcome to Student Menu"; 
    	Scanner scan2 = new Scanner(t); 
		System.out.println("String: " +scan2.nextLine());  
	    scan2.close();
		StudentServiceOperation service = new StudentServiceOperation();
		
		service.addCourse();
		service.dropCourse();
		service.payFees();
		service.register();
		service.registerCourse();
		service.viewRegisteredCourse();
		service.viewGradeCard();
		service.viewCourseDetails();
		service.updateDetails();
		service.updatePassword();
	}
}
