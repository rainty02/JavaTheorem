<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 캐릭터셋
	request.setCharacterEncoding("utf-8");

	// regMember에서 전달 받은 값
	String id = request.getParameter("id");
	String password = request.getParameter("pw");
	String name = request.getParameter("name");
		
	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "bit";
	
	// 2. DB 처리
	Connection con = null;
	PreparedStatement pstmt = null;
	int resultCnt = 0;
	
	con = DriverManager.getConnection(jdbcUrl, user, pw);
	
	String sql = "insert into member (ID, PW, NAME) values (?, ?, ?)";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, password);
	pstmt.setString(3, name);
	
	resultCnt = pstmt.executeUpdate();
	
	if(resultCnt>0){
	%>
	<script>
		alert('등록되었습니다.');
	</script>
	<%
	} else {
	%>
	<script>
		alert('오류가 발생했습니다.');
	</script>
	<%
	}	
%>
