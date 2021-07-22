<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Cookie[] cookies = request.getCookies();
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

	<%
		if(cookies!=null && cookies.length>0) {
			for(int i=0; i<cookies.length; i++) {
				// getName() : 쿠키의 이름 반환
				String name = cookies[i].getName();
				// getValue() : 쿠키의 값 반환
				String value = cookies[i].getValue();
				
				out.println("<h1>"+name+"="+value+"</h1>");
			}
		}
	%>

</body>
</html>















