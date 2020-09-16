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
	
		<h1>글쓰기</h1>
		<form action="writeAction" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="30" cols="20" name="content" id="summernote"></textarea></td>
				</tr>
				
			</table>
	
			<button type="submit">글쓰기</button>
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