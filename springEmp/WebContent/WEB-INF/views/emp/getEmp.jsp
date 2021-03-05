<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/emp/getEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btnUpd").on("click", function(){
			//location.href="updateEmp?employee_id=${emp.employee_id}"
			location.assign("updateEmp?employee_id=${emp.employee_id}&department_id=${emp.department_id}&job_id=${emp.job_id}");
		});
	});
</script>
</head>
<body>
파라미터 ${employee }
<hr>
<h3>${emp.first_name }사원정보</h3>
	사번 : ${emp.employee_id }<br />
	이름 : ${emp.last_name } ${emp.first_name }<br />
	이메일 : ${emp.email }<br />
	급여 : ${emp.salary } <br />
	입사일 : <fmt:formatDate value="${emp.hire_date }" pattern="yyyy-MM"/><br />
	<a href="getSearchEmp">목록으로</a>
	<button id="btnUpd">수정</button>
	<a href="deleteEmp?employee_id=${emp.employee_id }">삭제</a>
</body>
</html>