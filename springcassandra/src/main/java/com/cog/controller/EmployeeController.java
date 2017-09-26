package com.cog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cog.empService.EmployeeService;
import com.cog.model.Employee;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	  @RequestMapping(value = "/employee", method = RequestMethod.POST)    
	    Employee create(@RequestBody Employee employee) {        
	        return employeeService.createEmployee(employee);
	    }
	

}
