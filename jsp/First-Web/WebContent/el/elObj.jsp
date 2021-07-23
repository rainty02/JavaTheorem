<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setAttribute("name", "son");
	session.setAttribute("name", "lee");
	application.setAttribute("name", "pack");
	
	Member member = new Member();
	member.setId("cool");
	member.setName("COOL");
	member.setPw("1234");
	session.setAttribute("member", member);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>

	표현식 : <span><%= request.getAttribute("name") %></span> <br>
	표현언어1 : <span>${requestScope.name}</span> <br><br>
	
	내장객체의 표현식을 생략했을 때<br>
	1. pageScope의 속성
	2. requestScope의 속성
	3. sessionScope의 속성
	4. application의 속성
	을 순서대로 찾아 우선순위에 있는 속성을 반환함 <br><br>
	
	표현언어2 : <span>${name}</span> <br>
	표현언어3 : <span>${sessionScope.name}</span> <br>
	표현언어4 : <span>${applicationScope.name}</span> <br>
	
	<hr>
	param.code : <%= request.getParameter("code") %> <br>
	param.code : ${param.code}
	
	<hr>
	pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %> <br>
	pageContext : ${pageContext.request.requestURL} <br>
				  ${pageContext.request.requestURI} <br>
				  ${pageContext.request.contextPath} <br>
	<%= request.getContextPath() %>
	
	<hr>
	${true} / ${false} / ${100} / ${'EL'} / ${null}
	
	<hr>
	<!-- member.getId() -->
	Member 객체 : ${sessionScope.member} / ${member.id} <br>
	<%= session.getAttribute("member") %> / <%= ((Member)session.getAttribute("member")).getId() %>
	

</body>
</html>













