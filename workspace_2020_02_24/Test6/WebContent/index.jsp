<%@page import="com.soo.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.soo.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>리스트 출력</h1>
	
	<%
	//DAO 호출
	
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardDTO> list = dao.boardList();
	
	%>
	
	 결과 값 : <%=list %>
	 
	 <table class= "table table-striped table-dark">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
	 
	<%
		for(int i=0; i<list.size(); i++){
			BoardDTO dto = list.get(i);
	%>
			
		<tr>
			<td><%=dto.getBoard_no() %></td>
			<td>
				<a href="detail.jsp?board_no=<%=dto.getBoard_no() %>">
					<%=list.get(i).getBoard_title() %>
				</a>
			</td>
			<td><%=list.get(i).getBoard_title() %></td>
			<td><%=list.get(i).getLogin_name() %></td>
			<td><%=list.get(i).getBoard_date() %></td>
			<td><%=list.get(i).getBoard_count() %></td>
		</tr>
	<%
		}
	%> 
	 </table>
	
	<% 
		if(session.getAttribute("name") == null) {
	%>
	
	<a href="login.jsp">로그인하기</a>
	<button><a href="login.jsp">로그인하기</a></button>
	<button onclick="location.href='login.jsp'">로그인</button>
	
	<%
		} else {
	%>
	
	<!-- 세션이 있다면 출력하게 하기 -->
	<%=session.getAttribute("name")%> 님 반갑습니다.
	
	<%		
		}
	%> 
	 
</body>
</html>