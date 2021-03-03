<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
    
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
<h3 id="top">사원입력</h3>
<form action="insertEmp" method="post" name="frm">
	employee_id <input type="number" name="employee_id" ><br>
	first_name  <input name="first_name" ><br>
	last_name   <input name="last_name" ><br>
	email       <input type="text" name="email"  >
				<button type="button" id="btnEmail">중복체크</button>
				<span id="emailResult"></span>
				<br>
	phone_number<input type="text" name="phone_number" ><br>
	hire_date   <input type="date" name="hire_date" ><br>
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
	job_id      <select name="job_id">
	 			 	<c:forEach items="${jobList }" var="job">
						<option value="${job.job_id }"
						<c:if test="${job.job_id==empVO.job_id }">selected="selected"</c:if>
						>${job.job_title }</option>
					</c:forEach>
				</select>
				<br>
	department_id	<c:forEach items="${deptList }" var="dept">
						<input type="radio" name="department_id" value="${dept.department_id }"
						<c:if test="${dept.department_id==empVO.department_id }">checked="checked"</c:if>
						>${dept.department_name }
			   		</c:forEach>
				<br>
	manager_id  
	<input type="text" name="manager_id">
	<input type="text" name="manager_name">
	<button type="button" id="btngetSearchEmp">사원검색</button><br>	
	<button type="submit">저장</button>
	<button type="reset">초기화</button><br/>
	<a href="getSearchEmp">목록으로</a>
</form>
</body>
</html>
