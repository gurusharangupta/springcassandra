package com.cog.springcassandra.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cog.springcassandra.model.ProductForm;
import com.cog.springcassandra.model.UserForm;
import com.cog.springcassandra.service.EmailService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;


@Controller
@Path("/sendMail")
@Api(value = "Email resource", produces = "application/json")
public class EmailController {
	
	@Autowired
    EmailService emailService;    

    @GET
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/email")
    
    public String sendEmail() throws Exception{
    	
    	//String emailStatus = emailService.sendMail("mailto9a@gmail.com", "mailto9a@gmail.com", "User Registered", "Click following url for confirmation");
        
    	return "";
    }
}
