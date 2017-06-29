<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String ses = (String)session.getAttribute("adminname");
    if(ses != null||!ses.equals("")){
    	session.removeAttribute("adminname");
    }
    %>
<meta http-equiv="Refresh" content="3;URL=index">
<title>ログアウト</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<div class="center">
  <p>ログアウトしました。<br>
  ※３秒後にTOP画面に遷移します。</p>
</div>
</body>
</html>
