<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 입력데이터의 한글처리
	request.setCharacterEncoding("utf-8");
	
	// 1. 사용자가 입력한 데이터를 받아
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	int resultCnt = 0;
	// 2. DB 저장 : insert
	// 드라이버 로드
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	// 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		
	/* String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw); */
	conn = ConnectionProvider.getConnection();
	
	// PreparedStatement
	String sqlInsert = "insert into dept values (?,?,?)";
	pstmt = conn.prepareStatement(sqlInsert);
	
	pstmt.setInt(1, Integer.parseInt(deptno));
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	
	// insert -> int
	resultCnt = pstmt.executeUpdate();
	/* out.println(resultCnt); */
		
	// 3. dept_list.jsp 이동
	// 바로 이동
	//response.sendRedirect("dept_list.jsp");
	
	} catch (Exception e){
		
	}
	
	// 결과값에 따라 분기
	if(resultCnt > 0){
		%>
		<script>
			alert('등록되었습니다.');
			location.href = 'dept_list.jsp';
		</script>
		<%
	} else {
		%>
		<script>
			alert('오류가 발생하여 등록되지 않았습니다.\n입력 페이지로 이동합니다.');
			// 새로운 페이지
			//location.href = 'dept_regForm.jsp';
			// -1 이전 페이지로 돌아감
			window.history.go(-1);
		</script>
		<%
	}
%>












