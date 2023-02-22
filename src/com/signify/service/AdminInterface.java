/**
 * 
 */
package com.signify.service;

import com.signify.collections.CourseCollection;
import com.signify.collections.ProfessorCollection;

/**
 * @author pratik
 *
 */
public interface AdminInterface {
	public void addAdmin();
	public void assignCourse();
	public void addCourse();
	public void dropCourse(String courseCode);
	public void approveStudent();
	public void viewCourseDetails();
	public void viewAdmins();
	public void addProfessor();
	public void generateReportCard();
}
