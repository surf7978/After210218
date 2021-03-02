<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/deptList.jsp</title>
</head>
<body>
<h3>부서목록</h3>
<c:forEach items="${list }" var="dept">
	<span>${dept.department_id }</span>
	<span>${dept.department_name }</span>
	<br />
</c:forEach>
</body>
</html>