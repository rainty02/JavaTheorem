package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import util.ConnectionProvider;

public class IdCheckCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		
		int cnt = 0;
		
		Connection conn = null;
		MemberDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			String memberId = request.getParameter("mid");
			cnt = dao.selectById(conn, memberId);

			
			String result = cnt > 0 ? "N" : "Y";
			System.out.println(memberId +" : "+ cnt +" : "+ result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if (cnt > 0) {
//			request.setAttribute("result", "N");
//			System.out.println(request.getAttribute("result"));
//		} else {
//			request.setAttribute("result", "Y");
//			System.out.println(request.getAttribute("result"));
//		}
		request.setAttribute("result", cnt > 0 ? "N" : "Y");
		
		return "/WEB-INF/views/regForm.jsp";
	}

}
