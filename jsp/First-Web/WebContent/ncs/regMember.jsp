<%@page import="java.sql.SQLException"%>
<%@page import="ncs.Connetor"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="ncs.MemberDao"%>
<%@page import="ncs.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 캐릭터셋
	request.setCharacterEncoding("utf-8");

	// regMember에서 전달 받은 값
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	// Dao 
	MemberDao dao = MemberDao.getInstance();
	int resultCnt = 0;

	// DB 연결
	Connection con = null;	
	
	try {
		con = Connetor.getConnector();		
		// 결과값 반환
		resultCnt = dao.insertMem(con, new Member(id, pw, name));
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	if(resultCnt>0){
	%>
	<script>
		alert('등록되었습니다.');
		location.href="regMember_form.jsp";
	</script>
	<%
	} else {
	%>
	<script>
		alert('오류가 발생했습니다.\n다시 시도해주세요.');
		location.href="regMember_form.jsp";
	</script>
	<%
	}	
%>
