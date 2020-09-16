<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>

<link href="./css/write.css" rel="stylesheet">

</head>
<body>

	<%@include file="menu.jsp" %>
	
		<h1>글 쓰기</h1>
		<form action="writeAction" method="post" enctype="multipart/form-data">
			<div class="ti">
				<h4>제목</h4> 
				<input type="text" name="title" value="${update.board_title }">
				
			</div>
				
			<div class="te">
				<h4>내용</h4>
				<textarea  rows="20" cols="20" name="content" id="summernote">${update.board_content }</textarea>
			</div>
	
			<div class="fi">
				파일
				<input type="file" name="file">
			</div>
			
			<button type="submit">글 쓰기</button>
			
		</form>
		
	<script type="text/javascript">
			$(document).ready(function() {
	 		$('#summernote').summernote({
	 			lang: 'ko-KR',
	 			height:500
	 		});
			});
	</script>
	
	
</body>
</html>