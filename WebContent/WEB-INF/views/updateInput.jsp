<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="css/commons.css" rel="stylesheet">
<title>更新内容入力画面</title>

</head>
<body>
	<p>
		１箇所以上の項目を変更してください<br> ※IDは変更できません
	</p>

	<form:form action="updateConfirm" modelAttribute="update" method="post">
		<fieldset>
			<div>
				<label>ID</label><form:input path="id" value= "${id}" disabled="true"/>
				<form:hidden path="id"/>
			</div>
			<div>
				<label>名前</label><form:input path="newName" value="${name}"/>
			</div>
			<div>
				<label>TEL</label><form:input path="newTel" value="${tel}"/>
			</div>
			<div>
				<label>PASS</label><form:password path="newPass" value="${pass}"/>
			</div>
		</fieldset>
		<div>
			<input type="submit" name="button" value="確認"> <input
				type="submit" name="button" value="戻る"
				onclick="location.href='update'; return false;">
		</div>
	</form:form>
	<div>
		<p>
			<font color="red"> <c:if test="${not empty msg}">
					<p>${msg}</p>
				</c:if>
			</font>

		</p>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
