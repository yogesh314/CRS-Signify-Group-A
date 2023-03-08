/**
 * 
 */
package com.signify.restcontroller;

/**
 * @author HP
 *
 */
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Course;
import com.signify.bean.Grades;
import com.signify.bean.OfflinePayment;
import com.signify.bean.OnlinePayment;
import com.signify.bean.Payment;
import com.signify.bean.RegisteredCourse;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.service.StudentServiceOperation;

@RestController
public class StudentRestControllerAPI {
	
	@Autowired
	private StudentServiceOperation stob;
	
	@RequestMapping( method = RequestMethod.POST,value = "/register")
	@ResponseBody
	public String register(@RequestBody Student st) {
		return stob.register(st);  
	}
	
	@RequestMapping(  method = RequestMethod.POST,value = "/semReg")
	@ResponseBody
	 public boolean semesterRegister(@RequestBody Student st) {
		return stob.semesterRegister(st.getStudentid(),st.getSem());
		   
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/getStudent")
	@ResponseBody
	 public String getStudentId(@RequestBody User us){
		return stob.getStudentId(us.getUserId());
		   
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/appStatus")
	@ResponseBody
	public int getApprovedStatus(@RequestBody Student st) {
		return stob.getApprovedStatus(st.getStudentid());
		   
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/avaCourse")
	@ResponseBody
	public List<Course> getAvailableCourses(@RequestBody Student st) {
		return stob.getAvailableCourses(st.getStudentid());
		   
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/addCourse")
	@ResponseBody
	public String addCourse(@RequestBody Student st) {
		return stob.addCourse(st.getStudentid(),st.getCoursecode(),st.getType());
		   
	}
	
	@RequestMapping( method = RequestMethod.DELETE,value = "/dropCourse")
	@ResponseBody
	public String dropourse(@RequestBody Student st) {
		return stob.dropCourse(st.getStudentid(),st.getCoursecode());
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/viewRegCourse")
	@ResponseBody
	public List<RegisteredCourse> viewRegCourse(@RequestBody Student st) {
		return stob.viewRegisterCourses(st.getStudentid());
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/viewGrades")
	@ResponseBody
	public List<Grades> viewGrades(@RequestBody Student st) {
		return stob.viewGrades(st.getStudentid());
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/getFees")
	@ResponseBody
	public List<Course> getFees(@RequestBody Student st) {
		return stob.getFees(st.getStudentid());
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/FeeByCard")
	@ResponseBody
	public String payFeesByCard(@RequestBody OnlinePayment on , @RequestBody Payment p) {
		return stob.payFeesByCard(on,p);
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/FeeByNetBanking")
	@ResponseBody
	public String payFeesByNetBanking(@RequestBody OnlinePayment on , @RequestBody Payment p) {
		return stob.payFeesByNetBanking(on,p);
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/FeeByCash")
	@ResponseBody
	public String payFeesByCash(@RequestBody OfflinePayment of , @RequestBody Payment p) {
		return stob.payFeesByCash(of,p);
	}
	
	@RequestMapping( method = RequestMethod.POST,value = "/FeeByCheque")
	@ResponseBody
	public String payFeesByCheque(@RequestBody OfflinePayment of , @RequestBody Payment p) {
		return stob.payFeesByCheque(of,p);
	}

}
