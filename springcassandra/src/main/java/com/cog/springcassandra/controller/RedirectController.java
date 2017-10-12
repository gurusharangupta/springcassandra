package com.cog.springcassandra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class RedirectController {

	@RequestMapping(value = "/**/{[path:[^\\.]*}")
	public String forward() {
		return "forward:index.html";
	}
}
