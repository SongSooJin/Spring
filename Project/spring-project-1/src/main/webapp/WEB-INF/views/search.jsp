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
<style type="text/css">
.bs-example {
	margin: 20px;
}
a
</style>
</head>
<body>
	<div class="bs-example">
		<h3>Product's Search</h3>
		<form class="" action="" method="post">
			<table class="table table-hover">
				<tr>
					<th>Name</th>
					<td><input type="text" name="product_name"
						placeholder="상품명을 입력하세요"></td>
				</tr>

				<!-- <tr>
					<th>Price</th>
					<td><input type="text" name="product_price"></td>
				</tr> -->
				<tr>
					<td colspan="2">
						<button type="submit">Search</button>
					</td>
				</tr>


			</table>

		</form>
		<hr>
		<p>${conditions }</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${products}">
					<tr>
						<td>${e.product_name}</td>
						<td>${e.product_price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>