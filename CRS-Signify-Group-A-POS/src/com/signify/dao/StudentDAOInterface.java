package com.signify.dao;
import com.signify.bean.*;
import com.signify.exception.CourseLimitExceedException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.SemesterNotRegisteredException;
import com.signify.exception.StudentNotRegisteredException;
import com.signify.exception.UserNotFoundException;

import java.util.*;

public interface StudentDAOInterface {
	
	/** 
	 * Method to  register
	 * @param  student
	 * @return void
	 * @throws 
	 */
	public void register(Student student);
	
	/** 
	 * Method to  semesterRegister
	 * @param  studentid,sem
	 * @return void
	 * @throws StudentNotRegisteredException
	 */
	
	public void semesterRegister(String studentid, int sem) throws StudentNotRegisteredException;
	
	/** 
	 * Method to  getStudentId
	 * @param  userid
	 * @return String
	 * @throws 
	 */
	
	public String getStudentId(String userid);
	
	/** 
	 * Method to  getIsApprovedStatus
	 * @param  studentid
	 * @return int
	 * @throws 
	 */
	
	public int getIsApprovedStatus(String studentid);
	
	/** 
	 * Method to getAvailableCourses
	 * @param  studentid
	 * @return list<Course>
	 * @throws SemesterNotRegisteredException
	 */
	
	public List<Course> getAvailableCourses(String studentId) throws SemesterNotRegisteredException;
	

	/** 
	 * Method to addCourse
	 * @param  studentid,coursecode,type
	 * @return void
	 * @throws CourseNotFoundException, CourseLimitExceedException
	 */
	
	public void addCourse(String studentid, String courseCode, int type) throws CourseNotFoundException, CourseLimitExceedException;
	
	
	/** 
	 * Method to dropCourse
	 * @param  studentid,coursecode
	 * @return void
	 * @throws CourseNotFoundException
	 */
	public void dropCourse(String studentid, String courseCode) throws CourseNotFoundException;
	
	
	/** 
	 * Method to viewGrades
	 * @param  studentid
	 * @return List<Grades>
	 * @throws 
	 */
	public List<Grades> viewGrades(String studentid);	
	
	/** 
	 * Method to viewRegisteredCourses
	 * @param  studentid
	 * @return List<RegisteredCourse>
	 * @throws 
	 */
		
	public List<RegisteredCourse> viewRegisteredCourses(String studentid);
	
	/** 
	 * Method to getFees
	 * @param  studentid
	 * @return List<Course>
	 * @throws 
	 */
		
	public List<Course> getFees(String studentid);
	
	/** 
	 * Method to payFeesByCheque
	 * @param  ofp,p
	 * @return  void
	 * @throws 
	 */
	
	public void payFeesByCheque(OfflinePayment ofp, Payment p);
	
	/** 
	 * Method to  payFeesByCash
	 * @param  ofp,p
	 * @return void
	 * @throws 
	 */
		
	
	public void payFeesByCash(OfflinePayment ofp, Payment p);
	
	/** 
	 * Method to payFeesByCard
	 * @param  onp,p
	 * @return void
	 * @throws 
	 */
		
	public void payFeesByCard(OnlinePayment onp, Payment p);
	
	/** 
	 * Method to payFeesByNetBanking
	 * @param  onp,p
	 * @return void
	 * @throws 
	 */
		
	public void payFeesByNetBanking(OnlinePayment onp, Payment p);
}
