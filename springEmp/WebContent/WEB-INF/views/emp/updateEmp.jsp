<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
   
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/emp/updateEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btngetSearchEmp").on("click", function(){
			window.open('getSearchEmp','emp','width=500, height=800');
		});
	});
</script>
</head>
<body>
<h3 id="top">사원수정</h3>
<form:form modelAttribute="empVO" action="updateEmp" method="post" name="frm">
	employee_id <form:input path="employee_id" /><br>
	first_name  <form:input path="first_name" /><br>
	last_name   <form:input path="last_name" /><br>
	email       <form:input path="email" />
				<button type="button" id="btnEmail">중복체크</button>
				<span id="emailResult"></span>
				<br>
	phone_number<form:input path="phone_number" /><br>
	hire_date   <form:input path="hire_date" /><br>
	<!-- 임시용 job_id department_id 
	job_id      
				<select name="job_id">
						<option value="AC_ACCOUNT">Accounting Manager</option>
				</select>
				<br>
	department_id	
				<input type="radio" name="department_id" value="10">10
				<br>
	-->
	job_id      
				<form:select path="job_id">
					<option value="">선택</option>
					<form:options items="${jobList }" 
					itemLabel="job_title" itemValue="job_id" />
				</form:select>
				<br>
	department_id
				<!-- 
				<form:select path="department_id">
					<option value="">선택</option>
					<form:options items="${deptList }" itemLabel="department_name" itemValue="department_id" />
				</form:select>	
				 -->
				<form:radiobuttons path="department_id" items="${deptList }"
				 itemLabel="department_name" itemValue="department_id" />
				<br>
	manager_id  
	<form:input path="manager_id" />
	<input type="text" name="manager_name">
	<button type="button" id="btngetSearchEmp">사원검색</button><br>	
	<button type="submit">수정</button>
	<button type="reset">초기화</button><br/>
	<a href="getSearchEmp">목록으로</a>
</form:form>
</body>
</html>
