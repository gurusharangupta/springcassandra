package com.cog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cog.model.User;
import com.cog.service.UserService;

@RestController
@RequestMapping(value="/api")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	  @RequestMapping(value = "/user", method = RequestMethod.POST)    
	    public User create(@RequestBody User user) {        
	        return userService.createUser(user);
	    }
	

}
