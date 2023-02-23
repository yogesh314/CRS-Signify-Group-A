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
 * @author pratik
 *
 */
public class CRSAdminMenu {
	
	public static AdminServiceOperations AdminServiceObj = new AdminServiceOperations();
	
	
	public void displayAdminMenu() {
		System.out.print("\n================================\n");
		  System.out.println("================================");	
		
      System.out.println("\nWELCOME TO ADMIN MENU");
      System.out.println("===========================\n");
      System.out.println("ADMIN MENU");
		System.out.println("1. Approve Student");
		System.out.println("2. AddAdmin");
		System.out.println("3. viewAdmins");
		System.out.println("4. Add Course");
		System.out.println("5. Drop Course");
		System.out.println("6. View Courses");
		System.out.println("7. Add Professor");
		System.out.println("8. Assign Professor to course");
		System.out.println("9. CalculateCPI");
		System.out.println("10.Generate Report Card");
		System.out.println("11.Exit\n");
		
		AdminInterface adminObject = new AdminServiceOperations();
		
		int adminChoice = 0;
		
		boolean flag;
		
		do
		{
			try {
				System.out.print("Enter your Choice: ");
				Scanner scan = new Scanner(System.in);
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
			adminObject.approveStudent();
		    displayAdminMenu();
	
		break;
		
		case 2: 
			adminObject.addAdmin();
			displayAdminMenu();
		break;
		
		case 3: 
			adminObject.viewAdmins();
			displayAdminMenu();
		break;
		
		case 4:
			adminObject.addCourse();
			displayAdminMenu();
		break;
		
		case 5: 
			System.out.println("Enter Course code");
			Scanner in = new Scanner(System.in);
			String courseCode = in.nextLine();
			adminObject.dropCourse(courseCode);
			displayAdminMenu();
		break;
		
		case 6:
			adminObject.viewCourseDetails();
			displayAdminMenu();
		break;
		
		case 7:
			adminObject.addProfessor();
			displayAdminMenu();
		break;
		
		case 8:
//			System.out.println("Assign Professor to Course");
			//adminObject.generateReportCard();
		break;
		
		case 9:
//			System.out.println("CalculateCPI");
			//adminObject.generateReportCard();
		break;
		
		case 10:
//			System.out.println("Generate Report Card");
			// adminObject.generateReportCard();
		break;
		
		case 11: System.out.println("\nRedirecting to Main Menu ");
		CRSApplicationMenu exitobj= new CRSApplicationMenu();
		exitobj.main(null);
		break;
		
		default: System.out.println("Wrong Choice Selected, press ENTER to redirect to Professor Menu.");
		try{System.in.read();}
		catch(Exception e) {}
		displayAdminMenu();
		
		}
	}

	

}
