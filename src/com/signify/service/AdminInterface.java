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
	public ProfessorCollection addProfessor() ;
	public void assignCourse();
	public void approveStudent();
	public CourseCollection addCourse(ProfessorCollection obj);
	public CourseCollection deleteCourse(CourseCollection obj);
	public void  viewCourseDetails(CourseCollection obj);
	public CourseCollection getCourseData();
	public void generateReportCard();
}
