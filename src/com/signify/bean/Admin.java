/**
 * 
 */
package com.signify.bean;
import java.util.*;


/**
 * @author hp
 *
 */
public class Admin extends User {
	private int adminId;
	private Date DOJ;
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	
}
