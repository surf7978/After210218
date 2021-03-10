<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="top">톱 페이지로</a>
<!-- 이렇게 하면 안 됨
<a href="../top">톱 페이지로</a>
 -->
<a href="../temp/top">톱 페이지로</a>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	<font color="red">
		${SPRING_SECURITY_LAST_EXCEPTION.message}
		<c:remove var="SPRING_SECURITY_LAST_EXCEPTION.message" scope="session" />
	</font>
</c:if>
<h3>로그인</h3>
<form action="login" method="post">
	<input name="id">
	<input name="password">
	<button>로그인</button>
</form>
<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=8b88c20e8232de584d13f04e421f2b48&redirect_uri=http://localhost/bank/callback">카카오 로그인</a>
</body>
</html>