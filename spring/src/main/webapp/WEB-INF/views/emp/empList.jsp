<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/empList.jsp</title>
</head>
<body>
<h3>사원목록</h3>
<c:forEach items="${list }" var="emp">
	<span>${emp.employee_id }</span>
	<span>${emp.last_name }</span>
	<span>${emp.first_name }</span>
	<span>${emp.email }</span>
	<span>${emp.salary } </span>
	<span><fmt:formatDate value="${emp.hire_date }" pattern="yyyy-mm"/></span>
</c:forEach>
</body>
</html>