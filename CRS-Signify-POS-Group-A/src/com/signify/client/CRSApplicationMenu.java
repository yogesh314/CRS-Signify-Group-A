package com.signify.client;

import com.signify.service.*;
import java.util.*;

/**
 * @author dp201
 *
 */
public class CRSApplicationMenu {

	public static void main(String args[]) {

		UserInterface ob = new UserServiceOperation();
		Scanner sc = new Scanner(System.in);
		String userid = "-1", studentid = "-1";
		int roleid = -1;
		int choice = 0;
		while (true) {
			System.out.println("\nWELCOME TO THE CRS APPLICATION");
			System.out.println("********************************");
			System.out.println("1. LOGIN");
			System.out.println("2. STUDENT REGISTRATION");
			System.out.println("3. UPDATE PASSWORD");
			System.out.println("4. EXIT\n");
			choice = sc.nextInt();
			switch (choice) {
				case 1: {
					System.out.print("ENTER USERNAME: ");
					String username = sc.next();
					System.out.print("ENTER PASSWORD: ");
					String password = sc.next();

					String[] userLoginDetails = ob.login(username, password);
					try {
						roleid = Integer.valueOf(userLoginDetails[0]);
					} catch (NumberFormatException e) {
						System.out.println("\nINVALID USERNAME OR PASSWORD!\n");
						break;
					}
					userid = userLoginDetails[1];

					if (roleid == 2) {
						CRSAdminApplicationMenu as = new CRSAdminApplicationMenu();
						as.displayAdminMenu(userid);
						break;
					} else if (roleid == 3) {
						CRSProfessorApplicationMenu ps = new CRSProfessorApplicationMenu();
						ps.displayProfessorMenu(userid);
						break;
					} else if (roleid == 1) {
						StudentInterface si = new StudentServiceOperation();
						studentid = si.getStudentId(userid);
						int isApproved = si.getApprovedStatus(studentid);
						if (isApproved == 1) {
							CRSStudentApplicationMenu ss = new CRSStudentApplicationMenu();
							ss.displayStudentMenu(studentid);
						} else
							System.out.println("\nTHE ADMIN HAS NOT APPROVED YOU YET!\n");
						break;
					} else {
						System.out.println("\nINVALID USERNAME OR PASSWORD!\n");
					}
					break;
				}

				case 2: {
					StudentInterface ss = new StudentServiceOperation();
					ss.register();
					break;
				}
				case 3: {
					String username_p, password_p, newpassword_p = "DEFAULT";
					System.out.print("ENTER USERNAME: ");
					username_p = sc.next();
					System.out.print("ENTER PASSWORD: ");
					password_p = sc.next();
					String[] uid = ob.login(username_p, newpassword_p);
					try {
						System.out.println("AS" + roleid);
						roleid = Integer.valueOf(uid[0]);

					} catch (NumberFormatException e) {
						System.out.println("\nINVALID USERNAME OR PASSWORD!\n");
						break;
					}
					userid = uid[1];
					System.out.println("AS" + userid);
					if (userid != null) {
						System.out.print("ENTER NEW PASSWORD: ");
						newpassword_p = sc.nextLine();
						ob.updatePassword(username_p, password_p, newpassword_p);
					}
					break;
				}

				case 4: {
					ob.logout();
					return;
				}
				default: {
					System.out.println("\nINVALID INPUT RECEIVED!\n");
				}
				try

				{
					Class.forName("com.mysql.cj.jdbc.Driver");

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
