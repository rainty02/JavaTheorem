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
	public List<CafeReservation> getReservButton(CafeReservation cafeReservation) {
		// 전달값 - 카페번호, 날짜, 시간, 인원
		//System.out.println("예약메소드 전달값 : "+ cafeReservation);
		List<CafeReservation> resultList = null;
		resultList = cafeReservationService.getReservButton(cafeReservation);
		//System.out.println("예약메소드 반환값 : "+ resultList);
		return resultList;
	}
	
	@RequestMapping(value = "/cafe/cafe_reserv", method = RequestMethod.POST)
	@ResponseBody
	public int regReserv(CafeReservation cafeReservation) {
		// 전달값 - 카페번호, 날짜, 시간, 인원
		//System.out.println("예약메소드 전달값 : "+ cafeReservation);
		int result = 0;
		result = cafeReservationService.regReserv(cafeReservation);
		//System.out.println("예약메소드 반환값 : "+ result);
		return result;
	}
	
	@RequestMapping(value = "/cafe/cafe_reserv_list", method = RequestMethod.POST)
	@ResponseBody
	public List<CafeReservation> getReservList(CafeReservation cafeReservation) {
		// 전달값 - 카페번호, 날짜, 시간, 인원
		System.out.println("예약메소드 전달값 : "+ cafeReservation);
		List<CafeReservation> resultList = null;
		resultList = cafeReservationService.getReservList(cafeReservation);
		System.out.println("예약메소드 반환값 : "+ resultList);
		return resultList;
	}
}
