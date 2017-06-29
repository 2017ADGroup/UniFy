<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="css/commons.css" rel="stylesheet">
<title>ログイン画面</title>

</head>
<body>
	 <p>
		<font color="red"> <c:if test="${not empty msg}">
				<p>${msg}</p>
			</c:if>
		</font>

	</p>
 <form:form action="login" modelAttribute="login" method="post">
		<fieldset>
			<div>
				<label>ID</label><form:input  path="id" />
			</div>
			<div>
				<label>PASS</label><form:password path="pass" />
			</div>
		</fieldset>
		<input type="submit" value="ログイン">
	</form:form>
	<div>
		<a href="index">TOP画面へ</a>
	</div>
</body>
</html>
