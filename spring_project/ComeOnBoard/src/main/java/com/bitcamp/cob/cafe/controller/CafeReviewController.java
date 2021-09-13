package com.bitcamp.cob.cafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.cob.cafe.domain.CafeReview;
import com.bitcamp.cob.cafe.domain.CafeReviewPaging;
import com.bitcamp.cob.cafe.service.CafeReviewService;

@Controller
public class CafeReviewController {

	@Autowired
	private CafeReviewService cafeReviewService;

	@RequestMapping(value= "/cafe/cafe_review", method = RequestMethod.GET)
	@ResponseBody
	public List<CafeReview> getCafeReview(CafeReviewPaging cafeReviewPaging) {
		
		List<CafeReview> reviewList = null;
		
		System.out.println("전달값" + cafeReviewPaging);
		
		//페이징 처리
		
		reviewList = cafeReviewService.getCafeReview(cafeReviewPaging);
		System.out.println("결과값" + reviewList);
		return reviewList;
	}
		
	@RequestMapping(value= "/cafe/cafe_page/{id}", method = RequestMethod.POST)
	public String writeCafeReview(CafeReview cafeReview, @PathVariable("id") int idx) {
	
		cafeReview.setCafeIdx(idx);
		System.out.println(cafeReview);
		
		int result = cafeReviewService.writeCafeReview(cafeReview);
		System.out.println(result);
		return "redirect:"+idx;
	}
	
	@RequestMapping(value= "/cafe/cafe_page/{id}", method = RequestMethod.PUT)
	public String updateCafeReview(CafeReview cafeReview, @PathVariable("id") int idx) {
	
		System.out.println("수정 메소드 실행 : "+cafeReview);
		
		int result = cafeReviewService.updateCafeReview(cafeReview);
		System.out.println("수정 결과 : " + result);
		return "redirect:"+idx;
	}
	
	@RequestMapping(value="/cafe/cafe_page/{id}", method = RequestMethod.DELETE)
	public String deleteCafeReview(CafeReview cafeReview, @PathVariable("id") int idx) {
		
		System.out.println("삭제 메소드 실헹 : " + cafeReview);
		
		int result = cafeReviewService.deleteCafeRevie(cafeReview.getRevIdx());
		System.out.println("삭제 결과 : " + result);
		return "redirect:"+idx;
	}
}
	
	
	
	
	

	
