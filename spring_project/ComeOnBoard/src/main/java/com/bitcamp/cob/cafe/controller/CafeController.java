package com.bitcamp.cob.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.cob.cafe.domain.Cafe;
import com.bitcamp.cob.cafe.service.cafeListService;

@Controller
public class CafeController {

	@Autowired
	private cafeListService cafeListService;
	
	@RequestMapping(value = "/cafe/cafe_list", method = RequestMethod.GET)
	public String cafeList(Model model) {
		List<Cafe> list = null;
		list = cafeListService.cafeList("cafeIdx");
		model.addAttribute("cafelist", list);
		return "cafe/cafe_list";
	}
	
	@RequestMapping(value = "/cafe/cafe_list", method = RequestMethod.POST)
	public String cafeList(Model model,
			@RequestParam("searchType") String type
			) {
		List<Cafe> list = null;
		
		// 검색어로 검색할 경우 검색어의 유효성 처리
		if(type != null && type.trim().length() > 0) {
			list = cafeListService.cafeList(type);
		}
				
		model.addAttribute("cafelist2", list);
		return "cafe/cafe_list";
	}
	
}
