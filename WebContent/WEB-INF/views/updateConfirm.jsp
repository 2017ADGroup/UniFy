<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="css/commons.css" rel="stylesheet">
<title>更新内容確認画面</title>

<style>
.col {
	float: left;
}

.col-clear {
	clear: both;
}

#arrow {
	margin-top: 60px;
}
</style>
</head>
<body>
	<p>
		<font color="red"> <c:if test="${not empty msg}">
				<p>${msg}</p>
			</c:if>
		</font>

	</p>
	<p>これでよろしいですか？</p>

	<form:form action="update" modelAttribute="update" method="post">
		<fieldset>
			<div>
				<label>ID</label><form:input path="id" value="${id}" disabled="true"/>
				<form:hidden path="id"/>
			</div>
		</fieldset>

		<fieldset class="col">
			<legend>変更前</legend>
			<div>
				<label>名前</label><form:input  value="${name}" path="name" disabled="true"/>
			</div>
			<div>
				<label>TEL</label><form:input value="${tel}" path="tel" disabled="true"/>
			</div>
			<div>
				<label>PASS</label><form:password path="pass" value="${pass}" disabled="true"/>
			</div>
		</fieldset>

		<div id="arrow" class="col">⇒</div>

		<fieldset class="col label-110">
			<legend>変更後</legend>
			<div>
				<label>名前</label><form:input path="newName" value="${newname}" disabled="true"/>
				<form:hidden path="newName"/>
			</div>
			<div>
				<label>TEL</label><form:input path="newTel" value="${newtel}" disabled="true"/>
				 <form:hidden path="newTel"/>
			</div>
			<div>
				<label>PASS(再入力)</label><form:password path="rePass" value="${sai}"/>
			</div>
		</fieldset>

		<div class="col-clear">
			<input type="submit" name="button" value="更新"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='updateInput'; return false;">
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>