<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 회원가입</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

</head>
<body>

<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>


	
	<div id="content">
		<h1>Content : 회원가입</h1>
		
		<h2>Register</h2>

		<form method="post" enctype="multipart/form-data"> 
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="memberid" id="memberid">
						<%-- <span id="msg" class="display_none"></span>
						<img id="Loadingimg" class="display_none" alt="Loading" src="<c:url value="/image/loading.gif"/>"> --%>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="membername"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit">
						<input type="reset" >
					</td>
				</tr>
			</table>
		</form>
		
		
		
		
	</div>

</body>
</html>