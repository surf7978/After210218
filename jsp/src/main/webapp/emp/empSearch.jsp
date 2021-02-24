<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empSearch.jsp</title>
</head>
<body>
<c:forEach items="${list }" var="emp">
	${emp.employee_id } /
	${emp.last_name } ${emp.first_name } /
	${emp.department_id } /
	${emp.manager_id }  
	<button type="button" id="${emp.employee_id }">선택</button>
	<br/>
</c:forEach>
</body>
</html>