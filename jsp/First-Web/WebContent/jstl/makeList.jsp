<%@page import="java.util.ArrayList"%>
<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<Member> members = new ArrayList<Member>();
	members.add(new Member("coo000", "1110", "COOL"));
	members.add(new Member("cool00", "1111", "COOL"));
	members.add(new Member("coo200", "1112", null));
	members.add(new Member("coo300", "1113", "COOL"));
	members.add(new Member("coo400", "1114", "COOL"));
	members.add(new Member("coo500", "1115", null));
	members.add(new Member("coo600", "1116", null));
	members.add(new Member("coo700", "1117", "COOL"));
	members.add(new Member("coo800", "1118", null));
	members.add(new Member("coo900", "1119", "COOL"));
	
	session.setAttribute("members", members);
	
%>