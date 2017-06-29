<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="css/commons.css" rel="stylesheet">
<title>削除確認画面</title>

</head>
<body>
	<p>これでよろしいですか？</p>

	<form:form action="delete" modelAttribute="delete" method="post">
		<fieldset>
			<div>
				<label>ID</label>
				<form:input path="id" value="${id}" disabled="true"/>
				<form:hidden path="id" />

			</div>
			<div>
				<label>名前</label>
				<form:input path="name" value="${name}" disabled="true"/>
				<form:hidden path="name" />
			</div>
			<div>
				<label>TEL</label><form:input path="tel" value="${tel}" disabled="true"/><form:hidden path="tel"/>
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="削除"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='delete'; return false;">
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
