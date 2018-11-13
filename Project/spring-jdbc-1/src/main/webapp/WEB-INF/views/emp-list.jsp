<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>직원정보</h3>
		<p>직원들의 상세한 정보입니다.</p>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>직원번호</th>
					<th>성명</th>
					<th>직업</th>
					<th>월급</th>
				</tr>
			</thead>
			<tbody>
			 <!-- EmpController에서 키값을 "emps" 로 줬기 때문에-->
			 <!-- emps 로 넘긴 객체는 List<Emp> -->
			 <!-- EL 표기식은 멤버변수식으로 설정 실제는 겟터로 가져옴 -->
				<c:forEach var="e" items="${emps }">
					<tr>
						<td>${e.empno }</td>
						<td>${e.ename }</td>
						<td>${e.job }</td>
						<td>${e.sal }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
