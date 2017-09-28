package com.cog.springcassandra.dao;

import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.UserForm;

public interface UserDao {

	

	User createUser(UserForm userForm);

	User saveOrUpdate(User user);
	
}
