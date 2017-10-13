package com.cog.springcassandra.service;

import com.cog.springcassandra.data.User;

public interface EmailService {

	String sendMail(User user);
	String sendConfirmationMail(String email); 
}
