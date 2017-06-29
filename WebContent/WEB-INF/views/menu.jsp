<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
 <% String admin = (String)session.getAttribute("adminname");
if(admin==null){
	response.sendRedirect("/");
}
%>
<%session.removeAttribute("sid");%>
	<p>${adminname}さん、こんにちは</p>

	<p>
		<a href="select">検索</a>
	</p>
	<p>
		<a href="insert">登録</a>
	</p>
	<p>
		<a href="update">更新</a>
	</p>
	<p>
		<a href="delete">削除</a>
	</p>
	<form action="logout" method="post">
		<input type="submit" value="ログアウト">
	</form>

</body>
</html>
