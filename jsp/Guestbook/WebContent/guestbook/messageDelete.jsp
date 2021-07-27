<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터를 받고 - Service - Dao - Service - JSP
	String mid = request.getParameter("mid");
	String password = request.getParameter("password");


%>
<jsp:forward page="delete_view.jsp"/>