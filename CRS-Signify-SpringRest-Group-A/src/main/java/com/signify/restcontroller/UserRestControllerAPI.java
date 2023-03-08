package com.signify.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.signify.bean.Customer;
import com.signify.bean.User;
import com.signify.exception.UserNotFoundException;
import com.signify.service.UserServiceOperation;

@RestController
public class UserRestControllerAPI {
	
	@Autowired
	private UserServiceOperation userService = new UserServiceOperation();
	

	@RequestMapping(value="/login", method= RequestMethod.POST)
	@ResponseBody
	public String[] login(@RequestBody User usr) {
		return userService.login(usr.getName(),usr.getPassword());
	}
	
	@RequestMapping(value="/updatePassword", method= RequestMethod.PUT)
	@ResponseBody
	public boolean updatePassword(@RequestBody User usr) {
		return userService.updatePassword(usr.getName(),usr.getPassword(),usr.getNewpassword());
	}
	
	
}