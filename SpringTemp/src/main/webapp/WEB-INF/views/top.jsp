<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 이거하면 로그인 로그아웃 목록 따로 보이는거 c:if안써도 됨 -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="admin/admin">관리자 전용 페이지로</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li><a href="logout">로그아웃</a></li>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<li><a href="logoutForm">로그인</a></li>
		</sec:authorize>
	</ul>
<a href="./home">홈 페이지로</a>
</body>
</html>