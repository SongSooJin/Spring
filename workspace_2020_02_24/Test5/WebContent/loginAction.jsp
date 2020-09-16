<%@page import="com.soo.db.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//DB와 연결
	DBConnection db = new DBConnection();
	Connection conn = db.getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	
	//id받기
	String id = request.getParameter("id");
	
	//pw받기
	String pw = request.getParameter("pw");
	
	
	String sql = "SELECT login_name FROM login WHERE login_id = '"
				+ id 
				+"' AND login_pw ='" 
				+ pw + 
				"' ";
	
	stmt = conn.createStatement();
	//입력된 ID/PW가 실제 데이터베이스에 있는지 sql문 전송
	//sql 인젝션 공격 막기 위해 pstmt로 사용해야됨	

	rs = stmt.executeQuery(sql); // 결과값이 rs에 담겼습니다.
	
	String name = "";
	
	if(rs.next()) { // 1 0 
		name = rs.getString("login_name");
		System.out.print("name : " + name);
	}
	System.out.print("name : " + name);
	
	// 'OR '1' = '1
	//결과 받아서 화면에 출력 / 페이지 이동시키기
	if(name.equals("")) {
		response.sendRedirect("login.jsp");
	} else {
		response.sendRedirect("main.jsp");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginAction.jsp</title>
</head>
<body>
	id : <%=request.getParameter("id") %><br>
	pw : <%=request.getParameter("pw") %><br>
	결과 : <%=name %>
</body>
</html>