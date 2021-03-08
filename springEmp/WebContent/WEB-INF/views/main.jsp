<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/main.jsp</title>
</head>
<body>
<c:if test="${ ! empty sessionScope.loginid }">
	현재 로그인 계정 : ${sessionScope.loginid}<hr>
	<a href="logout">로그아웃</a><br/>
	<a href="changePW">패스워드 변경</a><br/>
</c:if>
<c:if test="${empty sessionScope.loginid }">
	<a href="login">로그인</a><br/>
</c:if>
<a href="../springEmp/userList.jsp">유저조회</a><br/>
<a href="../springEmp/userList_Json_rest.jsp">REST로 유저조회</a><br/>
<a href="getSearchEmp">사원조회</a><br/>
<a href="getSearchDept">부서조회</a><br/>
<a href="getSearchJob">업무조회</a><br/>
메인페이지입니다.<br/>
<img src="./resources/images/Hydrangeas.jpg"><br/>
</body>
</html>