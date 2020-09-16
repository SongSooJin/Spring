<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link href="./css/index.css" rel="stylesheet">
</head>
<body>

	<%@include file="menu.jsp" %>
	
	<div id="loginbox">
		<img alt="로그인 이미지" src="./img/login.png">
		
		<form action="login" method="post">
			<input type="text" name="id">
			<input type="password" name="pw">
			<button type="submit">LOGIN</button>
		</form>
	</div>
</body>
</html>