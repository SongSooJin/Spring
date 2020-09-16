<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>   


</head>
<body>
<h1>detail</h1>
	
	<c:choose>
		<c:when test="${dto eq null }">
		<!-- 값이 없습니다. -->
			<c:redirect url="./board"/>
		</c:when>
		
		<c:otherwise>
		<!-- 값이 있습니다. -->
		<table class="table table-dark">
		  <thead>
		    <tr>
		      <th scope="col">번호</th>
		      <td>${dto.board_no}</td>     
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="col">제목</th>
		      <td>${dto.board_title }</td>     
		    </tr>
		    
		    <tr>
		      <th scope="col">글쓴이</th>
		      <td>${dto.login_name } 
			      <c:if test="${sessionScope.name eq dto.login_name }">
					<button onclick="location.href='update?board_no=${dto.board_no}'" type="button" class="btn btn-light">수정</button>
					<button onclick="location.href='delete?board_no=${dto.board_no}'" type="button" class="btn btn-light">삭제</button>
				  </c:if>  
			  </td>
		        
		    </tr>
		    
		    <tr>
		      <th scope="col">작성일</th>
		      <td>${dto.board_date }</td>
		    </tr>
		    
		    <tr>
		      <th scope="col">내용</th>
		      <td>${dto.board_content } </td>     
		    </tr>
		  </tbody>
		</table>

		</c:otherwise>
	</c:choose>
	<hr>
	
	
	<button onclick="location.href='./board'">리스트로 돌아가기</button>
	
</body>
</html>