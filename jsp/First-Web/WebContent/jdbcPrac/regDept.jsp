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
	request.setCharacterEncoding("utf-8");
	String deptno = (String) request.getAttribute("deptno");
	String dname = (String) request.getAttribute("dname");
	String loc = (String) request.getAttribute("loc");

	int resultCnt = 0;
	
	// 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// DB 연결
	Connection con = null;
	PreparedStatement pstmt = null;
	
	// jdbcurl, user, pw
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "bit";
	
	// 커넥션 객체
	con = DriverManager.getConnection(jdbcUrl, user, pw);
	
	// sql 입력
	String sqlIns = "insert into dept values(?,?,?)";
	pstmt = con.prepareStatement(sqlIns);
	pstmt.setInt(1, Integer.parseInt(deptno));
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	
	resultCnt = pstmt.executeUpdate();

	if (resultCnt > 0) {
	%>
	<script>
		alert('등록되었습니다.');
		location.href = 'dept_list.jsp';
	</script>
	<%
		} else {
	%>
	<script>
		alert('오류 발생으로 등록되지 않았습니다.\n입력페이지로 다시 이동합니다.');
		//location.href = 'dept_regForm.jsp';
		window.history.go(-1);
	</script>
	<%
		}
	%>

