<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a href="/yasai/ShowItemListServlet?action=list&code=0">全ての商品を見る</a><br><br>

<c:forEach items="${categories}" var="category">
	<a href="/yasai/ShowItemListServlet?action=list&code=${category.code}">${category.name}</a>
</c:forEach>
<br><br>
<a href="/yasai/CartServlet?action=show">カートを見る</a>
