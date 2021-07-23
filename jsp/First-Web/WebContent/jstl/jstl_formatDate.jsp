<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	<% request.setAttribute("now", new java.util.Date()); %>
	${now} <br>

	<fmt:timeZone value="HongKong">
		
	<h3>날짜</h3>
	<fmt:formatDate value="${now}"/> <br> <!-- yyyy.mm.dd -->
	<fmt:formatDate value="${now}" type="date"/> <br> <!-- yyyy.mm.dd -->
	<fmt:formatDate value="${now}" type="date" dateStyle="full"/> <br> <!-- yyyy년 mm월 dd일 요일 -->
	<fmt:formatDate value="${now}" type="date" dateStyle="short"/> <br> <!-- yy.mm.dd -->
	
	<h3>시간</h3>
	<fmt:formatDate value="${now}" type="time"/> <br> <!-- 오전오후 hh:mm:ss -->
	<fmt:formatDate value="${now}" type="time" timeStyle="full"/> <br> <!-- am/pm hh시 mm분 ss초 KST -->
	<fmt:formatDate value="${now}" type="time" timeStyle="short"/> <br> <!-- am/pm hh:mm -->
	
	<h3>both</h3>
	<fmt:formatDate value="${now}" type="both"/> <br> <!-- yy.mm.dd am/pm hh:mm:ss -->
	<fmt:formatDate value="${now}" type="both"/> <br> <!-- yy.mm.dd am/pm hh:mm:ss -->
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/> <br>
	
	<h3>pattern</h3>
	<fmt:formatDate value="${now}" pattern="z a h:mm"/> <br> <!-- KST am/pm h:mm -->
	<fmt:formatDate value="${now}" pattern="hh:mm:ss"/> <br>
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd h:mm"/> <br>
	<fmt:formatDate value="${now}" pattern="yyyy.MM.dd. a h:mm" timeZone="HongKong"/> <br>
	
	</fmt:timeZone>
	
</body>
</html>






















