<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="css/commons.css" rel="stylesheet">
<title>登録確認画面</title>

</head>
<body>
	<p>
		<font color="red"> <c:if test="${not empty msg}">
				<p>${msg}</p>
			</c:if>
		</font>

	</p>
	<p>これでよろしいですか？</p>

	<form:form action="insertConfirm" modelAttribute="insert" method="post">
		<fieldset class="label-110">
			<div>
				<label>名前</label>
				<form:input path="name" disabled="true" />
				<form:hidden path="name" />
			</div>
			<div>
				<label>TEL</label>
				<form:input path="tel" disabled="true" />
				<form:hidden path="tel" />
			</div>
			<div>
				<label>PASS（再入力）</label>
				<form:password path="rePass" />
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="登録"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='insert'; return false;">
		</div>
	</form:form>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
