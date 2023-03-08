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

/**
 * @author dp201
 *
 */
public interface StudentInterface {
	public String register(Student st);
	public boolean semesterRegister(String studentid, int semester);
	public String getStudentId(String userid);
	public int getApprovedStatus(String studentId);
	public List<Course> getAvailableCourses(String studentid);
	public String addCourse(String studentId, String courseCode, int type);
	public String dropCourse(String studentId, String courseCode);		
	public List<RegisteredCourse> viewRegisterCourses(String studentId);
	public List<Grades> viewGrades(String studentId);
	public List<Course> getFees(String studentId);
	public String payFeesByCard(OnlinePayment onp, Payment p);
	public String payFeesByNetBanking(OnlinePayment onp, Payment p);
	public String payFeesByCash(OfflinePayment ofp, Payment p);
	public String payFeesByCheque(OfflinePayment ofp, Payment p);

}
