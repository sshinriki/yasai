<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>新規ユーザ登録</title>
</head>
<body>
<h2>新規でユーザ登録をします</h2>
<h4><font color="blue">★全項目入力してください</font></h4>

<form action = "/yasai/UserFormServlet" method = "post">
  お名前	：<input type="text" name = "name"><br>
  住所：<input type="text" name = "address"><br>
  電話番号：<input type="text" name = "tel"><br>
  ユーザ名：<input type="text" name = "id">	<font color="red">※メールアドレスを入力ください。</font><br>
  パスワード：<input type = "password" name = "pw"><br>
  <input type="hidden" name="action" value="register">
  <input type = "submit" value="登録">
  </form>
    <br><a href ="/yasai/index.jsp">トップページへ</a>
</body>
</html>