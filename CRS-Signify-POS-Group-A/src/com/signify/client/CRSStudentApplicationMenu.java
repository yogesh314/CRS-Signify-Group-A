package com.signify.client;

import com.signify.bean.*;

import java.util.*;
import com.signify.service.*;

/**
 * @author dp201
 *
 */
public class CRSStudentApplicationMenu {

	public void displayStudentMenu(String studentid) {
		System.out.println("\nSTUDENT MENU");
		System.out.println("**************");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(
					"1. SEMESTER REGISTRATION\n"
					+ "2. VIEW REPORT CARD\n"
					+ "3. VIEW REGISTERED COURSE\n"
					+ "4. ADD COURSE\n"
					+ "5. DROP COURSE\n"
					+ "6. PAY FEES\n"
					+ "7. EXIT\n");
			StudentInterface ss = new StudentServiceOperation();
			int choice = sc.nextInt();

			switch (choice) {
				case 1: {
					System.out.print("\nENTER SEMESTER: ");
					int semester = sc.nextInt();
					ss.semesterRegister(studentid, semester);
					break;
				}
				case 2: {
					List<Grades> g = new ArrayList<Grades>();
					g = ss.viewGrades(studentid);

					System.out.println("\nCourse Code\tCourse Name\tGrade Obtained\n");
					System.out.println("==============================================\n");
					for (Grades x : g) {
						System.out.println(x.getCourseCode() + "\t\t" + x.getCourseName() + "\t\t" + x.getGrade());
					}
					break;
				}
				case 3: {
					List<RegisteredCourse> rc = ss.viewRegisterCourses(studentid);

					System.out.println("\nCourse Code\tCourse Name\tSemester\tType\n");

					for (RegisteredCourse x : rc) {
						System.out.println(x.getCourseCode() + "\t" + x.getCourseName() + "\t" + x.getSemester() + "\t"
								+ x.getType());
					}
					System.out.println();
					break;
				}
				case 4: {
					List<Course> ac = ss.getAvailableCourses(studentid);
					List<String> cc = new ArrayList<String>();
					if (ac != null) {
						System.out.println("\nList of Available Courses\n");
						System.out.println("Course_Code\t\tCourse_Name\t\tInstructor\t\tSeats");
						System.out.println(
								"==============================================================================");
						for (Course x : ac) {
							cc.add(x.getCourseCode());
							int seatsAvailable = 10 - x.getNumStudents();
							System.out.println(
									x.getCourseCode() + "\t\t\t" + x.getName() + "\t" + x.getInstructor() + "\t"
											+ seatsAvailable);
						}

						System.out.println();
						sc.nextLine();
						String coursecode = "";
						while (true) {
							System.out.print("Enter Course Code: ");
							coursecode = sc.next();
							if (cc.indexOf(coursecode) != -1) {
								break;
							}
							System.out.println("\nYOU CAN REGISTERED IN ONE OF THE LISTED COURSES!\n");
							sc.nextLine();
						}
						int type = 0;
						while (true) {
							System.out.print("Enter Type (1/2): ");
							type = sc.nextInt();

							if (type == 1 || type == 2) {
								break;
							}
						}
						ss.addCourse(studentid, coursecode, type);
					}
					break;
				}
				case 5: {
					List<RegisteredCourse> rc = ss.viewRegisterCourses(studentid);

					System.out.println("\nCourse Code\tCourse Name\tSemester\n");
					for (RegisteredCourse x : rc) {
						System.out.println(x.getCourseCode() + "\t"+ "\t"+ "\t" + x.getCourseName() + "\t"+ "\t"+ "\t" + x.getSemester());
					}

					System.out.print("\nEnter Course Id: ");
					sc.nextLine();
					String courseId = sc.nextLine();
					ss.dropCourse(studentid, courseId);
					break;
				}
				case 6: {
					String referencedId;
					List<Course> courses = ss.getFees(studentid);
					double totalFee = 0;
					for (Course x : courses) {
						totalFee += x.getFee();
					}

					System.out.println("\nTOTAL FEES TO BE PAID: " + totalFee + "\n");
					int m = 0;
					while (true) {
						System.out.println(
								"\nPRESS 1 FOR ONLINE PAYMENT\nPRESS 2 FOR OFFLINE PAYMENT\nPRESS 3 IF SCHOLARSHIP RECEIVED\n");
						try {
							m = sc.nextInt();
						} catch (InputMismatchException e) {
							m = 0;
							sc.nextLine();
						}
						switch (m) {
							case 1:
								int on = 0;
								while (true) {
									System.out.println(
											"\nPRESS 1 FOR PAYMENT THROUGH CARD\nPRESS 2 FOR PAYMENT THROUGH NET BANKING\nPRESS 3 TO GO BACK\n");
									try {
										on = sc.nextInt();
									} catch (InputMismatchException e) {
										on = 0;
										sc.nextLine();
									}

									switch (on) {
										case 1: {
											sc.nextLine();
											System.out.print("\nENTER CARD NUMBER: ");
											String cardNumber = sc.nextLine();
											System.out.print("ENTER CARD TYPE: ");
											String cardType = sc.nextLine();
											referencedId = UUID.randomUUID().toString();
											Payment p = new Payment();
											p.setStudentId(studentid);
											p.setStatus(0);
											p.setAmount(totalFee);
											p.setMode("ONLINE");
											p.setReferencedId(referencedId);

											OnlinePayment onp = new OnlinePayment();
											onp.setCard(1);
											onp.setCardNumber(cardNumber);
											onp.setCardType(cardType);
											onp.setAccountNumber("NA");
											onp.setIfscode("NA");
											onp.setModeOfTransfer("NA");
											onp.setReferencedId(referencedId);
											ss.payFeesByCard(onp, p);
											break;
										}
										case 2: {
											sc.nextLine();
											System.out.print("\nENTER MODE OF TRANSFER: ");
											String mot = sc.nextLine();
											System.out.print("ENTER ACCOUNT NUMBER: ");
											String accnum = sc.nextLine();
											System.out.print("ENTER IFSCODE: ");
											String ifsc = sc.nextLine();
											referencedId = UUID.randomUUID().toString();
											Payment p = new Payment();
											p.setStudentId(studentid);
											p.setStatus(0);
											p.setAmount(totalFee);
											p.setMode("ONLINE");
											p.setReferencedId(referencedId);

											OnlinePayment onp = new OnlinePayment();
											onp.setCard(0);
											onp.setCardNumber("NA");
											onp.setCardType("NA");
											onp.setAccountNumber(accnum);
											onp.setIfscode(ifsc);
											onp.setModeOfTransfer(mot);
											onp.setReferencedId(referencedId);
											ss.payFeesByNetBanking(onp, p);
											break;
										}
										case 3: {
											return;
										}
										default: {
											System.out.println("\nINVALID INPUT RECEIVED!\n");
											break;
										}
									}
								}
							case 2: {
								int of = 0;
								outer: while (true) {
									System.out.println(
											"\nPRESS 1 FOR CASH PAYMENT\nPRESS 2 FOR CHEQUE PAYMENT\nPRESS 3 TO GO BACK\n");
									try {
										of = sc.nextInt();
									} catch (InputMismatchException e) {
										of = 0;
										sc.nextLine();
									}
									switch (of) {
										case 1: {

											referencedId = UUID.randomUUID().toString();
											Payment p = new Payment();
											p.setStudentId(studentid);
											p.setStatus(0);
											p.setMode("OFFLINE");
											p.setAmount(00);
											p.setMode("ONLINE");
											p.setReferencedId(referencedId);
											p.setReferencedId(referencedId);

											OfflinePayment ofp = new OfflinePayment();
											ofp.setReferencedId(referencedId);
											ofp.setCash(1);
											ofp.setChequeNumber(-1);
											ofp.setBankName("NA");
											ss.payFeesByCash(ofp, p);
											break;
										}
										case 2: {
											System.out.print("\nENTER CHEQUE NUMBER: ");
											int chequenum = sc.nextInt();
											sc.nextLine();
											System.out.print("ENTER BANK NAME: ");
											String bankname = sc.nextLine();

											referencedId = UUID.randomUUID().toString();
											Payment p = new Payment();
											p.setStudentId(studentid);
											p.setStatus(0);
											p.setMode("OFFLINE");
											p.setAmount(00);
											p.setMode("ONLINE");
											p.setReferencedId(referencedId);
											p.setReferencedId(referencedId);

											OfflinePayment ofp = new OfflinePayment();
											ofp.setReferencedId(referencedId);
											ofp.setCash(0);
											ofp.setChequeNumber(chequenum);
											ofp.setBankName(bankname);
											ss.payFeesByCheque(ofp, p);
											break;
										}
										case 3: {
											break outer;
										}
										default: {
											System.out.println("\nINVALID INPUT RECEIVED!\n");
											break;
										}
									}
								}
							}
						}
					}
				}
				case 7: {
					return;
				}
				default: {
					System.out.println("\nINVALID INPUT RECEIVED!\n");
				}
			}
		}
	}

}
