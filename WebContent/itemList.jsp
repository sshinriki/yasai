<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
<h3><a href="/yasai/ShowItemListServlet?action=top"><img src="img/yasai2.jpg" width="250"></a></h3>
<jsp:include page="/menu.jsp"/>
<h3>商品一覧</h3>

<c:forEach items="${items}" var="item">
	<form action="/yasai/ShowItemServlet?action=list&code=${item.code}" method="post">

		<input type="hidden" name="item_code" value="${item.code}">
		<table border=1>
			<tr>
				<td width="200" >商品番号：<b>${item.code}</b><br>
				商品名：<b>${item.name}</b><br><br><br>
				</td>
				<td width="150"><div align="center"><img src="img/${item.img}" width="60"></div>
				<div align="center"><input type="submit" value="商品詳細"></div>
				</td>
			</tr>
		</table>
	</form>
</c:forEach>
</body>
</html>