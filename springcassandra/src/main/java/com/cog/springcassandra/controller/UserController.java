package com.cog.springcassandra.controller;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.UserForm;
import com.cog.springcassandra.service.UserService;
import com.datastax.driver.core.utils.UUIDs;
import com.google.common.net.MediaType;

@Component
@Path("/user")
public class UserController {

	@Autowired
	public UserService userService;

	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(UserForm userForm) {
		UUID id = UUIDs.timeBased();
		userForm.setId(id);
		User user = userService.createUser(userForm);
		return Response.status(200).entity(user).build();
	}

}
