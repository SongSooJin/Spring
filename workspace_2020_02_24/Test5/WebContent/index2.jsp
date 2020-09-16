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
<title>Insert title here</title>
</head>
<body>
	<h1>데이터베이스 접속하기 2</h1>
	<h2>접속정보 분리하기</h2>
	<%
		// DBConnection 불러오기 = 객체 생성 -> 디자인패턴 : 싱글턴패턴 -> static
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection(); //메소드
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 접속정보 실제 주입
		pstmt = conn.prepareStatement("SELECT * FROM login");
		rs = pstmt.executeQuery(); // excute:인서트/업데이트/델리트      
									//executeQuery: select
		
		
	%>
	
	<h2>출력하기</h2>
	<table border="1" >
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>가입일</td>
			<td>번호</td>
		</tr>
		<!-- 자바의 while문 시작 -->
		<%
			while(rs.next()){
		%>
		<tr>
			<td><%=rs.getString("login_no") %></td>
			<td><%=rs.getString("login_id") %></td>
			<td><%=rs.getString("login_pw") %></td>
			<td><%=rs.getString("login_name") %></td>
			<td><%=rs.getString("login_date") %></td>
			<td><%=rs.getString("login_auth") %></td>
		</tr>
		<!-- 자바의 while문 끝 -->
		<%
			}
		%>
	</table>
	
	
	
	
	
	
</body>
</html>