<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>데이터베이스 접속</h1>
	<h2>사용자 정보 읽어오기</h2>
	<hr>
	
	<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:mariadb://localhost:3306/test";
	String id = "soo";
	String pw = "guddk717";
	String sql = "SELECT * FROM login";
			
	Class.forName("org.mariadb.jdbc.Driver");
	conn = DriverManager.getConnection(url, id ,pw);
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery(); // rs에 결과값 담기
	
	while(rs.next()) {
		// 출력
		%>
		
		<%=rs.getString(1) %> 
		<%=rs.getString(2) %> 
		<%=rs.getString(3) %> 
		<%=rs.getString(4) %> 
		<%=rs.getString(5) %> 
		<%=rs.getString(6) %> <br><hr>

		<%

	}
	
	%>
	
</body>
</html>