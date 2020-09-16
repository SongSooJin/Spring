<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="./css/board.css" rel="stylesheet">

</head>
<body>
<div id="container">
		<%@include file="menu.jsp" %>
		<div id="main">
			<!-- 본문 -->
		</div>
	</div>
	
	
	
	
	<hr>
	${list }
	<hr>
     <!-- ne(!=) -->
	<c:if test="${sessionScope.name ne null }">	
		${sessionScope.name }님 반갑습니다. 
		<button onclick="location.href='logout'"> 로그아웃</button>
	</c:if>
	
	<!-- eq(==) -->
	<c:if test="${sessionScope.name eq null }">
		<a href="./">로그인</a>하세요.
	</c:if>
	<hr>
	
	<c:if test="${list eq null }">값이 없습니다.</c:if>
<%--  길이	${fn:length(list) } --%>
	
	<c:choose>
		<c:when test="${fn:length(list) > 0}">
		<!-- 값 있음 -->
		
		<table class="table table-hover table-dark">
			<tr>
				<th style="width: 10%">번호</th>
				<th style="width: 40%">제목</th>
				<th style="width: 10%">이름</th>
				<th style="width: 30%">날짜</th>
				<th style="width: 10%">조회수</th>
				
			</tr>
				<c:forEach items="${list}" var="i">
			<tr>
					<td>${i.board_no }</td>
					<td><a href="detail?board_no=${i.board_no }">${i.board_title }</a></td>
					<td>${i.login_name }</td>
					<td>${i.board_date }</td>
					<td>${i.board_count }</td>
			</tr>
				</c:forEach>
		</table>
		
		</c:when>
		
		<c:otherwise>
			<h2>출력할 값 없음</h2>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${sessionScope.name ne null }">	
			<a href="./write">글쓰기</a>
	</c:if>
</body>
</html>