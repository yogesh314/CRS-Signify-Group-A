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
	public void approveStudent();
	public void viewCourseDetails();
	public void generateReportCard();
}
