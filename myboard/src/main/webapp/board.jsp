<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="myboard.getMessageDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%
	if(session.getAttribute("username") == null) {
		response.sendRedirect("/myboard/index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board page</title>
</head>
<body>
<h1><%= session.getAttribute("username") %>님 환영합니다!</h1> <br>
	<form action="/myboard/Logout" method="post">
		<input type="submit" value="로그아웃"/>
	</form>
	<br/><br/>
	<a href="/myboard/writeMessage.jsp">글쓰기</a>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td width="150">제목</td>
			<td width="100">글쓴이</td>
			<td>작성일</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<% getMessageDAO getMessagedao = new getMessageDAO(); %>
		<% List<Map<Integer, String>> messagelist = getMessagedao.getMessageList(); %>
		<% for(int i = 0; i < messagelist.size(); i++) { %>
			<% Map<Integer, String> map = messagelist.get(i) ;%>
		<tr>
			<td><%= map.get(1) %></td>
			<td><a href="view.jsp?id=<%= map.get(1) %>"><%= map.get(2) %></a></td>
			<td><%= map.get(3) %></td>
			<td><%= map.get(4) %></td>
			<td>
			<form method="get" action="update.jsp">
				<input type="hidden" name="id" value="<%= map.get(1) %>">
				<input type="submit" value="수정"/>
			</form>
			</td>
			<td>
				<form method="post" action="Delete">
					<input type="hidden" name="id" value="<%= map.get(1) %>">
					<input type="submit" value="삭제"/>
				</form>
			</td>
		</tr>
		<% } %>
	</table>
	
</body>
</html>