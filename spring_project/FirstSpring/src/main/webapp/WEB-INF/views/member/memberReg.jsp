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

	<h1>가입 정보</h1>
	<hr>				<!-- /web/member/mypage.jsp  -->
	 
			<table>
				<tr>
					<td>아이디</td>
					<td>${reqmemberid}, ${memberid}, ${regReq.memberid}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${reqpassword}, ${password}, ${regReq.password}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${reqmembername}, ${membername}, ${regReq.membername}</td>
				</tr>
				<tr>
					<td>사진</td>
					<td>${reqphoto}, ${photo}, ${regReq.photo}</td>
				</tr>

			</table>
		

</body>
</html>