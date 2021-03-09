<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/emp/getSearchEmp.jsp</title>
</head>
<body>
<h3>목록</h3>
<div class="row" style="font-size:20px;">
		<span style="color:red;">product_id</span>
		<span>product_name</span>
		<span>product_price</span>
		<span>SALARY</span>
		<span>HIRE_DATE</span>
		<br>
		<span style="color:red;">DEPARTMENT_ID</span>
		<span style="color:blue;">DEPARTMENT_NAME</span>
		<br>
		<span style="color:red;">JOB_ID</span>
		<span style="color:green;">JOB_TITLE</span>
	</div>
	<hr>
<c:forEach items="${list }" var="emp">
	<div class="row">
		<span>${emp.product_id }</span>
		<span>${emp.product_name }</span>
		<span>${emp.product_price } </span>
		<span>${emp.product_info } </span>
		<span>${emp.product_date } </span>
		<span>${emp.company } </span>
		<span>${emp.manager_id } </span>
		<hr>
	</div>
</c:forEach>
<a href="insertEmp">사원추가</a>
</body>
</html>