/**
 * 
 */
package com.signify.client;

import java.util.*;

import com.signify.bean.Admin;
import com.signify.bean.Course;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.helper.UserRegistration;
import com.signify.service.AdminInterface;
import com.signify.service.AdminServiceOperation;

/**
 * @author dp201
 *
 */
public class CRSAdminApplicationMenu {
	Scanner sc = new Scanner(System.in);
	
	public void displayAdminMenu(String adminid) {
		int choice = 0;
		boolean f = true;
		while (true) {
			System.out.println("\nADMIN MENU");
			System.out.println("************");
			System.out.println("1. APPROVING STUDENT\n"
					+ "2. ADD PROFESSOR\n"
					+ "3. ADD ADMIN\n"
					+ "4. ASSIGN PROFESSOR TO COURSE\n"
					+ "5. ADD COURSE\n"
					+ "6. REMOVE COURSE\n"
					+ "7. VIEW COURSE DETAILS\n"
					+ "8. CALCULATE CPI\n"
					+ "9. VIEW PROFESSORS\n"
					+ "10.VIEW ADMINS\n"
					+ "11.EXIT\n");
			choice = sc.nextInt();
			AdminInterface as = new AdminServiceOperation();
			switch (choice) {
				case 1: {
					List<Student> students = as.listOfUnapprovedStudents();
					System.out.println(
							"\nLIST OF UNAPPROVED STUDENTS\n\n\t\tUSER ID\t\t\t\tSTUDENT ID\t\t\tSTUDENT NAME\n");
					for (Student x : students) {
						System.out.printf("%-40s %-40s %-40s %n", x.getUserId(), x.getStudentid(), x.getName());

					}
					while (f) {
						System.out.print(
								"\nPRESS 1 TO APPROVE ALL STUDENTS\nPRESS 2 TO APPROVE STUDENT BY ID\nPRESS 3 TO GO BACK\n");
						int cha = sc.nextInt();
						switch (cha) {
							case 1: {
								as.approveAllStudents();
								System.out.println("\nALL STUDENTS HAS BEEN APPROVED");
								break;
							}
							case 2: {
								sc.nextLine();
								System.out.print("\nENTER STUDENT ID: ");
								String studentid = sc.nextLine();
								as.approveStudentById(studentid);
								System.out.println("\nSTUDENTS HAS BEEN APPROVED");
								break;
							}
							case 3: {
								f = false;
								break;
							}
							default: {
								System.out.println("\nINVALID INPUT RECEIVED!\n");
								break;
							}
						}
					}
					break;
				}
				case 2: {
					UserRegistration ur = new UserRegistration();
					User newUser = ur.registerUser(3);
					Professor newProfessor = new Professor();
					newProfessor.setUserId(newUser.getUserId());
					newProfessor.setName(newUser.getName());
					newProfessor.setPassword(newUser.getPassword());
					newProfessor.setAddress(newUser.getAddress());
					newProfessor.setDoj(newUser.getDoj());
					newProfessor.setRoleid(newUser.getRoleid());
					sc.nextLine();
					System.out.print("ENTER DEPARTMENT: ");
					String dept = sc.nextLine();
					System.out.print("ENTER DESIGNATION: ");
					String desig = sc.nextLine();
					newProfessor.setDepartment(dept);
					newProfessor.setDesignation(desig);
					newProfessor.setCourseTaught("NA");
					as.addProfessor(newProfessor);
					break;
				}
				case 3: {
					UserRegistration ur = new UserRegistration();
					User newUser = ur.registerUser(2);
					Admin newAdmin = new Admin();
					newAdmin.setUserId(newUser.getUserId());
					newAdmin.setName(newUser.getName());
					newAdmin.setPassword(newUser.getPassword());
					newAdmin.setAddress(newUser.getAddress());
					newAdmin.setDoj(newUser.getDoj());
					newAdmin.setRoleid(newUser.getRoleid());
					as.addAdmin(newAdmin);
					break;
				}
				
				case 4: {
					sc.nextLine();
					System.out.print("\nEnter Professor Id: ");
					String professorid = sc.nextLine();
					System.out.print("Enter Course Code: ");
					String courseCode = sc.nextLine();
					as.assignProfessorToCourse(professorid, courseCode);
					break;
				}
				
				case 5: {
					sc.nextLine();
					System.out.print("\nEnter Course Code: ");
					String courseCode = sc.nextLine();
					System.out.print("Enter Course Name: ");
					String coursename = sc.nextLine();
					System.out.print("Enter Course Instructor: ");
					String instructor = sc.nextLine();
					double courseFee = 0.0;
					System.out.print("Enter Course Fee: ");
					courseFee = sc.nextDouble();
					int sem = 0;
					System.out.print("Enter Semester: ");
					sem = sc.nextInt();
					Course c = new Course();
					c.setCourseCode(courseCode);
					c.setName(coursename);
					c.setInstructor(instructor);
					c.setFee(courseFee);
					c.setNumStudents(0);
					c.setSemester(sem);
					as.addCourse(c);
					break;
				}
				
				case 6: {
					System.out.print("Enter Course Code: ");
					sc.nextLine();
					String courseCode = sc.nextLine();
					as.removeCourse(courseCode);
					break;
				}
				
				case 7: {
					sc.nextLine();
					System.out.print("\nEnter Course Code: ");
					String courseCode = sc.nextLine();
					Course c = as.viewCourseDetails(courseCode);
					if (!(c == null)) {
						System.out.println("\nCourse Code\tCourse Name\tInstructor\tCourse Fee\tSemester\n");
						System.out.println(c.getCourseCode() + "\t" + c.getName() + "\t" + c.getInstructor() + "\t"
								+ c.getFee() + "\t" + c.getSemester());
						System.out.println("\nCOURSE DETAILS VIEWED!\n");
					}

					break;
				}
				
				case 8: {
					sc.nextLine();
					System.out.print("\nEnter Student Id: ");
					String studentid = sc.nextLine();
					as.calculateCpi(studentid);
					break;
				}
				
				case 9: {
					List<Professor> p = as.viewProfessors();
					System.out.println("Professor Id\t \t \t \t Professsor Name\tDepartment\t Designation\t Course Taught\n");
					for (Professor x : p) {
						System.out.println(x.getUserId() + "\t " + x.getName() + "\t \t \t" + x.getDepartment() + "\t \t"
								+ x.getDesignation() + "\t \t" + x.getCourseTaught());
					}
					System.out.println();
					break;
				}
				
				case 10: {
					List<Admin> a = as.viewAdmins();
					System.out.println("Admin Id\t\t\tAdmin Name\n");
					for (Admin x : a) {
						System.out.println(x.getUserId() + "\t" + x.getName());
					}
					System.out.println();
					break;
				}
				
				case 11: {
					return;
				}
				
				default: {
					System.out.println("\nINVALID INPUT RECEIVED!\n");
				}
			}
		}
	}

}
