<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<c:url value="/css/default.css" var="css" scope="application"/>
<link rel="stylesheet" href="${css}"> 

<style>
</style>
<script>
</script>
</head>
<body>

<c:url value="WEB-INF/frame/header.jsp" var="head" scope="application"/>
<c:url value="WEB-INF/frame/nav.jsp" var="nav" scope="application"/>

<c:import url="${head}"/>
<c:import url="${nav}"/> 

	<div class="contents">	
		<h1>Index</h1>	
	</div>

</body>
</html>