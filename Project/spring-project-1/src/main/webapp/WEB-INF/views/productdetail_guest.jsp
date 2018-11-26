<%@page import="com.example.demo.product.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="product" class="com.example.demo.controller" />

<%
String no = request.getParameter("product_id");
Product bean = productMgr.getProduct("product_id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js">
</script>
</head>
<body>

<form action="">
<table style="width: 90%">
	<tr>
		<td style="width: 20%">
			<img title="<%=bean.getproduct_name() %>" src="../data/<%=bean.getproduct_image() %>" width="150">
		</td>
		<td style="width: 50%;  vertical-align: top;">
			<table style="width: 100%">
				<tr><td>번호 : </td><td><%=bean.getproduct_id() %></td></tr>
				<tr><td>상품명 : </td><td><%=bean.getproduct_name() %></td></tr>
				<tr><td>가격 : </td><td><%=bean.getproduct_price() %></td></tr>
				<Tr>
					<td>주문 수량</td>
					<Td>
						<input type="text" name="quantity" value="1" size="5" style="text-align: center;">
					</Td>
				</Tr>
				<tr>
					<td colspan="3" style="text-align: center;">
						<Br>
						<input type="hidden" name="product_no" value="<%=bean.getproduct_id() %>">
						<input type="submit" value="장바구니에 담기">
						<input type="button" value="이전화면으로" onclick="history.back()">
					</td>
				</tr>
			</table>
		</td>
		<td style="width: 30%; vertical-align: top;">
			<h4>상품 설명</h4 >
			<%=bean.getproduct_detail() %>
		</td>
	</tr>
</table>
</form>

</body>
</html>