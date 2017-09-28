package com.cog.springcassandra.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.UserForm;

@Component
public class UserToUserForm implements Converter<User,UserForm>{

	@Override
	public UserForm convert(User user) {
		
		UserForm userForm = new UserForm();
		if(user.getId()!=null && !StringUtils.isEmpty(user.getId()))
		
			userForm.setId(user.getId());
		userForm.setAddress(user.getAddress());
		userForm.setBirthDate(user.getBirthDate());
		userForm.setEmail(user.getEmail());
		userForm.setMobile(user.getMobile());
		userForm.setUserName(user.getUserName());
		userForm.setPassword(user.getPassword());
		return userForm;
	}

}
