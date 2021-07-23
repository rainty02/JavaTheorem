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

	${members} <br>
	${members[0]} <br>
	${members[2]} / ${members[2].name}
	
	<c:out value="${members[0].name}"/>

	/

	<c:out value="${members[2].name}" escapeXml="false">
		<span style="color:red;">입력된 정보가 없습니다.</span>
	</c:out>

	/
	<!-- excapeXml 값에 따라 텍스르 or html로 출력 -->
	<c:out value="${members[2].name}" escapeXml="true">
		<span style="color:red;">입력된 정보가 없습니다.</span>
	</c:out>

</body>
</html>



















