<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--
	id : 자바빈 객체에 접근할 때 사용하는 이름 
	class : 패키지를 포함한 클래스 이름
	scope : 영역 지정. page(디폴트), request, session, application 
-->
<jsp:useBean id="member" class="member.Member" scope="request" />

<!-- 
	1. request 속성에 member라는 속성을 찾는다
	2. member가 member.Member 타입의 객체인지 확인
	3.1 있다면 -> request.getAttribute("member")
	3.2 없다면 -> new member.Member() -> request.setAttribute("member", new member.Member());

	Member member = (Member) request.getAttribute("member");
	if(member == null){
		member = new Member();
		request.setAttribute("member", member);
	} else {
		request.getAttribute("member");
	}
-->  

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

		<%= member %>
		<br>
		<%= member.getName() %>
	
</body>
</html>