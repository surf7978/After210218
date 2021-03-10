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
<a href="auth">auth 페이지로</a>
<a href="callback">토큰발급</a>
<a href="userInfo">사용자정보</a>
<div>
	access_token:${access_token}
</div>
</body>
</html>
