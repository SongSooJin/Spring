<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link href="./css/detail.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<%@include file="menu.jsp" %>
	<div id="mainer">
<!-- 		본문 내용 -->
	<h1>detail</h1>

	<c:choose>
		<c:when test="${dto eq null }">
			<c:redirect url="./board"/>		
		</c:when>
		
		<c:otherwise>
			<table border="1" style="width: 800px;">
		<tr>
			<th style="width: 100px;">제목</th>
			<td style="width: 500px;">
				${dto.board_no } ${dto.board_title }
				<c:if test="${sessionScope.name eq dto.login_name }">				
					<button onclick="location.href='update?board_no=${dto.board_no }'">수정</button>
					<button onclick="location.href='delete?board_no=${dto.board_no }'">삭제</button>
				</c:if>
			</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>${dto.login_name } / ${dto.board_date} / ${dto.board_count}
			 </td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.board_content }
<!-- 			만약 board_file이 있다면 여기에 그림파일을 출력해주세요. -->
<!-- 			1. boardDTO에 board_file추가하기 -->
<!-- 			2. xml 수정하기.  -->
			값 : ${dto.board_file }
			<br>
			<c:if test="${dto.board_file ne null}">			
				<img alt="업로드" src="./resources/upload/${dto.board_file }">
			</c:if>
			
			</td>
		</tr>
	</table>
		</c:otherwise>
	</c:choose>
	
	
	
	<button onclick="location.href='./board'">리스트로</button>
	<img alt="board" src="./img/home.png" onclick="location.href='./board'">
	<c:if test="${sessionScope.name ne null }">
	<div id="comment">
		<form action="comment" method="post">
			<input type="hidden" name="board_no" value="${dto.board_no }">
			<div id="commenttextarea">
			<textarea rows="5" cols="50" name="comment"></textarea>
			</div>
			<div id="commentbutton"><button type="submit">저장</button></div>
		</form>
	</div>
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${fn:length(comment) > 0 }">
			<c:forEach items="${comment }" var="c">
			<div id="commentbox">
				<div id="commentid">${c.login_name }</div>
				<div id="commentdate">${c.cdate }</div>
				<div id="commentc">${c.comment }</div>
			</div>
			</c:forEach>
		</c:when>
		<c:otherwise>출력할 댓글이 없습니다.</c:otherwise>
	</c:choose>
	</div>
</div>	
</body>
</html>