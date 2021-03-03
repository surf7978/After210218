<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<c:forEach items="${list }" var="emp">
	<div class="row">
	<span>${emp.employee_id }</span>
	<a href="getEmp?employee_id=${emp.employee_id }">
	${emp.last_name }${emp.first_name }</a>
	<span>${emp.email }</span>
	<span>${emp.salary } </span>
	<span><fmt:formatDate value="${emp.hire_date }" pattern="yyyy-mm"/></span>
	<span><button type="button" class="btnSelect">선택</button></span>
	</div>
</c:forEach>
</body>
</html>