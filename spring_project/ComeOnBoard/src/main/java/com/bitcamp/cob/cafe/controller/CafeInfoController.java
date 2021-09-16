package com.bitcamp.cob.cafe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.cob.cafe.domain.Cafe;
import com.bitcamp.cob.cafe.domain.CafeReview;
import com.bitcamp.cob.cafe.service.CafeInfoService;
import com.bitcamp.cob.cafe.service.CafeReviewService;

@Controller
public class CafeInfoController {

	@Autowired
	private CafeInfoService cafeInfoService;
	
	// 카페 페이지
	@RequestMapping(value = "/cafe/cafe_page/{id}", method = RequestMethod.GET)
	public String cafeInfo(Model model, @PathVariable("id") int idx, HttpSession session) {
		
		Cafe cafe = null;		
		cafe = cafeInfoService.getCafeInfo(idx);
		model.addAttribute("cafeInfo", cafe);
		return "cafe/cafe_page";
	}
	
	// 카페 정보 입력폼
	
	@RequestMapping(value = "/cafe/cafe_regForm", method = RequestMethod.GET)
	public void cafeRegForm() {}
	
	// 카페 정보 입력
	@RequestMapping(value = "/cafe/cafe_regForm", method = RequestMethod.POST)
	public String regCafe(Cafe cafe, Model model) {

		model.addAttribute("cafeRegResult", cafeInfoService.regCafe(cafe));
		//System.out.println("생성된 IDX : " + cafe.getCafeIdx());
		model.addAttribute("cafeIdx", cafe.getCafeIdx());
		return "cafe/cafe_regResult";
	}
	
	// 카페 정보 수정
	@RequestMapping(value = "/cafe/cafe_info", method = RequestMethod.POST)
	public String updateCafeInfo(Cafe cafe, Model model) {

		model.addAttribute("cafeModifyResult", cafeInfoService.updateCafeInfo(cafe));
		model.addAttribute("cafeIdx", cafe.getCafeIdx());
		return "cafe/cafe_regResult";
	}
	
	
	// 이미지 저장폼
	//@RequestMapping(value = "/cafe/cafe_regImg", method = RequestMethod.GET)
	//public void cafeReg() {}
	
	// 이미지 저장
	@RequestMapping(value = "/cafe/cafe_regImg", method = RequestMethod.POST)
	public String regImg(Cafe cafe, HttpServletRequest request, Model model) {
		System.out.println("regImg 메소드 - cafe 전달값 : "+cafe);
		int resultThumbnail = 0;
		int resultImg = 0;
		
		if(cafe.getCafeThumbnailFile() != null && !cafe.getCafeThumbnailFile().isEmpty() ) {
			resultThumbnail = cafeInfoService.regCafeThumbnail(cafe, request);	
		}
		if(cafe.getCafeImgFile() != null && cafe.getCafeImgFile().size() > 0 ) {
			if(cafeInfoService.regCafeImg(cafe, request) == 1) {
				resultImg++;
			}
		}
		System.out.println("regImg 메소드 - 썸네일 : "+cafe.getCafeThumbnail());
		if(cafe.getCafeImg() != null) {
			model.addAttribute("requestNum", cafe.getCafeImgFile().size());
		}
		System.out.println("regImg 메소드 - 이미지 : "+cafe.getCafeImg());
		System.out.println("regImg 메소드 - 썸네일, 이미지 결과값 : "+resultThumbnail + resultImg);
		model.addAttribute("resultThumbnail", resultThumbnail);
		model.addAttribute("resultImg", resultImg);
		
		return null;//"cafe/cafe_regImgResult";
	}
	
	@RequestMapping(value = "/cafe/cafe_regImg", method = RequestMethod.PUT)
	public String updateImg(Cafe cafe, HttpServletRequest request, @RequestParam("memIdx") int memIdx) {
		System.out.println("이미지 저장 메소드 실행");
		int result = cafeInfoService.regCafeThumbnail(cafe, request);	
		int result2 = cafeInfoService.regCafeImg(cafe, request);
		System.out.println("이미지 저장 결과 : "+result);
		System.out.println("이미지 저장 결과 : "+result2);
		System.out.println("파일이름 : "+cafe.getCafeThumbnail());
		return null;
	}
	


}



















