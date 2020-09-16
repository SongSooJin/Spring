<%@page import="com.soo.apple.Apple"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>apple</title>
</head>
<body>

	<h1>apple</h1>
	<%
	Apple apple = new Apple();
	 String name = apple.name;
	%>
	사과 이름은 : <%=name %>
</body>
</html>