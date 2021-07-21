<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<h1>회원 관리 프로그램</h1>
	<hr>
	<form action="regMember.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
			<tr>
				<td><input type="text" name="id"></td>
				<td><input type="password" name="pw"></td>
				<td><input type="text" name="name"></td>
				<td><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>

</body>
</html>