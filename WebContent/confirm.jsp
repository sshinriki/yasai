<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注文確認</title>
</head>
<body>
<div style="text-align: center">
<h3><a href="/yasai/ShowItemListServlet?action=top"><img src="img/yasai2.jpg" width="300"></a></h3>

<jsp:include page="/menu.jsp" /><br><br>
<hr>
<h3>下記の内容で注文を行いますか？</h3>
<h3>ご注文内容</h3>

<c:if test="${not empty cart.items}">
<table border="1">
<tr><td>商品番号</td><td>商品名</td><td>単価(税込)</td>
    <td>個数</td><td>小計</td></tr>

<c:forEach items="${cart.items}" var="item">
<tr>
  <td align="center">${item.value.code}</td>
  <td align="center">${item.value.name}</td>
  <td align="right">${item.value.price}円</td>
  <td align="right">${item.value.quantity}</td>
  <td align="right">${item.value.price * item.value.quantity}円</td>
</tr>
</c:forEach>
<tr><td align="right" colspan="6">総計:${cart.total}円</td></tr>
</table>

<h3>お客様情報</h3>

<form action="/yasai/OrderServlet?action=order" method="post">
  <table border="1">
    <tr>
    <td>お名前</td><td>${userinfo.name}</td>
    </tr>
    <tr>
    <td>住所</td><td>${userinfo.address}</td>
    </tr>
    <tr>
    <td>電話番号</td><td>${userinfo.tel}</td>
    </tr>
    <tr>
    <td>e-mail</td><td>${userinfo.email}</td>
    </tr>
    </table><br>
    <input type="submit" value="この内容で注文">
</form>

</c:if>
</div>
</body>
</html>