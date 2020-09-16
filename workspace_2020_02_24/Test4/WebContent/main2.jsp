<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main2.jsp</title>
</head>
<body>
	<h1>main2.jsp</h1>
	
	<%
	//for으로 구구단 2단 찍어주세요.
	StringBuffer sb = new StringBuffer();
	
	for(int i = 1; 10> i; i++) {
		sb.append("2 x " + i + "= " + (2*i) + "<br>");
	}
	
	//결과값을 StringBuffer
	%>
	html로 결과값 찍기<br>
	<%=sb %>
	
	<form action="main2.jsp" method="get">
		<input type="number" name="dan">
		<button type="submit">구구단 보기</button>
	</form>
	
	<%
	if(request.getParameter("dan") != null)	{
		System.out.println("dan" + request.getParameter("dan"));
		// 값이 있을때만 동작?
		// System.out.println("단이 입력되었습니다.");
		int dan = Integer.parseInt(request.getParameter("dan")) ;
		for(int i=1; 10>i; i++) {
			//System.out.println(dan + " X " + i + " = "+ (dan * i));
			//출력-> html
	%>		
			<%=dan + " X " + i + " = "+ (dan * i) %><br>
			
			<%		
		}
	}
	 		%>

	<hr>
	<form action="login.jsp" method="post">
		<input type="text" name="id">
		<input type="password" name="pw">
		<button type="submit">로그인</button>
	</form>
</body>
</html>