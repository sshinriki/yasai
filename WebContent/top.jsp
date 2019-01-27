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
<div style="text-align: center">
<h3><a href="/yasai/ShowItemListServlet?action=top"><img src="img/yasai2.jpg" width="300"></a></h3>
</div>

<div style="text-align: right">
	<p><a href="/yasai/Login.html">ログイン</a>&emsp;&emsp;&emsp;<a href ="/yasai/LoginServlet?action=logout">ログアウト</a></p>
</div>

<p style="text-align: center"><marquee behavior="alternate"><font color="navy" size="7">ようこそ！SBYKショッピングサイトへ</font></marquee></p>
<p style="text-align: center"><font size="5">旬のおいしい野菜を購入しよう！</font></p>
<p style="text-align: center"><img src="//www.jp.seicho-no-ie.org/brha/wp/wp-content/uploads/2015/12/57d18a3ee80a60d1b8f9dcc284fe74ec_s.jpg" width="450" height="300"></p><br>
<hr>


<div style="text-align: center; display:inline-block; width:50%;">
<p>
	<form action="/yasai/ShowItemListServlet?action=search" method="post">
	商品名検索：<input type="text" name="itemSearch">
	<input type="submit" value="検索"><br>
	</form><br>
<jsp:include page="/menu.jsp"/>
</p>
</div>


<div style="display:inline-block; width:50%; float:right; text-align:center;">
<p><span style="border-bottom: solid 4px red;"><font size="4">&ensp;栄養価の高い野菜ランキング Top5！&ensp;</font></span></p>

<table width="300" align="center"><tr><td style="border-style: none;text-align: center;">
<font size="5">1位&emsp;&emsp;…</font>
</td><td style="border-style: none;text-align: center;">
<font size="6"><a href ="/yasai/ShowItemServlet?action=list&code=1">キャベツ</a></font>
</td></tr><tr>
<td style="border-style: none;text-align: center;">
<font size="5">2位&emsp;&emsp;…</font>
</td><td style="border-style: none;text-align: center;">
<font size="6"><a href ="/yasai/ShowItemServlet?action=list&code=16">大根</a></font>
</td></tr><tr>
<td style="border-style: none;text-align: center;">
<font size="5">3位&emsp;&emsp;…</font>
</td><td style="border-style: none;text-align: center;">
<font size="6"><a href ="/yasai/ShowItemServlet?action=list&code=6">トマト</a></font>
</td></tr><tr>
<td style="border-style: none;text-align: center;">
<font size="5">4位&emsp;&emsp;…</font>
</td><td style="border-style: none;text-align: center;">
<font size="6"><a href ="/yasai/ShowItemServlet?action=list&code=18">ごぼう</a></font>
</td></tr><tr>
<td style="border-style: none;text-align: center;">
<font size="5">5位&emsp;&emsp;…</font>
</td><td style="border-style: none;text-align: center;">
<font size="6"><a href ="/yasai/ShowItemServlet?action=list&code=14">かぼちゃ</a></font>
</td></tr>
</table><br><br>
</div>

</body>	