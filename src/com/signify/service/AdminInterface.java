package com.signify.service;

public interface AdminInterface {
	public String addProfessor(String a);
	public String assignCourse(String a);
	public String approveStudent(String a);
	public String updateDetails(String a);
	public String updatePassword(String a);
	public String addAdmin(String a);
	public void generateReportCard();
	public void assignProfToCourse() ;

}
