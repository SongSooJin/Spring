<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" 
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" 
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<style type="text/css">
	
#wrap {
	margin:0 auto;
	width:1200px;
}

#header h1 {
	margin:100px;
	width:150px;
	height:100px;
	line-height: 100px;
	background-color:#ff88a7;
	text-align: center;
	font-weight:bold;
}

#header h1 a {
		color:black;
}

#header h1 a:hover {
	text-decoration:none;
	color:navy;
}

.input {
	width:700px;
	height:100px;
	margin:-170px 0 0 300px;
}

.icon1{
	margin:-50px 0 0 650px;
}

.icon1 a {
	color:black;
}

.icon1 a:hover {
	color:navy;
}

.icon2{
	margin:-45px 0 0 720px;
}

.icon2 a {
	color:black;
}

.icon2 a:hover {
	color:navy;
}

#content {
	text-align:center;
}

#content thead tr th {
	background-color:#7bf3ff;
	font-size:20px;
	text-align:center;
}

#content tbody tr td {
	list-style:none;
	padding-left:0px;
	font-size:18px;                 

}

#footer {
	background-color:#ff88a7;
	position: relative;
	width:100%;
	display: flex;
	text-align: left;
	margin:50px 0 0 0;
	
}

.footer li {
	list-style:none;
}

.footer1 {
  flex: 1;
}

.footer2 {
  flex: 1;
}

.footer3 {
  flex: 1;
}

</style>
</head>
<body>
	<div id="wrap">
    <div id="header">
			<h1><a href="#">로고 </a></h1>
			<form class="input" action="" method="post">
				<input type="text" name="product_name" style="text-align:center; width:500px; height:50px;"              
								placeholder="상품명을 입력하세요">
				<button type="submit" style="text-align:center; width:100px; height:50px;  background-color:#ff88a7; border: 2px solid #ff88a7;">
					<i class="fas fa-search"></i>
				</button>
				<div class="icon1">
					<a href="#">
					<i class="fas fa-user fa-3x"></i>
					</a>
				</div>
				<div class="icon2">
					<a href="#">
					<i class="fas fa-shopping-cart fa-3x"></i>
					</a>
				</div>
			</form>
    </div>
		
		<hr>
		
    <div id="content">
			<p><h2>${conditions }</h2></p>
			<br><br>
			<table class="table table-hover">
				<thead>
        <tr>
          <th>Product</th>
					<th>Name</th>
          <th>Price</th>
          <th>Delivery Charge</th>
          <th>Details</th>
        </tr>
			</thead>
			
			<tbody>
				<c:forEach var="r" items="${products}">
					<tr>
						<td><img src="image/getproduct_image()"></td>
						<!--${r.product_image}  -->
						<td>${r.product_name}</td>
						<td>${r.product_price}</td>
						<td>${r.product_deliveryCharge}</td>
						<td>${r.product_deliveryCharge}</td>
						
						<%-- <td><a href="javascript:productdetail_guest'('<%=p.getproduct_id()%>')">보기</a></td> --%>
					<tr>
				</c:forEach>
				</tbody>
				
				</table>
				<img src="../image/ho.jpg" alt="">
				
    </div>
		
    <div id="footer">
			<div class="footer1">
				<ul>
					<li>고객 센터  </li>
					<li>주소 : 서울특별시 중구 한강대로 </li>
					<li>전화번호 : 02-5262-0000 </li>
				</ul>
			</div>
			<div class="footer2">
				<ul>
					<li>본사주소 : 서울특별시 중구 한강대로</li>
					<li>주소 : 서울특별시 중구 한강대로</li>
					<li>전화번호 : 02-2525-0000 </li>
				</ul>
			</div>
			<div class="footer3">
				<ul>
					<li>소비자 분쟁</li>
					<li>주소 : 서울특별시 중구 한강대로</li>
					<li>전화번호 : 02-3216-0000 </li>
				</ul>
			</div>
    </div>
		
  </div>
	
		
		</body>
</html>