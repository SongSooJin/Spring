<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿에서 값 받아오기</title>
</head>
<body>

	<%=request.getAttribute("ini") %> <br>
	el tag : ${ini} <br> <!-- jsp에서 지원하는 기능 -->
	맵은 : ${map } <br>
	
	<c:forEach begin="0" end="10" var="start" step="2">
		${start}
	</c:forEach> 
	
	${list }
	
	<h1>list 뽑기</h1>
	
	<c:forEach items="${list }" var="i">
		${i }<br>
	</c:forEach>


</body>
</html>