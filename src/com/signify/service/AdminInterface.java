/**
 * 
 */
package com.signify.service;

import com.signify.collections.CourseCollection;
import com.signify.collections.ProfessorCollection;

/**
 * @author hp
 *
 */
public interface AdminInterface {
	public void addAd();
	public void assignCourse();
	public void dropCourse(String courseCode);
	public void approveStudent();
	public void viewCourseDetails();
	public void viewAdmins();
	public void addProfessor();
	public void generateReportCard();
}
