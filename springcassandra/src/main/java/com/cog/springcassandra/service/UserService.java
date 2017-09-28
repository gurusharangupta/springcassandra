package com.cog.springcassandra.service;

import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.UserForm;

public interface UserService {

	User createUser(UserForm user);

}
