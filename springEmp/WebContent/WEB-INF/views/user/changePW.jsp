<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>changePW</title>
<style>
	.error{color:red;}
</style>
</head>
<body>
<a href="../springEmp/">메인으로</a>
<h3>패스워드 변경</h3>
<form:form action="changePW" method="post">
	현재 패스워드<input name="oldPassword"><form:errors path="oldPassword" cssClass="error"/><br/>
	변경할 패스워드<input name="password"><form:errors path="password" cssClass="error"/><br/>
	변경할 패스워드 확인<input name="newPassword"><form:errors path="newPassword" cssClass="error"/><br/>
	<button>변경</button>
</form:form>
</body>
</html>