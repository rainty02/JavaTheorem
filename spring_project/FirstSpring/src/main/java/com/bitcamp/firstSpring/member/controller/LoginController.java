package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.LoginInfo;
import com.bitcamp.firstSpring.member.domain.LoginRequest;

@Controller
@RequestMapping("/member/login") // 기본 경로 설정 후 메소드에서도 경로를 지정해주면 기본경로+경로가 되므로 주의
public class LoginController {

	// RequestMethod 방식에 따라 실행하는 메소드가 다름
	
	//@RequestMapping("/member/loginform")
	//@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(
		@RequestParam(value = "page", defaultValue = "1"/*required = false*/) int page				
			) {
		
		//System.out.println("page : " + (page+1));
		System.out.println(page);
		return "member/loginForm"; 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
						@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						HttpServletRequest request,
						@ModelAttribute("loginReq") LoginRequest loginRequst,
						Model model
						) {
		
		// 사용자의 파라미터 데이터를 받는 방법
		// 1. HttpServletRequest
		// 2. @RequestParam("param name")
		// 3. 커맨드 객체(beans)
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		// 반환 타입이 String 일때 view에 전달한 데이터 저장 : Model
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		System.out.println("uid : " + uid);
		System.out.println("upw : " + upw);
		
		model.addAttribute("uid", uid);
		model.addAttribute("upw", upw);
		
		System.out.println(loginRequst);
		
		// 세션의 속성에 loginInfo 등록
		request.getSession(false).setAttribute("loginInfo", new LoginInfo());
		
		return "member/login"; //	/WEB-INF/views/member/login.jsp
	}
}
