<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link href="css/commons.css" rel="stylesheet">
<%-- <%
	String ses = (String) session.getAttribute("id");
	if (ses != null || !ses.equals("")) {
		session.removeAttribute("id");
	}
%> --%>
<title>削除結果確認画面</title>

</head>
<body>
	<p>実行者：${adminname}</p>
	<p>正常に削除されました</p>
	<form action="select">
		<input type="submit" value="検索">
	</form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
