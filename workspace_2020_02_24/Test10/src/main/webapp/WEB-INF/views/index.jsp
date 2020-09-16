<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link href="./css/index.css" rel="stylesheet">
</head>
<body>

	<%@include file="menu.jsp" %>
	
	<c:if test="${error ne null }">
		<script type="text/javascript">
			var error = '${error}';
			alert("다음과 같은 에러가 발생했습니다. \n " + error);
		</script>
	</c:if>
	
	<div id="loginbox">
		<img alt="로그인 이미지" src="./img/login.png">
		
		<form action="login" method="post">
			<input type="text" name="id">
			<input type="password" name="pw">
			<button type="submit">LOGIN</button>
		</form>
		
		<button type="submit" onclick="location.href='join'">회원가입</button>
	</div>
	
	
	<div id="errorbox">
	<c:if test="${error ne null }">
		<script type="text/javascript">
			var error = '${error}';
			alert("올바른 아이디와 패스워드를 입력하세요." + error);
		</script>
		<h3 style="color:red;">올바른 아이디와 패스워드를 입력하세요.</h3>
	</c:if>
	</div>
</body>
</html>