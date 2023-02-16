/**
 * 
 */
package com.signify.client;
import com.signify.service.AdminServiceOperation;
/**
 * @author prati
 *
 */
public class CRSAdminMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AdminServiceOperation service = new AdminServiceOperation();
		service.addAdmin(null);
		service.addProfessor(null);
		service.approveStudent(null);
		service.assignCourse(null);
		service.updateDetails(null);
		service.updatePassword(null);
	}

}
