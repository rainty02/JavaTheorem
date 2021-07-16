<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	
	String userId = request.getParameter("userid");
	String userPw = request.getParameter("userpw");
	String userName = request.getParameter("username");
	String birthYear = request.getParameter("birthyear");
	String birthMonth = request.getParameter("birthmonth");
	String birthday = request.getParameter("birthday");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String countryNum = request.getParameter("countrynum");
	String telNum = request.getParameter("telnum");

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

	<table border ="1">
		<tr>
			<td>아이디</td>
			<td><%= userId %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= userPw %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= userName %></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><%= birthYear +"."+ birthMonth +"."+ birthday %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%= gender %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%= email %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%= countryNum + telNum %></td>
		</tr>
	</table>
	

</body>
</html>