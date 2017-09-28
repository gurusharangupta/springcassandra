package com.cog.springcassandra.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cog.springcassandra.dao.UserDao;
import com.cog.springcassandra.data.User;
import com.cog.springcassandra.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	@Override
	public User createUser(User user) {
		 
		return userDao.createUser(user);
		
	}

}