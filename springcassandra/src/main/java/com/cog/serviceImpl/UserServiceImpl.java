package com.cog.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cog.dao.UserDao;
import com.cog.model.User;
import com.cog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	@Override
	public User createUser(User user) {
		
		return userDao.createUser(user);
	}

}
