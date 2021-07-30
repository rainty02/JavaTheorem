package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdCheckCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		String memberId = request.getParameter("mid");
		request.setAttribute("result", IdCheckService.getInstance().idCheck(memberId));
		
		return "/WEB-INF/views/idcheck.jsp";
	}

}
