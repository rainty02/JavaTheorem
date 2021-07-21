<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 2. DB 연결
	Connection conn = null;
	DeptDao dao = DeptDao.getInstance();
		
	try {
		conn = ConnectionProvider.getConnection();
	
		// 6. 결과 데이터 request의 속성에 저장 : 데이터 공유(전달)
		request.setAttribute("result", dao.getDeptList(conn));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn);
	}

	
%>

<jsp:forward page="list_view.jsp"/>	<!-- view의 역할 -->