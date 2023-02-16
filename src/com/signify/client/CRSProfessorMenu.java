/**
 * 
 */
package com.signify.client;
import com.signify.service.ProfessorServiceOperation;

/**
 * @author prati
 *
 */
public class CRSProfessorMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProfessorServiceOperation service = new ProfessorServiceOperation();
		service.updateDetails(null);
		service.addGrade(null);
		service.updatePassword(null);
		service.viewEnrolledStudents(null);
	}

}
