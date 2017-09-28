package com.cog.springcassandra.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.UserForm;

@Component
public class UserFormToUser implements Converter<UserForm,User>{

	@Override
	public User convert(UserForm userForm) {
		User user = new User();
		if(userForm.getId()!=null && !StringUtils.isEmpty(userForm.getId()))
		
		user.setId(userForm.getId());
		user.setAddress(userForm.getAddress());
		user.setBirthDate(userForm.getBirthDate());
		user.setEmail(userForm.getEmail());
		user.setMobile(userForm.getMobile());
		user.setUserName(userForm.getUserName());
		user.setPassword(userForm.getPassword());
		return user;
	}

	
	
}
