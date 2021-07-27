<%@page import="guest.service.WirteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="messageRequest" class="guest.domain.MessageRequest" />
<jsp:setProperty property="*" name="messageRequest"/>

<%
	int result = WirteMessageService.getInstance().wirteMessage(messageRequest);

	request.setAttribute("result", result);

%>
<jsp:forward page="write_view.jsp"/>