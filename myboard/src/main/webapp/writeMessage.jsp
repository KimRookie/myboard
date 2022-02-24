<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Message</title>
</head>
<body>
	<form action="/myboard/WriteMessage" method="post" name="write_form">
		제목	: <input type="text" name="title"> <br/><br/>
		내용	: <textarea name="contents" cols="40" rows="5"></textarea> <br/>
		글쓴이: <input type="text" name="writer"
				value="<%= session.getAttribute("userid") %>"
				readonly="readonly"> <br/>
				<input type="submit" value="쓰기">
	</form>
</body>
</html>