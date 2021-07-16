<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<%-- WEB-INF에 작성시 include로 가져올 수는 있지만 클라이언트에게는 노출되지 않음 --%>
	<%--@ include file="WEB-INF/header.jsp" --%>
	<hr>
	<%@ include file="include/nav.jsp" %>
	<div id="warp">
		<%@ include file="include/news.jsp" %>
		<%@ include file="include/shopping.jsp" %>
	</div>			
</body>
</html>