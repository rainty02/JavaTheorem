package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getSession().getAttribute("loginInfo") != null) {
			return "/WEB-INF/views/mypage.jsp";
		} else {
			return "/index.jsp";
		}
	}
}
