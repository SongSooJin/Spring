<%@page import="com.example.demo.product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="productMgr" class="com.example.demo.product.ProductMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js">
</script>
</head>
<body>

<table style="width:90%">
	<Tr style="background-color: pink">
		<th>상품</th><th>가격</th><th>재고량</th><th>상세보기</th>
	</Tr>
	
	<%
	ArrayList<ProductBean> list = productMgr.getProductAll();
	
	for(ProductBean p:list){
	%>
	<tr style="text-align: center;">
		<td><img src="../data/<%=p.getproduct_image()%>" width="70"><br><%=p.getproduct_name() %></td>
		<td><%=p.getproduct_price() %></td>
		<td><a href="javascript:productDetail_guest('<%=p.getproduct_id()%>')">보기</td>
	</tr>
	<%	
	}
	%>
</table>


<form action="productdetail_guest.jsp" name="detailFrm" method="post">
	<input type="hidden" name="product_id">
</form>
</body>
</html>
