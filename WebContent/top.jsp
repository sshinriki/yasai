<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Welcom shopping!</title>
</head>
<body>
<h3><a href="/yasai/ShowItemListServlet?action=top"><img src="img/yasai2.jpg" width="250"></a></h3>

<h3>ようこそ！SBYKショッピングサイトへ</h3>
旬のおいしい野菜を購入しよう！<br><br>

<jsp:include page="/menu.jsp"/>
</body>
</html>