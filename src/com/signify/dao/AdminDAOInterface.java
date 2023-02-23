package com.signify.dao;

import com.signify.bean.Admin;

public interface AdminDAOInterface {
	

	
	public void approveStudent();
	
	public void viewCourses();
	
	public void addAdmin(String username, String password, int userId);
	
	public void viewAdmins();

	public void addProfessor();
	public void addCourse();
	
	
	public void dropCourses(String courseCode);
	public void assignProfessorToCourse(int professorId, String courseCode);
}
