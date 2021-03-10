<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./top">톱 페이지로</a><br/>
<c:if test="${empty access_token }">
	<a href="loginForm">로그인 페이지로</a><br/>
</c:if>
<c:if test="${not empty access_token }">
	현재 로그인 계정 : ${loginid }<br/>
	<a href="logout">로그아웃</a><br/>
</c:if>
</body>
</html>
