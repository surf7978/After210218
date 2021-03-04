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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$(".btnSelect").on("click",function(){
			var empid = $(this).closest(".row").find("span").eq(0).html();
			console.log(empid)
			var firstName = $(this).closest(".row").find("span").eq(2).html();
			opener.document.frm.manager_id.value = empid;
			$(opener.document).find('[name=manager_name]').val(firstName);
			window.close();
		})
	})
</script>
</head>
<body>
<h3>사원목록</h3>
<form action="getSearchEmp" name="searchFrm">
	<input type="hidden" name="page" value="1">
	DEPARTMENT_ID <input name="department_id" value="${empSearchVO.department_id }"><br>
	JOB_ID <input name="job_id" value="${empSearchVO.job_id }"><br>
	FIRST_NAME <input name="first_name" value="${empSearchVO.first_name }"><br>
	<button>검색</button>
</form>
<div class="row" style="font-size:20px;">
		<span style="color:red;">ID</span>
		<span>NAME(L/F)</span>
		<span>EMAIL</span>
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
		<span style="color:red;">${emp.employee_id }</span>
		<a href="getEmp?employee_id=${emp.employee_id }">${emp.last_name } ${emp.first_name }</a>
		<span>${emp.email }</span>
		<span>${emp.salary } </span>
		<span><fmt:formatDate value="${emp.hire_date }" pattern="yyyy-MM"/></span>
		<br>
		<span style="color:red;">${emp.department_id }</span>
		<span style="color:blue;">${emp.department_name }</span>
		<br>
		<span style="color:red;">${emp.job_id }</span>
		<span style="color:green;">${emp.job_title }</span>
		<br>
		<span><button type="button" class="btnSelect">선택</button></span>
		<hr>
	</div>
</c:forEach>
<my:paging paging="${paging }" jsFunc="goPage" />
<script>
	function goPage(p){
		//location.href="getSearchEmp?page="+p;
		searchFrm.page.value=p;
		searchFrm.submit();
	}
</script>
<a href="insertEmp">사원추가</a>
<a href="../springEmp/">메인으로</a>
</body>
</html>