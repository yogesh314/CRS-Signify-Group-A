package com.signify.service;
import com.signify.helper.*;
import com.signify.bean.*;
import com.signify.dao.StudentDAOImplementation;
import com.signify.exception.CourseLimitExceedException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.SemesterNotRegisteredException;
import com.signify.exception.StudentNotRegisteredException;

import java.util.*;

/**
 * @author 
 *
 */
public class StudentServiceOperation extends UserServiceOperation implements StudentInterface {

	StudentDAOImplementation sdi = new StudentDAOImplementation();
	

	/** 
	 * Method to  semesterRegister
	 * @param  studentid,sem
	 * @return void
	 */
	
	public void semesterRegister(String studentid, int sem) {
			sdi.semesterRegister(studentid, sem);
			System.out.println("\nSEMESTER SET TO "+sem+" FOR STUDENT ID \""+studentid+"\"\n");
	}

	
	/** 
	 * Method to  getStudentId
	 * @param  userid
	 * @return String
	 */
	
	public String getStudentId(String userid)
	{
		return sdi.getStudentId(userid);
	}
	
	/** 
	 * Method to  getIsApprovedStatus
	 * @param  studentid
	 * @return int 
	 */
	public int getApprovedStatus(String studentid)
	{
		return sdi.getIsApprovedStatus(studentid);
	}
	
	/** 
	 * Method to  register
	 * @param  student
	 * @return void
	 */
	
	public void register() {
		
		StudentRegistration sr = new StudentRegistration();
		Student newStudent = sr.registerStudent();
		sdi.register(newStudent);
		System.out.println("\nSTUDENT REGISTERED SUCCESSFULLY! WAITING FOR APPROVAL FROM ADMIN.\n");
	}

	/** 
	 * Method to viewGrades
	 * @param  studentid
	 * @return List<Grades>
	 */
	
	public List<Grades> viewGrades(String studentid) {
		return sdi.viewGrades(studentid);
	}

	/** 
	 * Method to viewRegisteredCourses
	 * @param  studentid
	 * @return List<RegisteredCourse>
	 */
	
	public List<RegisteredCourse> viewRegisterCourses(String studentid) {
		return sdi.viewRegisteredCourses(studentid);
	}
	
	/** 
	 * Method to getAvailableCourses
	 * @param  studentid
	 * @return list<Course>
	 */
	

	public List<Course> getAvailableCourses(String studentid)
	{
		List<Course> c= null;
		try {
			 c = sdi.getAvailableCourses(studentid);
		}catch(SemesterNotRegisteredException e)
		{
			System.out.println(e.getMessage());
		}
		return c;
	}

	/** 
	 * Method to addCourse
	 * @param  studentid,coursecode,type
	 * @return void
	 * @throws CourseNotFoundException, CourseLimitExceedException
	 */
	
	
	public void addCourse(String studentid, String courseCode, int type)
	{
		try {
			sdi.addCourse(studentid, courseCode, type);
			String courseType = type == 1 ? "PRIMARY" : "ALTERNATE";
			System.out.println("\nSUCCESSFULLY REGISTERED FOR COURSE WITH COURSE CODE \""+courseCode+"\" (TYPE: "+courseType+")\n");
		}catch(CourseLimitExceedException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/** 
	 * Method to dropCourse
	 * @param  studentid,coursecode
	 * @return void
	 * @throws CourseNotFoundException
	 */
	

	public void dropCourse(String studentid, String courseId) {
		try {
			sdi.dropCourse(studentid, courseId);
		} catch (CourseNotFoundException e) {
			System.out.println("\nYOU ARE NOT REGISTERED FOR COURSE WITH COURSE CODE \""+courseId+"\"!\n");
		}
	}
	
	/** 
	 * Method to getFees
	 * @param  studentid
	 * @return List<Course>
	 * @throws 
	 */

	public List<Course> getFees(String studentid)
	{
		return sdi.getFees(studentid);
	}
	
	/** 
	 * Method to  payFeesByCash
	 * @param  ofp,p
	 * @return void
	 * @throws 
	 */
		
	
	public void payFeesByCash(OfflinePayment ofp, Payment p)
	{
		sdi.payFeesByCash(ofp, p);
		return;
	}
	
	/** 
	 * Method to payFeesByCheque
	 * @param  ofp,p
	 * @return  void
	 * @throws 
	 */
	public void payFeesByCheque(OfflinePayment ofp, Payment p)
	{
		sdi.payFeesByCheque(ofp, p);
		return;
	}
	
	/** 
	 * Method to payFeesByCard
	 * @param  onp,p
	 * @return void
	 */
	public void payFeesByCard(OnlinePayment onp, Payment p)
	{
		sdi.payFeesByCard(onp, p);
		return;
	}
	
	/** 
	 * Method to payFeesByNetBanking
	 * @param  onp,p
	 * @return void
	 */
	public void payFeesByNetBanking(OnlinePayment onp, Payment p)
	{
		sdi.payFeesByNetBanking(onp, p);
		return;
	}

}
