<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<c:if test="${10>0}">
		참일 때 보입니다.
	</c:if>
	
	이름 : ${members[2].name}
	<c:if test="${members[2].name eq null}">
		입력된 정보가 없습니다.
	</c:if>
	
	<c:if test="${members[0].name == 'COOL'}" var="result" scope="request"/>
	<br> members[0].name == 'COOL' : 
	${result}
	
</body>
</html>


















