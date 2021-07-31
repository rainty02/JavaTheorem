<%@page import="service.MemberDelCommandImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--     
<%
	MemberDelCommandImpl md = new MemberDelCommandImpl();

	int idx =  Integer.parseInt(request.getParameter("idx"));
	String deleteResult = md.getPage(request, response);

%>
--%>
<c:if test="${deleteResult == 1}">
	<script>
		alert('삭제되었습니다.');
		location.href = 'list_view.do';
	</script>
</c:if>
<c:if test="${deleteResult == 0}">
	<script>
		alert('오류 발생으로 삭제되지 않았습니다.\n다시 시도해주세요.');
		location.href = 'list_view.do';
		//window.history.go(-1);
	</script>
</c:if>