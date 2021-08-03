package com.bitcamp.firstSpring;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	// 사용자 요청 URI와 실행 메소드 정의 : view와 결과 페이지
	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		ModelAndView mav = new ModelAndView();
		
		// view 설정
		mav.setViewName("hello"); // WEB-INF/views.hello.jsp
		
		// 결과 데이터 model을 저장 (view 페이지에 전달)
		mav.addObject("greeting", greeting());
		
		return mav;
	}

	private Object greeting() {
		String str = "안녕하세요.";
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour >= 6 && hour <= 10) {
			str = "아침입니다.";
		} if(hour >= 12 && hour <= 15) {
			str = "점심입니다.";
		}if(hour >= 18 && hour <= 22) {
			str = "저녁입니다.";
		}
		return str;
	}
	
}








