<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/regForm.jsp" var ="regForm"/>
<c:url value="/loginForm.jsp" var ="loginForm"/>
<c:url value="/logout.jsp" var ="logout"/>
<c:url value="/member_list.jsp" var ="member_list"/>
<c:url value="/mypage.jsp" var ="mypage"/>

	<nav>
		<ul>
			<c:choose>
				<c:when test="${loginInfo == null}">
					<li><a href="${regForm}">회원가입</a></li>
					<li><a href="${loginForm}">로그인</a></li>
				</c:when>
				<c:when test="${loginInfo != null}">
					<li><a href="${logout}">로그아웃</a></li>
					<li><a href="${member_list}">회원리스트</a></li>
				</c:when>
			</c:choose>
				<li><a href="${mypage}">Mypage</a></li>
		</ul>
	</nav>