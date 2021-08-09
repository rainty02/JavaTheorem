package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.domain.MemberFile;
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
			MemberFile memberFile,
			//@RequestParam("memberid") String memberid,
			HttpServletRequest request,
			Model model
			) {
		///System.out.println(memberFile.getMemberid());
		//System.out.println(memberFile.getPassword());
		//System.out.println(memberFile.getMembername());
		//System.out.println(memberFile.getPhoto().getOriginalFilename());
		
		int insertChk = regService.register(memberFile, request);		
		model.addAttribute("insertChk", insertChk);
		
		return "member/reg";
	}
}
