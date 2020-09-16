<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>

</head>
<body>

	<div id="container">
		<%@include file="menu.jsp" %>
		
		<div id="mainer">
	<!-- 		본문 내용 -->
			<div id="comment" style="margin-top: 50px;">
				<form action="commentEditAction" method="post">
					<input type="hidden" name="board_no" value="${dto.board_no }">
					<input type="hidden" name="cno" value="${dto.cno }">
					<div id="commenttextarea">
					<textarea rows="5" cols="200" name="comment">${dto.comment }</textarea>
					</div>
					<div id="commentbutton"><button type="submit">수정</button></div>
				</form>
			</div>
	
		</div>
	</div>
</body>
</html>