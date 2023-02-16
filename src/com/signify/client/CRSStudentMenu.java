/**
 * 
 */
package com.signify.client;

import com.signify.service.StudentServiceOperation;

/**
 * @author prati
 *
 */
public class CRSStudentMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentServiceOperation service = new StudentServiceOperation();
		
		service.addCourse();
		service.dropCourse();
		service.payFees();
		service.register();
		service.registerCourse();
		service.viewRegisteredCourse();
		service.viewGradeCard();
		service.viewCourseDetails();
		service.updateDetails();
		service.updatePassword();
	}
}
