package com.signify.service;
import com.signify.helper.*;
import com.signify.bean.*;
import com.signify.dao.StudentDAOImplementation;
import com.signify.exception.CourseLimitExceedException;
import com.signify.exception.CourseNotFoundException;
import com.signify.exception.SemesterNotRegisteredException;
import com.signify.exception.StudentNotRegisteredException;

import java.util.*;

import org.springframework.stereotype.Service;

/**
 * @author dp201
 *
 */
@Service
public class StudentServiceOperation extends UserServiceOperation implements StudentInterface {

	StudentDAOImplementation sdi = new StudentDAOImplementation();
	
	public boolean semesterRegister(String studentid, int sem) {
			sdi.semesterRegister(studentid, sem);
			System.out.println("\nSEMESTER SET TO "+sem+" FOR STUDENT ID \""+studentid+"\"\n");
			return true;
	}

	public String getStudentId(String userid)
	{
		return sdi.getStudentId(userid);
	}
	
	public int getApprovedStatus(String studentid)
	{
		return sdi.getIsApprovedStatus(studentid);
	}
	
	public String register(Student st) {
	
		sdi.register(st);
		return "STUDENT REGISTERED SUCCESSFULLY! WAITING FOR APPROVAL FROM ADMIN.";
	}

	public List<Grades> viewGrades(String studentid) {
		return sdi.viewGrades(studentid);
	}


	public List<RegisteredCourse> viewRegisterCourses(String studentid) {
		return sdi.viewRegisteredCourses(studentid);
	}
	

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
	
	public String addCourse(String studentid, String courseCode, int type)
	{
		try {
			sdi.addCourse(studentid, courseCode, type);
			String courseType = type == 1 ? "PRIMARY" : "ALTERNATE";
			return "\nSUCCESSFULLY REGISTERED FOR COURSE WITH COURSE CODE \""+courseCode+"\" (TYPE: "+courseType+")\n" ;
		}catch(CourseLimitExceedException e)
		{
			return e.getMessage() ;
		}
	}
	

	public String dropCourse(String studentid, String courseCode) {
		try {
			sdi.dropCourse(studentid, courseCode);
			return "Course has been Droped";
		} catch (CourseNotFoundException e) {
			return "\nYOU ARE NOT REGISTERED FOR COURSE WITH COURSE CODE \""+courseCode+"\"!\n";
		}
	}

	public List<Course> getFees(String studentid)
	{
		return sdi.getFees(studentid);
	}
	
	public String payFeesByCash(OfflinePayment ofp, Payment p)
	{
		sdi.payFeesByCash(ofp, p);
		return "Fee paid by Cash";
	}
	public String payFeesByCheque(OfflinePayment ofp, Payment p)
	{
		sdi.payFeesByCheque(ofp, p);
		return "Fee paid by Cheque";
	}
	public String payFeesByCard(OnlinePayment onp, Payment p)
	{
		sdi.payFeesByCard(onp, p);
		return "Fee paid by Card" ;
	}
	public String payFeesByNetBanking(OnlinePayment onp, Payment p)
	{
		sdi.payFeesByNetBanking(onp, p);
		return "Fee paid by Net Banking";
	}
}
