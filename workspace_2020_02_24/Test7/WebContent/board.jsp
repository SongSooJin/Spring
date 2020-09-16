<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	${list }
	<br>
	<br>
	<hr>
	<br>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
	
			<c:forEach items="${list }" var="row">
				<tr>
					<td>${row.board_no }</td>
					<td>${row.board_title }</td>
					<td>${row.login_name }</td>
					<td>${row.board_date }</td>
					<td>${row.board_count }</td>
				</tr>	 
			</c:forEach>
			
	</table>
</body>
</html>