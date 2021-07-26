<%@page import="domain.LoginInfo"%>
<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${loginInfo != null}">

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}"> 
<style>
</style>
<script>
</script>
</head>
<body>


<c:import url="${head}"/>
<c:import url="${nav}"/> 


	<div class="contents">
	
		<h2>My Page</h2>
		<hr>
		<h3>
			${loginInfo}
		</h3>	
	</div>

</body>
</html>
</c:if>