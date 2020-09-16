<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>

<link href="./resoureces/css/join.css" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">
	function checkID() {
		var id = $('#insertID').val();
		
		if($('#insertID').val() == ''){
			alert("ID를 입력하세요.");
			$('#insertID').fucus();
			return false;
		}
		
		$.ajax({
			type : 'POST',
			data : "id=" + id,
			dataType : 'text',
			url : 'checkID',	
			success : function(rData, textStatus, xhr){
				//alert("성공여부 : " + rData);
				if(rData == 0){
					//가입할 수 있는 경우
					alert("가입할 수 있는 ID입니다.");
					$('#resultText').css('color','blue');
					$('#resultText').text('가입 가능한 ID입니다.');
					$('#checkIt').prop('disabled', false);
				} else {
					//이미 등록된 경우
					alert("이미 가입된 ID입니다.");
					$('#resultText').css('color','red');
					$('#resultText').text('이미 가입된 ID입니다.');
					$('#checkIt').prop('disabled', true);
				}
			},
			error : function(xhr, status, e){
				alert("에러가 발생했습니다." + e);
			}
		});
		return false;
	}
	
	
function check(){
	//alert("가입하기 버튼을 눌렀습니다.");
	if(document.frm.name.value == ""){
		alert("닉네임을 입력하세요.");
		document.frm.name.focus();
		//name=""
		return false;
	}
	
	if(document.frm.pw1.value == ""){
		alert("비밀번호를 입력하세요.");
		document.frm.pw1.focus();
		return false;
	}

	if(document.frm.pw2.value == ""){
		alert("비밀번호를 입력하세요.");
		document.frm.pw2.focus();
		return false;
	}
	
	if(document.frm.pw1.value != document.frm.pw2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	
}
</script>

<body>
	
	<div id="container">
		<%@include file="menu.jsp" %>

	<div>
	<h1>회원가입</h1>
	
	<form action="joinAction" method="post" name="frm">		
		<table class="table table-hover table-dark" >
			<tr>
				<td>아이디</td>
				<td>
					<input style="color: black;" type="text" name="id" id="insertID" placeholder="아이디를 입력하세요.">
					<button onclick="return checkID()" type="button" class="btn btn-light">ID체크</button>
					<p id="resultText">ID 체크를 눌러주세요.</p>
				</td>
			</tr>
			
			<tr>
				<td>닉네임</td>
				<td><input style="color: black;" type="text" name="name" id="name" placeholder="닉네임을 입력하세요."></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input style="color: black;" type="password" name="pw1"  id="pw1" placeholder="비밀번호를 입력하세요."></td>
			</tr>
			
			<tr>
				<td>비밀번호 확인</td>
				<td><input style="color: black;" type="password" name="pw2"  id="pw2" placeholder="비밀번호를 다시 입력하세요."></td>
			</tr>
		</table>
		
		<button type="submit" id="checkIt" disabled="disabled" onclick="return check()" type="button" class="btn btn-dark">가입하기</button>
		<br>ID체크를 눌러 검사를 해야 가입을 진행할 수 있습니다.
		</form>
	</div>
	</div>
</body>
</html>