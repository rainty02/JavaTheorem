package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.LoginService;
import com.bitcamp.op.member.service.RegService;

@Controller
@RequestMapping("/member/regForm")
public class RegController {

	@Autowired
	private RegService regService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String regForm(
			@RequestHeader(value="referer", required=false) String redirectUri,
			Model model
			) {
		model.addAttribute("redirectUri", redirectUri);
		return "member/regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(
			
			
			Model model
			) {
		
		// 사용자가 입력한 아아디, 패스워드 서비스에 전달해서 로그인 처리
		boolean loginChk = regService.register();
		model.addAttribute("loginChk", loginChk);
		String view = "member/regForm";
		
		if(redirectUri!=null && loginChk) {
			view = "redirect:"+redirectUri;
		}
		
		return view;
	}
}
