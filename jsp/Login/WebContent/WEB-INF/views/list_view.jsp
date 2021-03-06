<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td {
		text-align: center;
		padding: 5px 10px;
	}
	
	button {
		margin: 5px 0;
	}
</style>
<script>
</script>
</head>
<body>
	
	<h1>부서 리스트</h1>
	<hr>
	
	<!-- <button onclick="location.href='dept_regForm.jsp';">부서정보 등록</button> -->

	<table border=1>
		<tr>
			<th>idx</th>	
			<th>이미지</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>
		
	
		<c:if test="${result != null && !empty result}">
			<c:forEach items="${result}" var="member">
				<tr>
					<td>${member.idx}</td>
					<td>
						<img src="<c:url value="/upload/${member.memberphoto}"/>" height="30">
					</td>
					<td>${member.memberid}</td>
					<td>${member.password}</td>
					<td>${member.membername}</td>
					<td>${member.regdate}</td>
					<td>
						<a href="editmember.do?midx=${member.idx}">수정</a>
						<a href="javascript:delMember('${member.idx}')">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		
	</table>
	<script>
		
		function delMember(idx){	
			
			if(confirm('정말 삭제하시겠습니까?')){
			//	location.href = '/WEB-INF/views/del_view.jsp?idx=' +idx;
			};
		}
	
	</script>

	<%--
		out.println(list);
	--%>

</body>
</html>