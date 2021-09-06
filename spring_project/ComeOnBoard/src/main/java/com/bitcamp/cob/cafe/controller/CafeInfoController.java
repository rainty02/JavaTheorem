package com.bitcamp.cob.cafe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.cob.cafe.domain.Cafe;
import com.bitcamp.cob.cafe.domain.CafeReview;
import com.bitcamp.cob.cafe.service.CafeInfoService;
import com.bitcamp.cob.cafe.service.CafeReviewService;

@Controller
public class CafeInfoController {

	@Autowired
	private CafeInfoService cafeInfoService;
	
	@RequestMapping(value = "/cafe/cafe_page/{id}", method = RequestMethod.GET)
	public String cafeInfo(Model model, @PathVariable("id") int idx, HttpSession session) {
		
		Cafe cafe = null;
		//session.getAttribute(name);
		//if(loginChk) {}
		
		cafe = cafeInfoService.getCafeInfo(idx);
		model.addAttribute("cafeInfo", cafe);
		return "cafe/cafe_page";
	}
	


}



















