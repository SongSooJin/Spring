<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>

<link rel="stylesheet" href="./resources/css/detail.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>   
 
<script type="text/javascript">

	function edit(cno, board_no) {
		//alert(number + "번 글을 클릭했습니다.");
		var result = confirm("해당 글을 수정하시겠습니까?");
		//alert(result);
		if(result) {
			//alert("확인을 눌렀습니다.");
			location.href="edit?cno=" + cno + "&board_no=" + board_no;
			
		}
	} 

	function del(number, board_no) {
		//alert(number + "번 글을 클릭했습니다.");
		var result = confirm("삭제 하시겠습니까?");
		//alert(result);
		if(result) {
			//alert("확인을 눌렀습니다.");
			location.href="del?cno=" + number + "&board_no=" + board_no;
		}
	} 
 
</script>
    
</head>
<body>
	<h1>detail</h1>
	
	<button onclick="location.href='./board'" type="button" class="btn btn-dark">리스트로 돌아가기</button>
	<div id="detailbox">
		<c:choose>
			<c:when test="${dto eq null }">
			<!-- 값이 없습니다. -->
				<c:redirect url="./board"/>
			</c:when>
			
			<c:otherwise>
			<!-- 값이 있습니다. -->
			
			<table class="table table-dark">
			    <tr>
			      <th scope="row">번호</th>
			      <td>${dto.board_no}</td>     
			    </tr>
			    <tr>
			      <th scope="row">제목</th>
			      <td>${dto.board_title }</td>     
			    </tr>
			    
			    <tr>
			      <th scope="row">글쓴이</th>
			      <td>${dto.login_name } 
				      <c:if test="${sessionScope.name eq dto.login_name }">
						<button onclick="location.href='update?board_no=${dto.board_no}'" type="button" class="btn btn-light">수정</button>
						<button onclick="location.href='delete?board_no=${dto.board_no}'" type="button" class="btn btn-light">삭제</button>
					  </c:if>  
				  </td>
			    </tr>
			    <tr>
			      <th scope="row" >작성일</th>
			      <td>${dto.board_date }</td>
			    </tr>
			    <tr>
			      <th scope="row" >내용</th>
			      <td>${dto.board_content }
			       <!-- 만약 board_file이 있다면 여기에 그림파일을 출력해 주세요.
			       		1. boardDTO에 board_file추가하기
			       		2. xml수정하기
			        -->
			        이미지 업로드 파일 : ${dto.board_file }
			        <c:if test="${dto.board_file ne null }">
			        	<img alt="업로드 파일 불러오기" src="./resources/upload/${dto.board_file }" width="1000px" height="900px">
			        </c:if>
			        
			      </td>     
			    </tr>
			</table>
	
			</c:otherwise>
		</c:choose>
	</div>
	<hr>
	
	
	
	<br><br><br>
	
	<c:if test="${sessionScope.name ne null }">
	<div id="commentbox">
		<form action="comment" method="post">
			<input type="hidden" name="board_no" value="${dto.board_no }">
			<textarea rows="2" cols="120" name="comment"></textarea>
			<button type="submit" type="button" class="btn btn-dark">저장</button>
		</form>
	</div>
	</c:if>

	<div id="commentshow">
	<table class="table table-dark">
	<tr>
		<td width="15%">닉네임</td>
		<td width="75%" >내용</td>
		<td width="10%">날짜</td>
		
	</tr>

	<c:choose>
	
		<c:when test="${fn:length(comment) > 0 }">
			<c:forEach items="${comment }" var="c">
				<tr>
					<td style="text-align:left;">
						${c.login_name }
						<!-- 내 글일 경우 삭제 -->
						<c:if test="${sessionScope.name eq c.login_name }">
							<img alt="수정" src="./img/change.png" height="25px" onclick="edit(${c.cno}, ${c.board_no})">
							<img alt="삭제" src="./img/del.png" height="25px" onclick="del(${c.cno},${c.board_no});">
						
						</c:if>
					</td>
					<td style="text-align:left;">${c.comment }</td>
					<td>${c.cdate }</td>
				</tr>
			</c:forEach>
		</c:when>
		
		<c:otherwise>출력할 댓글이 없습니다.</c:otherwise>
	</c:choose>
	
	</table>
	
	</div>
	
	
</body>
</html>