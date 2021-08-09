<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:if test="${insertChk == 0}">
<script>
	alert("오류가 발생하여 이전 페이지 돌아갑니다.");
	history.go(-1);
</script>
</c:if>
<c:if test="${insertChk == 1}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 회원가입 완료</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

</head>
<body>

<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	
	<div id="content">
		<h1>Content : 회원가입 완료</h1>
		
		<h2>회원가입이 완료되었습니다.</h2>
		<hr>
		<h2>${memberFile}</h2>		
	</div>

</body>
</html>
</c:if>