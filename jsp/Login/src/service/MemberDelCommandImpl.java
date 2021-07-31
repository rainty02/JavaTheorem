package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import util.ConnectionProvider;

public class MemberDelCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		int result = 0;
		Connection conn = null;
		MemberDao dao = null;
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			result = dao.deleteMember(conn, idx);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("deleteResult", result);
		
		return "/WEB-INF/views/del_view.jsp";
	}

}
