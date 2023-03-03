package com.signify.bean;
public class Professor extends User{
	
	String department, designation;
	String courseTaught;
	String professorid;
	String grade;
	String studentid;
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getProfessorid() {
		return professorid;
	}

	public void setProfessorid(String professorid) {
		this.professorid = professorid;
	}

	public String getCourseTaught() {
		return courseTaught;
	}

	public void setCourseTaught(String courseTaught) {
		this.courseTaught = courseTaught;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	

}
