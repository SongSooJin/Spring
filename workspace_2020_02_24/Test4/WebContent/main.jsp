<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 자바코드
	// index.jsp에서 보내온 name = id, name = pw 잡기
	String id = request.getParameter("id"); // id로 들어오는 값
	String pw = request.getParameter("pw"); // pw로 들어오는 값
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>main.jsp</h1>
	
	입력하신 id는 <%=id %> 입니다. <br>
	암호는 <%=pw %> 입니다.
	
	<a href="./main2.jsp">클릭하세요</a>
</body>
</html>