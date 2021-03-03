<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/dept/getSearchDept.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
<h3>부서목록</h3>
<c:forEach items="${list }" var="dept">
	<div class="row">
	<span>${dept.department_id }</span>
	<a href="getDept?department_id_id=${dept.department_id }">
	${dept.department_name }</a>
	<span>${dept.manager_id }</span>
	<span>${dept.location_id } </span>
	</div>
</c:forEach>
</body>
</html>