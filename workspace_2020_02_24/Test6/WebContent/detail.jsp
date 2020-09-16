<%@page import="com.soo.dto.BoardDTO"%>
<%@page import="com.soo.dao.BoardDAO2"%>
<%@page import="com.soo.util.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<h1>detail</h1>

<%
	//if() 숫자인지 확인해야함
	//= String borad_no = request.getParameter("board_no");\
	
if(!request.getParameter("board_no").equals(null)){		
	int board_no = Util.str2Int(request.getParameter("board_no"));
	
	BoardDAO2 dao = new BoardDAO2();
	BoardDTO dto = dao.detail(board_no);
	//http://localhost:8080/Feb13/detail.jsp?board_no=1
	//System.out.println(dto.getBoard_title());
			
//웹상에서 날리는 모든 데이터는 스트링
// 1, 100
// 데이터베이스로 보내서 
%>

<%-- 결과: <%=Util.str2Int(request.getParameter("board_no")) %> --%>

번호 : <%=dto.getBoard_no() %> <br>
제목 : <%=dto.getBoard_title() %> 

<% if(session.getAttribute("name").equals(dto.getLogin_name())){

%>
[삭제 / 수정]
<%	
	} 
%>
<br>
내용 : <%=dto.getBoard_content() %><br>
글쓴이 : <%=dto.getLogin_name() %><br>
날짜 : <%=dto.getBoard_date() %><br>
조회수 : <%=dto.getBoard_count() %><br>


<%
}
%>

</body>
</html>