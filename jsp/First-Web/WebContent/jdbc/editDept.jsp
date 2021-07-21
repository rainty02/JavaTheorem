<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//입력데이터의 한글처리
	request.setCharacterEncoding("utf-8");
	
	// 1. 사용자가 입력한 데이터를 받아
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	int resultCnt = 0;
	// 2. DB 저장 : insert
	// 드라이버 로드
	//Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
/* 	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw); */
	conn = ConnectionProvider.getConnection();
	
	String sqlUpdate = "update dept set dname=?, loc=? where deptno=?";
	pstmt = conn.prepareStatement(sqlUpdate);
	
	pstmt.setString(1, dname);
	pstmt.setString(2, loc);
	pstmt.setInt(3, Integer.parseInt(deptno));
	
	resultCnt = pstmt.executeUpdate();
	
	if(resultCnt > 0){ 
	%>
		<script>
			alert('수정되었습니다.');
			location.href = 'dept_list.jsp';
		</script>		
		<%
	} else {
		%>
			alert('해당 데이터를 찾지 못했습니다.');
			location.href = 'dept_list.jsp';
		<%
	}
%>














