<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 핵심처리
	String[] list = {"son", "lee", "pack"};

	// view 페이지에 선수리스트(결과) 공유
	request.setAttribute("players", list);
%>
<jsp:forward page="list_view.jsp"/>