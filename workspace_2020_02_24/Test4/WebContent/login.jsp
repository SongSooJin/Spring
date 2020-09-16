<%@page import="java.util.HashMap"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<% 
//map    key id/ value pw
HashMap<String, String> login = new HashMap<String, String>();
// 값 입력
login.put("iot", "01234567"); // id / pw
login.put("poseidon", "01234567");
login.put("admin", "admin");
login.put("rot", "rot");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>login</h1>
	
	<%
		if(request.getParameter("id") == null || request.getParameter("pw") == null 
			&& request.getParameter("id").length() < 3 || request.getParameter("pw").length() < 3 ) {
			%>
			<h2>올바른 ID / PW를 입력하세요.</h2>
			<h3><a href="main2.jsp">다시 로그인 하기</a></h3>
			<%
		} else {
			%>
			입력하신 id : <%=request.getParameter("id") %><br>
			입력하신 pw : <%=request.getParameter("pw") %><br>
			입니다.
			<%
			//java
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			//map과 비교하기
			if(login.containsKey(id)) {
				if(login.get(id).equals(pw)) {
					// 정상 로그인
					%>
					<h2>반갑습니다.</h2>
					<%
			} else{
				// 잘못된 pw
					%>
				<h2>올바른 id / pw 를 입력하세요.</h2>
				<h3><a href="main2.jsp">다시 로그인 하기</a></h3>
					<%
				}
			} else {
				// 잘못된 id
					%>
				<h2>올바른 id / pw 를 입력하세요.</h2>
				<h3><a href="main2.jsp">다시 로그인 하기</a></h3>
					<%
			}
			
		}
	%>
	
</body>
</html>