<%@page import="myboard.getMessageDAO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board View</title>
</head>
<body>
	<% Integer id = Integer.parseInt(request.getParameter("id")); %>
	글번호: <%= id %> <br/>
	<% getMessageDAO getmessagedao = new getMessageDAO(); %>
	<% Map<Integer, String> list = getmessagedao.getMessage(id); %>
	제목: <%= list.get(2) %> <br/>
	내용: <%= list.get(3) %> <br/>
	글쓴이: <%= list.get(4) %> <br/>
	작성일: <%= list.get(5) %>
</body>
</body>
</html>