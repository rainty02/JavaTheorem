<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 쿠키의 삭제 : 쿠키 유효시간을 0으로 설정 (초단위)
	Cookie c = new Cookie("cname","");
	//c.setMaxAge(60*60*24*7);
	// 쿠키 유효시간 0 : 삭제
	c.setMaxAge(0);
	response.addCookie(c);
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

	<h1>쿠키가 삭제되었습니다.</h1>
	<a href="viewCookie.jsp">쿠키 정보보기</a>

</body>
</html>