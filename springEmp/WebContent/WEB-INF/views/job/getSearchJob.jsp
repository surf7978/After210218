<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/job/getSearchjob.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
<h3>업무목록</h3>
<c:forEach items="${list }" var="job">
	<div class="row">
	<span>${job.job_id }</span>
	<a href="getJob?job_id=${job.job_id }">
	${job.job_title }</a>
	<span>${job.min_salary }</span>
	<span>${job.max_salary } </span>
	</div>
</c:forEach>
</body>
</html>