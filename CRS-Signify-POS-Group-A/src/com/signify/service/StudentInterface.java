/**
 * 
 */
package com.signify.service;
import java.util.List;

import com.signify.bean.Course;
import com.signify.bean.Grades;
import com.signify.bean.OfflinePayment;
import com.signify.bean.OnlinePayment;
import com.signify.bean.Payment;
import com.signify.bean.RegisteredCourse;
import com.signify.bean.Student;
import com.signify.exception.CourseLimitExceedException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.SemesterNotRegisteredException;
import com.signify.exception.StudentNotRegisteredException;

/**
 * @author dp201
 *
 */
public interface StudentInterface {
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
	 */
	public List<Grades> viewGrades(String studentid);	
	
	/** 
	 * Method to viewRegisteredCourses
	 * @param  studentid
	 * @return List<RegisteredCourse> 
	 */
		
	public List<RegisteredCourse> viewRegisteredCourses(String studentid);
	
	/** 
	 * Method to getFees
	 * @param  studentid
	 * @return List<Course>
	 */
		
	public List<Course> getFees(String studentid);
	
	/** 
	 * Method to payFeesByCheque
	 * @param  ofp,p
	 * @return  void
	 */
	
	public void payFeesByCheque(OfflinePayment ofp, Payment p);
	
	/** 
	 * Method to  payFeesByCash
	 * @param  ofp,p
	 * @return void
	 */
		
	
	public void payFeesByCash(OfflinePayment ofp, Payment p);
	
	/** 
	 * Method to payFeesByCard
	 * @param  onp,p
	 * @return void
	 */
		
	public void payFeesByCard(OnlinePayment onp, Payment p);
	
	/** 
	 * Method to payFeesByNetBanking
	 * @param  onp,p
	 * @return void
	 */
		
	public void payFeesByNetBanking(OnlinePayment onp, Payment p);

}
