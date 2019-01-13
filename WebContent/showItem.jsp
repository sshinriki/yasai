<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
<h3>SBYK</h3>


	<form action="/yasai/CartServlet?action=add" method="post">

		<input type="hidden" name="item_code" value="${item.code}">
		<table border=1>
			<tr>
				<td width="150"><img src="img/${item.img}" width="60"><br>	</td>
				<td width="200" >商品番号：<b>${item.code}</b><br>
				商品名：<b>${item.name}</b><br>
				商品説明：<b>${item.detail}</b><br>
				価格（税込）：${item.price}<br><br>
				個数：
				<select name="quantity">
				<option value="1">1
				<option value="2">2
				<option value="3">3
				<option value="4">4
				<option value="5">5
				</select>
				<input type="submit" value="カート追加">
				</td>
	
			</tr>
		</table>
	</form>

</body>
</html>
