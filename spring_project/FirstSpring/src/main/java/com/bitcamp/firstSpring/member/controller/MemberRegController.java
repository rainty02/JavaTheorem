package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.RegRequest;

@Controller
@RequestMapping("/member/regform")
public class MemberRegController {

	//@RequestMapping("/member/regform")
	@RequestMapping(method = RequestMethod.GET) 
	public String getRegForm() {
		return "member/memberRegForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String RegMember(
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam("membername") String membername,
			@RequestParam("photo") String photo,
			@ModelAttribute("regReq") RegRequest regReq,
			HttpServletRequest req,
			Model model
			) {
		
		model.addAttribute("memberid", memberid);
		model.addAttribute("password", password);
		model.addAttribute("membername", membername);
		model.addAttribute("photo", photo);
				
		model.addAttribute("reqmemberid", req.getParameter("memberid"));
		model.addAttribute("reqpassword", req.getParameter("password"));
		model.addAttribute("reqmembername", req.getParameter("membername"));
		model.addAttribute("reqphoto", req.getParameter("photo"));
		
		
		return "member/memberReg";
	}
}
