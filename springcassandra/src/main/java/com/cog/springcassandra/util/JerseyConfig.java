package com.cog.springcassandra.util;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.cog.springcassandra.controller.UserController;

@Component
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig() {
		register(UserController.class);
	}

}
