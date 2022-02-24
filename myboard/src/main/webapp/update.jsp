<%@page import="myboard.getMessageDAO"%>
<%@page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Update</title>
</head>
<body>
	<% int id = Integer.parseInt(request.getParameter("id")); %>
	<% getMessageDAO getmessagedao = new getMessageDAO(); %>
	<% Map<Integer, String> list = getmessagedao.getMessage(id); %>
	<form action="/myboard/Update" method="post" name="update_form">
		<input type="hidden" name="id" value="<%= list.get(1) %>"/>
		제목	: <input type="text" name="title" value="<%= list.get(2) %>"> <br/>
		내용	: <textarea rows="5" cols="40" name="contents"><%= list.get(3) %></textarea> <br/>
		글쓴이: <%= list.get(4) %><br/>
		<input type="submit" value="수정">
	</form> 
</body>
</html>