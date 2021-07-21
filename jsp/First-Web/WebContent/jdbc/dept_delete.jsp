<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전달하는 deptno 받음
	String deptno = request.getParameter("deptno");

	// DB 데이터 삭제
	int resultCnt = 0;
	// 2. DB 저장 : insert
	// 드라이버 로드 : 서블릿 클래스 Loader 에서 로드
	//Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
/* 	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw); */
	conn = ConnectionProvider.getConnection();
	
	String sqlDel = "delete from dept where deptno=?";
	pstmt = conn.prepareStatement(sqlDel);
	
	pstmt.setInt(1, Integer.parseInt(deptno));
	
	resultCnt = pstmt.executeUpdate();
	
	if(resultCnt > 0){ 
		%>
			<script>
				alert('삭제되었습니다.');
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