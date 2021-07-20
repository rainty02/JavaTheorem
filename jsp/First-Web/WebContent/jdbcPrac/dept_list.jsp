<%@page import="java.util.ArrayList"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");

	// DB 연결
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// jdbcurl, user, pw
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "bit";
	
	// 커넥션 객체
	con = DriverManager.getConnection(jdbcUrl, user, pw);
	
	// sql 입력
	String sqlSel = "select * from dept";
	pstmt = con.prepareStatement(sqlSel);
	
	// 값 반환
	rs = pstmt.executeQuery();
	List<Dept> list = new ArrayList<Dept>();	
	while(rs.next()){
		list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
	}
	
	// 속성 저장
	request.setAttribute("result", list);
%>
<jsp:forward page="list_view.jsp"/>