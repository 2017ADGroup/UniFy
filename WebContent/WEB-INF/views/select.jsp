<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="css/commons.css" rel="stylesheet">
<title>検索画面</title>

</head>
<body>
	<p>
		<font color="red"> <c:if test="${not empty msg}">
				<p>${msg}</p>
			</c:if>
		</font>

	</p>
	<p>
		検索したいデータ情報を入力してください<br> ※全て空白の場合は全検索を行います
	</p>

	<form:form action="list" modelAttribute="select" method="post">
		<fieldset>
			<div>
				<label>ID</label>
				<form:input path="id" value="${sid}" />
			</div>
			<div>
				<label>名前</label>
				<form:input path="name" />
			</div>
			<div>
				<label>TEL</label><form:input path="tel"/>
			</div>
		</fieldset>
		<input type="submit" value="検索">
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
