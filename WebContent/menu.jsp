<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a href="/kaihatu/ShowItemListServlet?action=top">ようこそ</a>

<c:forEach items="${categories}" var="category">
	<a href="/kaihatu/ShowItemListServlet?action=list&code=${category.code}">${category.name}</a>
</c:forEach>

<a href="/kaihatu/ShowItemListServlet?action=show">カートを見る</a>