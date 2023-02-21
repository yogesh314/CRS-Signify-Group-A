/**
 * 
 */
package com.signify.service;

import com.signify.bean.User;

/**
 * @author hp
 *
 */
public interface UserInterface {
//	public void updateDetails(String name, String role) ;
//	
//	public void updatePassword() ;
	public User login() ;
	public void updatePassword();
}
