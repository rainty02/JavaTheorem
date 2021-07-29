package service;

import javax.servlet.http.HttpServletRequest;

public class GreetingService {

	// 사용자 요청 처리 후 view의 경로 반환
	// 결과 데이터를 request 속성에 저장, 전달
	public String greeting(HttpServletRequest request) {
		
		// 핵심처리
		request.setAttribute("result", "안녕하세요");
		
		return "/WEB-INF/views/greeting.jsp";
	}
	
}
