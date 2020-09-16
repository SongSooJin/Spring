<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function check() {
		//alert("login을 눌렀습니다.");
		if(!document.login.id.value || document.login.id.value.length < 3) {
			alert("올바른 ID를 입력하세요.");
			login.id.focus();
			return false;
		}
		if(!document.login.pw.value || document.login.pw.value.length < 4) {
			alert("올바른 PW를 입력하세요.");
			login.pw.focus();
			return false;
		}
	}
	
</script>

</head>
<body>
	<h1>로그인 하기</h1>
	
	<form action="loginAction.jsp" method="post" 
			name="login" onsubmit="return check()">
			
		<input type="text" name="id" id="id">
		<input type="password" name="pw"  id="pw">
		<button type="submit">로그인 하기</button>
		
	</form>
	
</body>
</html>