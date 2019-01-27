<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Page</title>
</head>
<body>
<div style="text-align: center">
<h3><a href="/yasai/ShowItemListServlet?action=top"><img src="img/yasai2.jpg" width="300"></a></h3>

<jsp:include page="/menu.jsp" /><br><br>
<hr>
<h1>${message}</h1><br><a href ="/yasai/Login.html">ログインページへ</a><br><a href ="/yasai/index.jsp">トップページへ</a>
</div>
</body>
</html>