package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {

	@RequestMapping("/header/header")
	public String getHeader(@RequestHeader("referer") String referer, Model model) {
		
		System.out.println(referer);
		model.addAttribute("re", referer);
		
		//return "header/headerInfo";
		return "redirect:" + referer; // 
	}
	
}
