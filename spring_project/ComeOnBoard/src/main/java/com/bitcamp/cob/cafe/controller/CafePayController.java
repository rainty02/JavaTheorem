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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.cob.cafe.domain.CafeReservation;

@Controller
public class CafePayController {

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
			parameter += "&partner_order_id=cob23592153";
			parameter += "&partner_user_id=cob";
			parameter += "&item_name="+cafeReservation.getReservDate()+"_"+cafeReservation.getReservTime()+"hour_"+cafeReservation.getRequestTable();
			parameter += "&quantity=1";
			parameter += "&total_amount=6000";
			parameter += "&vat_amount=545";
			parameter += "&tax_free_amount=0";
			parameter += "&approval_url=https://localhost:8080/cob/cafe/cafe_paySuccess";
			parameter += "&fail_url=https://localhost:8080/cob/cafe/cafe_payFail";
			parameter += "&cancel_url=https://localhost:8080/cob/cafe/cafe_payCancel";
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
			
			String result = bufferReader.readLine();
            System.out.println("inputLine : "+result);
            return result;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
	}
	
	// 성공
	@RequestMapping(value = "/cafe/cafe_paySuccess")
	public String paySuccess(Model model) {
		model.addAttribute("payResult", "success");
		return "cafe/cafe_payResult";
	}

	// 실패
	@RequestMapping(value = "/cafe/cafe_payFail")
	public String payFail(Model model) {
		model.addAttribute("payResult", "fail");
		return "cafe/cafe_payResult";
	}
	
	// 취소
	@RequestMapping(value = "/cafe/cafe_payCancel")
	public String payCancel(Model model) {
		model.addAttribute("payResult", "cancel");
		return "cafe/cafe_payResult";
	}

}
