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

	<c:set var="number" value="100000000"/>
	${number}
	<br>

	<fmt:formatNumber value="1000000"/> <br> <!-- 1,000,000 -->
	<fmt:formatNumber value="1000000" groupingUsed="false"/> <br> <!-- 1000000 -->
	
	<fmt:formatNumber value="${number}"/> <br> <!-- 100,000,000  -->
	숫자 : <fmt:formatNumber value="${number}" type="number"/> <br> <!-- 100,000,000  -->
	퍼센트 : <fmt:formatNumber value="${number/4000000000}" type="percent"/> <br> <!-- 2% -->
	통화 : <fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/> <br> <!-- \ $100,000,000  -->
	
	패턴 : <fmt:formatNumber value="${number*10000}" pattern="000,000.00"/> <br> <!-- 100,000,000.00  -->
	
</body>
</html>