/**
 * 
 */
package com.signify.client;

import java.util.Scanner;
import com.signify.client.CRSApplicationMenu;
import com.signify.collections.AdminCollection;
import com.signify.collections.CourseCollection;
import com.signify.collections.ProfessorCollection;
import com.signify.collections.StudentCollection;
import com.signify.service.AdminInterface;
import com.signify.service.AdminServiceOperations;
import com.signify.service.ProfessorServiceOperations;
import com.signify.service.StudentServiceOperations;

/**
 * @author hp
 *
 */
public class CRSAdminMenu {
	
	public static AdminServiceOperations AdminServiceObj = new AdminServiceOperations();
//	public static ProfessorServiceOperations ProfessorServiceObj = new ProfessorServiceOperations();
	
	
	public void displayAdminMenu() {
		// TODO Auto-generated method stub
		System.out.print("\n================================\n");
		  //System.out.println("Logged in as "+object.adminObject.get(index).getName());
		  System.out.println("================================");	
		
      System.out.println("\nWELCOME TO ADMIN MENU");
      System.out.println("===========================\n");
      System.out.println("ADMIN MENU");
		System.out.println("1. Approve the student registration");
		System.out.println("2. Add Course");
		System.out.println("3. Remove Course");
		System.out.println("4. View Course");
		System.out.println("5. Add Professor");
		System.out.println("6. Generate Report Card");
//		System.out.println("5. Assign Professor to course");
		System.out.println("7. Exit\n");
		
//		System.out.println("Enter your Choice: ");
		
//		Scanner scan = new Scanner(System.in);
		AdminInterface adminObject = new AdminServiceOperations();
		
		int adminChoice = 0;
		
		boolean flag;
		
		do
		{
			try {
				System.out.print("Enter your Choice: ");
				Scanner scan = new Scanner(System.in);
//				System.out.println("Enter Integer Value only");
				adminChoice = scan.nextInt();
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
		
		switch(adminChoice) {
		
		case 1: 
//			System.out.println("Student Approved");
			//adminObject.approveStudent();
		displayAdminMenu();
	
		break;
		
		case 2: 
//			System.out.println("Course Added");
			//CourseCollection obj1 = AdminServiceObj.addCourse(profObj);
			displayAdminMenu();
		break;
		
		case 3: 
//			System.out.println("Course Removed");
			//obj1 = adminObject.deleteCourse(obj);
			displayAdminMenu();
		break;
		
		case 4:
//			System.out.println("Courses -->");
			adminObject.viewCourseDetails();
			displayAdminMenu();
		break;
		
		case 5: 
//			System.out.println("Professor Added");
			adminObject.addProfessor();
			displayAdminMenu();
		break;
		
		case 6:
//			System.out.println("Report Card --> ");
			adminObject.generateReportCard();
		break;
		
		case 7: System.out.println("\nRedirecting to Main Menu ");
		CRSApplicationMenu exitobj= new CRSApplicationMenu();
		exitobj.main(null);
		break;
		
		default: System.out.println("Wrong Choice Selected, press ENTER to redirect to Professor Menu.");
		try{System.in.read();}
		catch(Exception e) {}
		displayAdminMenu();
		}
		
		
		
//		scan.close();
	}

	

}
