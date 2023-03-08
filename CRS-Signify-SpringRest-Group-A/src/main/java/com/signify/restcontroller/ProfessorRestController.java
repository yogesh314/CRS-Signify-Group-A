/**
 * 
 */
package com.signify.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Customer;
import com.signify.bean.Professor;
import com.signify.bean.Student;
import com.signify.bean.User;
import com.signify.service.ProfessorServiceOperation;

/**
 * @author manoj
 *
 */
@RestController
public class ProfessorRestController {
	@Autowired
	private ProfessorServiceOperation professorService;


	@RequestMapping(value="/viewEnrolledStudents", method= RequestMethod.POST)
	@ResponseBody
	public List<Student> viewEnrolledStudents(@RequestBody Professor prof)
	{
		return professorService.viewEnrolledStudents(prof.getProfessorid());
	}
	
	@RequestMapping(value="/addGrades", method= RequestMethod.PUT)
	@ResponseBody
	public String addGrades(@RequestBody Professor prof) 
	{
		return professorService.addGrades(prof.getProfessorid(),prof.getStudentid(),prof.getGrade());
	}
	
	
}
