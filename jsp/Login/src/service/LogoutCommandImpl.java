package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommandImpl implements Command {
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "/WEB-INF/views/logout.jsp";
	}

}
