/**
 * 
 */
package com.signify.service;

import com.signify.collections.StudentCollection;

/**
 * @author hp
 *
 */
public interface StudentInterface {
	public void changePassword();
	public StudentCollection register() ;
	public void viewGradeCard() ;
    public void registerCourses() ;
	public void addCourse() ;
	public void dropCourse() ;
	public void payFees() ;
	public void viewRegisteredCourses() ;
}
