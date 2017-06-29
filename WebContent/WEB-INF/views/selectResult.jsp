<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="css/commons.css" rel="stylesheet">
<title>検索結果画面</title>

</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>

			<th>TEL</th>

		</tr>
		<c:forEach var="user" items="${userlist}">
			<tr>
				<td>${fn:escapeXml(user.user_id)}</td>
				<td>${fn:escapeXml(user.user_name)}</td>
				<td>${fn:escapeXml(user.telephone)}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>