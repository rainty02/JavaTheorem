<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String chkPw = request.getParameter("chkPw");
	String name = request.getParameter("name");
	
	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2. DB 처리
	Connection con = null;
	PreparedStatement pstmt = null;
	int resultCnt = 0;
	
	String sql = "insert member (id, pw, name) values (id, pw, name)";
	pstmt = con.prepareStatement(sql);
	
	resultCnt = pstmt.executeUpdate();
	
	if(resultCnt>0){
	%>
		alert('등록되었습니다.');
	<%
	} else {
	%>
		alert('오류가 발생했습니다.');
	<%
	}	
%>
