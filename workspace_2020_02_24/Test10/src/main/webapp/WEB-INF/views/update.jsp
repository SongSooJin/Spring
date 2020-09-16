<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link href="./css/write.css" rel="stylesheet">
<!-- <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> -->
<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-- <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.js"></script> -->
</head>
<body>

	<%@include file="menu.jsp" %>
	
		<h1>글 수정</h1>
		<form action="updateAction" method="post">
			<div class="ti">
				<h4>제목</h4>
				<input type="text" name="title" value="${update.board_title }">
			</div>
				
			<div class="te">
				<h4>내용</h4>
				<textarea  rows="20" cols="20" name="content" id="summernote">${update.board_content }</textarea>
			</div>
			
			<input type="hidden" name="board_no" value="${update.board_no}">
			<button type="submit">글 수정</button>
		</form>
	
	<script type="text/javascript">
			$(document).ready(function() {
	 		$('#summernote').summernote({
	 			lang: 'ko-KR',
	 			height:500,
	 		});
			});
	</script>
</body>
</html>