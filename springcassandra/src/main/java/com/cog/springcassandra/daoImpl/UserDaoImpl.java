package com.cog.springcassandra.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cog.springcassandra.converter.UserFormToUser;
import com.cog.springcassandra.dao.UserDao;
import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.UserForm;
import com.cog.springcassandra.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserFormToUser userFormtoUser;

	@Override
	public User createUser(UserForm userForm) {

		User savedUser = null;
		savedUser = userRepository.save(userFormtoUser.convert(userForm));
		return savedUser;
	}



}
