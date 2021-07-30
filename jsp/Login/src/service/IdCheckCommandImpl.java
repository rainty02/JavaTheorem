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
			
			//result = cnt > 0 ? "N" : "Y";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("idChk", cnt > 0 ? "N" : "Y");
		
		return "/WEB-INF/views/idcheck.jsp";
	}

}
