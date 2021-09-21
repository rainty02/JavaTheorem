package com.bitcamp.cob.cafe.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.cob.cafe.domain.CafeReservation;
import com.bitcamp.cob.cafe.service.CafeReservationService;

@Controller
public class CafeReservationController {

	@Autowired
	private CafeReservationService cafeReservationService;
	
	// 예약 버튼
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
	
	// 예약
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
	
	// 결제
	@RequestMapping(value = "/cafe/cafe_payReserv", method = RequestMethod.POST)
	@ResponseBody
	public String payReserv(CafeReservation cafeReservation) {
		System.out.println("결제메소드 전달값 : "+ cafeReservation);
		try {
			// 주소
			URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
			// 서버 연결
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 메소드
			connection.setRequestMethod("POST");
			// 속성
			connection.setRequestProperty("Authorization", "KakaoAK 2d49fe92fc857324237e74e45eef3004");
			connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			connection.setDoOutput(true);
			// 파라미터
			String parameter = "cid=TC0ONETIME";
			parameter += "&partner_order_id=partner_order_id";
			parameter += "&partner_user_id=partner_user_id";
			parameter += "&item_name=초코파이";
			parameter += "&quantity=1";
			parameter += "&total_amount=2200";
			parameter += "&vat_amount=200";
			parameter += "&tax_free_amount=0";
			parameter += "&approval_url=https://localhost:8080/cob/cafe/cafe_payReserv";
			parameter += "&fail_url=https://localhost:8080/cob/cafe/cafe_payFailReserv";
			parameter += "&cancel_url=https://localhost:8080/cob/cafe/cafe_payCancelReserv";
			// 전달
			OutputStream output = connection.getOutputStream();
			// 데이터 전달
			DataOutputStream dataOutput = new DataOutputStream(output);
			// 파라미터를 바이트로 변환
			dataOutput.writeBytes(parameter);
			// close시 flush(값 비움) 호출
			dataOutput.close();
			// 결과
			int apiResult = connection.getResponseCode();
			
			// 결과 반환
			InputStream input;
			if(apiResult == 200) {
				input = connection.getInputStream();
			} else {
				input = connection.getErrorStream();
			}
			// 결과 반환값 읽음
			InputStreamReader inputReader = new InputStreamReader(input);
			// 바이트를 문자열로 변경해서 읽음
			BufferedReader bufferReader = new BufferedReader(inputReader);
			System.out.println("리드라인 : "+bufferReader.readLine());
			return bufferReader.readLine();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "1";
	}
	
	// 예약 리스트
	@RequestMapping(value = "/cafe/cafe_reserv_list", method = RequestMethod.POST)
	@ResponseBody
	public List<CafeReservation> getReservList(CafeReservation cafeReservation) {
		// 전달값 - 카페번호, 날짜, 시간, 인원
		//System.out.println("예약메소드 전달값 : "+ cafeReservation);
		List<CafeReservation> resultList = null;
		resultList = cafeReservationService.getReservList(cafeReservation);
		//System.out.println("예약메소드 반환값 : "+ resultList);
		return resultList;
	}
	
	// 예약 취소
	@RequestMapping(value = "/cafe/cafe_reserv", method = RequestMethod.DELETE)
	@ResponseBody
	public int delReserv(@RequestParam("reservIdx") int reservIdx) {
		// 전달값 - 예약 번호
		System.out.println("예약메소드 전달값 : "+ reservIdx);
		int result = 0;
		result = cafeReservationService.delReserv(reservIdx);
		System.out.println("예약메소드 반환값 : "+ result);
		return result;
	}
}
