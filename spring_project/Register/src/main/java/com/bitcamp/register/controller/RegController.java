package com.bitcamp.register.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.register.service.RegService;

@Controller
@RequestMapping("/regForm")
public class RegController {
	
	@Autowired
	RegService regService;

	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		return "regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regResult(HttpServletRequest request) {
		
		regService.regMember(request);
		
		return "reg_view";
	}	
}
