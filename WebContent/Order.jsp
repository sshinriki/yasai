<%@ page language= "java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="C" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文完了!</title>
</head>
<body>
<div style="text-align: center">
<h3><a href="/yasai/ShowItemListServlet?action=top"><img src="img/yasai2.jpg" width="300"></a></h3>
<jsp:include page="/menu.jsp"/><br><br>
<hr>
<h3>ご注文ありがとうございました。</h3>
<h3>またのご利用をお待ちしております。</h3><br>
<a href ="/yasai/LoginServlet?action=logout">ログアウト</a>
</div>
</body>
</html>