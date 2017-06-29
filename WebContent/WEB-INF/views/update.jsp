<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="css/commons.css" rel="stylesheet">
 <!-- //セッションがなければリダイレクト// -->
   <%--   <% String ses = (String)session.getAttribute("adminname");
    if(ses == null||ses.equals("")){
    	 response.sendRedirect("login.jsp");
    }
    %> --%>
<title>更新画面</title>

</head>
<body>
<p>
<font color="red">

		 <c:if test="${not empty msg}">
		    <p>${msg}</p>
		  </c:if>
		  <c:if test="${not empty msg2}">
		    <p>${msg2}</p>
		  </c:if>



	</font>
		</p>
<p>更新を行うデータのIDを入力してください<br>
<span class="required"></span>は必須です</p>

<form:form action="updateInput" modelAttribute="update" method="post">
  <fieldset>
    <div>
      <label class="required">ID</label><form:input path="id"/>
    </div>
  </fieldset>
  <input type="submit" value="確認">
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
