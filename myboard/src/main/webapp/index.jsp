<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<div class = "container">
	<div class="wrapper">
		<form action="/myboard/LoginUser" method="post" name="Login_Form" class="form-signin" style="background-color: rgba(0,0,0,0.0)">       
		    <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
			  <hr class="colorgraph"><br>
			  
			  <input type="text" class="form-control" name="email" placeholder="Username" required="" autofocus="" />
			  <input type="password" class="form-control" name="pass" placeholder="Password" required=""/>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>
			  <a class="btn btn-lg btn-primary btn-block" href="/myboard/registerUser.jsp">회원가입</a>
		</form>	
		</div>
	</div>
</body>
</html>