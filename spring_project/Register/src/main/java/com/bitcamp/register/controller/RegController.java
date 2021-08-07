package com.bitcamp.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/regForm")
public class RegController {

	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		return "regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regResult() {
		
		
		
		return "reg_view";
	}
	
}
