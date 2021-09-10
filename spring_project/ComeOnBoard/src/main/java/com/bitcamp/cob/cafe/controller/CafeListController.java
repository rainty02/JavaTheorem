package com.bitcamp.cob.cafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.cob.cafe.domain.Cafe;
import com.bitcamp.cob.cafe.domain.CafePaging;
import com.bitcamp.cob.cafe.service.cafeListService;

@Controller
public class CafeListController {

	@Autowired
	private cafeListService cafeListService;
	
	// 기본 페이지 출력 - 최신 등록순 
	@RequestMapping(value = "/cafe/cafe_list", method = RequestMethod.GET)
	public String cafeList(Model model, CafePaging cafePaging) {
		
		System.out.println("cafeList GET 메소드 실행");
		
		List<Cafe> list = null;
		
		cafePaging.setPage(1);
		
		// 디폴트 페이지를 위한 분기
//		if(cafePaging.getSortType() == null) {
//			cafePaging.setSortType("cafeIdx desc");
//		}
		
		if(cafePaging.getSortType() == null) {
			cafePaging.setSortType("cafeIdx");
		}
		
		System.out.println("cafePaging : " + cafePaging);
		
		if(cafePaging.getKeyword() != null && cafePaging.getKeyword().trim().length() > 0) {
			list = cafeListService.cafeListByKeyword(cafePaging);
		} else {
			list = cafeListService.cafeListBySort(cafePaging);
		}
		model.addAttribute("cafePaging", cafePaging);
		model.addAttribute("list", list);
		
		return "cafe/cafe_list";
	}
	
	
//	// 검색어
//	@RequestMapping(value = "/cafe/cafe_list", method = RequestMethod.GET)
//	public String cafeList(Model model, CafeSearchType cafeSearchType) {
//		System.out.println("cafeList 메소드 실행");
//		List<Cafe> list = null;
//		System.out.println("cafeSearchType : "+cafeSearchType);
//		// 검색어 입력시 검색어의 유효성 처리
//		if (cafeSearchType.getKeyword() != null && cafeSearchType.getKeyword().trim().length() > 0) {
//			list = cafeListService.cafeListByKeyword(cafeSearchType);
//		}
//		model.addAttribute("list", list);
//		System.out.println("list : "+list);
//		return "cafe/cafe_list";
//	}
//	
	// 정렬 버튼
//	@RequestMapping(value = "/cafe/cafe_list", method = RequestMethod.POST)
//	@ResponseBody
//	public List<Cafe> cafeListBySort(CafeSearchType cafeSearchType) {
//		System.out.println("0");
//		List<Cafe> list = null;
//
//		// 정렬 방식 선택시
//		if(!cafeSearchType.getSearchType().isEmpty()) {
//			if(cafeSearchType.getSearchType().equals("cafeRating")) {
//				// 카페 평점은 내림차순으로 정렬
//				cafeSearchType.setSearchType("cafeRating desc");
//			}
//		}
//			list = cafeListService.cafeListBySort(cafeSearchType.getSearchType());
//		return list;
//	}
	
	// 스크롤 페이징
	@RequestMapping(value = "/cafe/cafe_listPaging", method = RequestMethod.POST)
	@ResponseBody
	public CafePaging listPaging(@RequestBody CafePaging cafePaging, Model model){
		
		System.out.println("cafeList POST 메소드 실행");
		System.out.println("cafeList POST : " + cafePaging);
		List<Cafe> list = null;
		
		if(cafePaging.getSortType() == null) {
			cafePaging.setSortType("cafeIdx");
		}
		
		if(cafePaging.getKeyword() != null && cafePaging.getKeyword().trim().length() > 0) {
			System.out.println("키워드 설정시 실행");
			list = cafeListService.cafeListByKeyword(cafePaging);
			System.out.println("컨트롤러 키워드 리스트 반환값 실행");
		} else {
			System.out.println("컨트롤러 정렬 설정시 실행");
			list = cafeListService.cafeListBySort(cafePaging);
			System.out.println("컨트롤러 정렬 리스트 반환값 실행");
		}
		cafePaging.setCafe(list);
		cafePaging.setTotalCnt(cafeListService.getCafeTotalCnt());
		System.out.println("cafePaging : " + cafePaging);
		System.out.println("cafePaging.getCafe : " + cafePaging.getCafe());
		
		model.addAttribute("cafePaging", cafePaging);
		return cafePaging;
	
	}
	
	

	
}
