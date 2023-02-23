/**
 * 
 */
package com.signify.client;

import java.util.Scanner;
import com.signify.client.CRSApplicationMenu;
import com.signify.service.ProfessorInterface;
import com.signify.service.ProfessorServiceOperations;
import com.signify.service.UserServiceOperations;

/**
 * @author pratik
 *
 */
public class CRSProfessorMenu {
	public void displayProfessorMenu(int professorId) {
		// TODO Auto-generated method stub
      System.out.println("\nWELCOME TO PROFESSOR MENU");
      System.out.println("===========================\n");
      System.out.println("PROFESSOR MENU");
		System.out.println("1. View Enrolled Students");
		System.out.println("2. Add Grade");
		System.out.println("3. Exit\n");
		
//		System.out.println("Enter your Choice: \n");
		
//		Scanner scan = new Scanner(System.in);
		int ProfessorChoice = 0;
		
		ProfessorInterface professorObject = new ProfessorServiceOperations();
		
		boolean flag;
		
		do
		{
			try {
				System.out.print("Enter your Choice: ");
				Scanner scan = new Scanner(System.in);
//				System.out.println("Enter Integer Value only");
				ProfessorChoice = scan.nextInt();
				flag=false;
			}
			catch(Exception e)
			{
				System.out.println("======================================================");
				System.out.println("Please Select from above options only, try again");
				System.out.println("======================================================");
				flag = true;
			}
		}while(flag);
		
		
		switch(ProfessorChoice) {
		
		case 1: 
//			System.out.println("\nEnrolled Students:-->");
			
			professorObject.viewEnrollStudents(professorId);
		displayProfessorMenu(professorId) ;
	
		break;
		
		case 2: 
//			System.out.println("\nGrades Added");
			professorObject.addGradeService(professorId);
			displayProfessorMenu(professorId) ;
		break;
		
		
		case 3:  System.out.println("\nRedirecting to Main Menu ");
		CRSApplicationMenu exitobj= new CRSApplicationMenu();
		exitobj.main(null);
		break;
		
		default: System.out.println("Wrong Choice Selected, press ENTER to redirect to Professor Menu.");
		try{System.in.read();}
		catch(Exception e) {}
		displayProfessorMenu(professorId);
		}
		
//		scan.close();
	}


}
