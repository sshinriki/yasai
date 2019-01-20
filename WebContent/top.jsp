<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>トップページ</title>
</head>
<body>
<h3><a href="/yasai/ShowItemListServlet?action=top"><img src="img/yasai2.jpg" width="250"></a></h3>

<div style="position:absolute; top:90px; left:200px;">
	<pre><a href="/yasai/Login.html">ログイン</a>  <a href ="/yasai/LoginServlet?action=logout">ログアウト</a></pre>
</div>
<h3>ようこそ！SBYKショッピングサイトへ</h3>
旬のおいしい野菜を購入しよう！<br><br>
<jsp:include page="/menu.jsp"/>

</body>
</html>