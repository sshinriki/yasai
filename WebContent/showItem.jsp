<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
<div style="text-align: center">
<h3><a href="/yasai/ShowItemListServlet?action=top"><img src="img/yasai2.jpg" width="300"></a></h3>

<jsp:include page="/menu.jsp" /><br><br>
<hr><br>


	<form action="/yasai/CartServlet?action=add" method="post">

		<input type="hidden" name="item_code" value="${item.code}">
		<input type="hidden" name="item_stock" value="${item.stock}">

		<table border=1 align="center">

			<tr>
				<td width="300"><div align="center"><img src="img/${item.img}" width="200"></div><br>	</td>
				<td width="300" >商品番号：${item.code}<br><br>
				商品名：${item.name}<br><br>
				商品説明：${item.detail}<br><br>
				価格（税込）：${item.price}<br><br>
				個数：<input type="text" name="quantity">
				在庫：${item.stock}<br>
				<input type="submit" value="カート追加">
				</td>
	
			</tr>
		</table>
	</form><br>
</div>
</body>
</html>
