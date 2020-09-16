<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.soo.db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>게시판 만들기</h1>
		<%
		//DB접속 객체 호출
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();
		
		//Pstmt
		PreparedStatement pstmt = null;
		
		//String sql
		String sql = "SELECT * FROM boardview";
		
		
		
		pstmt = conn.prepareStatement(sql);
		//데이터 전송
		ResultSet rs = pstmt.executeQuery();
		
		/*
		DBConnection
		DTO(vo) = 데이터 전송객체 (택배상자) 데이터타입이 미리 정해져있어야함 / 값 객체
		DAO = (택배 배달원) 사용자호출 -> DTO값 넣기 -> DAO가 데려옴
		*/
		%>
		
		<table class="table table-hover" >
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>글쓴이</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<!-- while문 시작 -->
			<% 
			while(rs.next()) { //next() 다음출력할 값이 있을때 돌고 없을때 멈춤 / 참 거짓 / boolean타입
			%>
			<tr>
				<td style="width: 10%"><%=rs.getString(1) %></td>
				<td style="width: 50%"><%=rs.getString("board_title") %></td>
				<td style="width: 10%"><%=rs.getString(2) %></td>
				<td style="width: 20%"><%=rs.getString("board_date") %></td>
				<td style="width: 10%"><%=rs.getString(3) %></td>
			</tr>
			<!-- while문 종료 -->
			<% 
			}
			%>
			</table>
</body>
</html>