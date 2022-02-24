<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
	<h1>등록</h1>
	<form action="/myboard/RegisterUser" method="post" name="Register_form">
		이메일 주소: <input type="text" name="email"/> <br/>
		Password: <input type="password" name="pass"/> <br/>
		이름: <input type="text" name="name"/> <br/>
		<input type="submit" value="등록"/> <br/>
	</form>
</body>
</html>