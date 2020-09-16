<%@page import="com.soo.dao.BoardDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//검사.
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	BoardDAO2 dto = new BoardDAO2();
	String name = dto.login(id, pw);
	
	//검사하기
	if(name.equals("")){
		//페이지 이동
		response.sendRedirect("login.jsp");
	}else {
		//페이지 이동 = 정상 로그인 / 세션만들기
		//세션만들기 (부를이름, 값)
		session.setAttribute("name", name);
		
		//페이지 이동
		response.sendRedirect("index.jsp");
	}
	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>