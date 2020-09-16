<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>
</head>
<body>
	<h1>타이틀</h1>
	<hr>
	jsp = html + java / html 속에 자바가 들어있습니다. <br>
	jsp = java server page <br>
	
	<%
		// 자바가 열립니다. 열릴때는 % , 값 찍을때는 %=
		int a= 10;
		// 자바부터 계산 => html출력 
		/*
		jsp    - 소규모 (커뮤니티)
		spring - 대규모 (은행, 정부, 대기업)
		*/
	%>
	<h1><%=a %></h1>
	
	id/ pw ---> main.jsp <br>
	<form action="main.jsp" method="get">
		<input type="text" name="id">
		<input type="password" name="pw">
		<button type="submit">로그인</button>
	</form>
	
	
	
</body>
</html>