package com.bitcamp.firstSpring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/login") // 기본 경로 설정 후 메소드에서도 경로를 지정해주면 기본경로+경로가 되므로 주의
public class LoginController {

	// RequestMethod 방식에 따라 실행하는 메소드가 다름
	
	//@RequestMapping("/member/loginform")
	//@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(@RequestParam("page") int page) {
		
		System.out.println("page : " + (page+1));
		return "member/loginForm"; 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		return "member/login"; //	/WEB-INF/views/login.jsp
	}
}
