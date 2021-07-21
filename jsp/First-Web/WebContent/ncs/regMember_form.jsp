<%@page import="ncs.Connetor"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="ncs.MemberDao"%>
<%@page import="ncs.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	MemberDao dao = MemberDao.getInstance();
	Connection con = null;
	List<Member> list = null;
	
	try{
		con = Connetor.getConnector();
		list = new ArrayList<Member>();
		list = dao.selectMem(con);		
	} catch (SQLException e) {
		e.printStackTrace();
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	
	td{
		text-align: center;
	}
	#list{
		width: 600px;
		border-collapse: collapse; 
	}
	div{
		border: 1px solid black;
		padding: 10px;
		width: 600px;
	}
	
</style>
<script>
</script>
</head>
<body>
<div>
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
	<hr>
	<h1>회원 리스트</h1>
	<hr>
	<table id="list" border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일시</th>
		</tr>
		
		<%
			if(list.size()==0) {
			%>
			<tr>
				<td colspan="4">등록된 회원이 없습니다.</td>
			</tr>
			<%
			} else {
				for(int i=0; i<list.size(); i++){
				%>
				<tr>
					<td><%= list.get(i).getId() %></td>
					<td><%= list.get(i).getPw() %></td>
					<td><%= list.get(i).getName() %></td>
					<td><%= list.get(i).getRegDate() %></td>
				</tr>					
				<%
				}
			}
		%>		
	</table>
</div>
</body>
</html>