package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import util.ConnectionProvider;
import util.JdbcUtil;

public class MemberListCommandImpl implements Command {

	public void memlist(HttpServletRequest request) {
		
		// 객체 생성, 초기화
		Connection conn = null;
		MemberDao dao = MemberDao.getInstance();
		
		try {
			// jdbcUrl 
			conn = ConnectionProvider.getConnection();
			
			// 결과 데이터 request 의 속성에 저장 -> 데이터 공유(전달)
			request.setAttribute("result", dao.selectList(conn));
			
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(conn);
		}
	}	
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		memlist(request);
		return "/WEB-INF/views/list_view.jsp";
	}
}
