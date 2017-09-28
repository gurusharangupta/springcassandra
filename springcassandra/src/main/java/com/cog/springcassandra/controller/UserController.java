package com.cog.springcassandra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.UserForm;
import com.cog.springcassandra.service.UserService;

@RestController
@RequestMapping(value="/api")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	  @RequestMapping(value = "/user", method = RequestMethod.POST)    
	    public User create(@RequestBody UserForm userForm) {        
	        return userService.createUser(userForm);
	    }
	

}
