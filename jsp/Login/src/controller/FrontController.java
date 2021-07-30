package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. 사용자 요청 분석
		String commandUri = request.getRequestURI();
		// 입력된 Uri 중 컨텍스트 경로가 0번째 위치하면
		if(commandUri.indexOf(request.getContextPath()) == 0 ) {
			// 입력한 Uri 경로 중 컨텍스트 경로의 길이만큼 지운다 : /mvc/guest/list.do - > /mvc을 지움
			commandUri = commandUri.substring(request.getContextPath().length());
		}
		
		// 결과 데이터
		String resultObj = null;
		// 결과 페이지
		String viewPage = null;
		
		// 2. 요청 처리
		if(commandUri.equals("/idcheck.do")) {
			// 처리할 서비스 메소드 실행
			resultObj = "아이디를 체크합니다";
			viewPage = "/";
		}
		
	}
	
	

}
