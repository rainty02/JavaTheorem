package com.bitcamp.cob.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.cob.cafe.domain.CafeReservation;
import com.bitcamp.cob.cafe.service.CafeReservationService;

@Controller
public class CafeReservationController {

	@Autowired
	private CafeReservationService cafeReservationService;
	
	@RequestMapping(value = "/cafe/cafe_reserv", method = RequestMethod.GET)
	@ResponseBody
	public List<CafeReservation> getReservList(CafeReservation cafeReservation) {
		// 전달값 - 카페번호, 날짜, 시간, 인원
		List<CafeReservation> resultList = null;
		resultList = cafeReservationService.getReservList(cafeReservation);		
		return resultList;
	}
}
