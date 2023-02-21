/**
 * 
 */
package com.signify.dao;

import com.signify.bean.User;

/**
 * @author hp
 *
 */
public interface UserDAOInterface {
	public User loginDAO(int userId, String password);
	public boolean updatepasswordDAO(int userId, String userPassword);
}
