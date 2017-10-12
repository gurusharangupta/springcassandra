package com.cog.springcassandra.controller;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cog.springcassandra.data.User;
import com.cog.springcassandra.model.UserForm;
import com.cog.springcassandra.service.EmailService;
import com.cog.springcassandra.service.UserService;
import com.datastax.driver.core.utils.UUIDs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@Component
@Path("/users")
@Api(value = "User resource", produces = "application/json")
public class UserController {

	@Autowired
	public UserService userService;
	
	@Autowired
    private EmailService emailService; 

	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	@ApiOperation(value = "Creates User resource. Accepts : UserData as input ", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User resource created", responseHeaders = {
					@ResponseHeader(name = "Location", description = "The URL to retrieve created resource", response = User.class)
			}),
			@ApiResponse(code = 404, message = "Failed to create User resource ")
	})	
	public Response create(UserForm userForm) {
		UUID id = UUIDs.timeBased();
		userForm.setId(id);
		User user = userService.createUser(userForm);
		if (user.getId()!=null)
		{
			String status=emailService.sendMail(user);
			System.out.println("=========="+status);
			if(status.contains("OK")){
				return Response.status(200).entity(user).build();
			}
			else
			{
				return Response.status(404).entity(user).build();
			}
		}
		else
		return Response.status(404).entity(user).build();
		
	}

}
