<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/job/getJob.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
<h3>${job.job_title }부서정보</h3>
	업무번호 : ${job.job_id }<br />
	업무명 : ${job.job_title}}<br />
	최소월급 : ${job.min_salary }<br />
	최대월급 : ${job.max_salary } <br />
	<a href="getSearchjob">목록으로</a>
</body>
</html>