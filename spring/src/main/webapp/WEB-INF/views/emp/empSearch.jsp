<%@page import="java.util.ArrayList" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/empSearch.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("btnSelect").click(function(){
			var empid = $(this).closest(".row").find("span").eq(0).html();
			console.log(empid)
			var firstName = $(this).closest(".row").find("span").eq(3).html();
			opener.document.frm.manager_id.value = empid;
			$(opener.document).find('[name=manager_name]').val(firstName);
			window.close();
		})
	})
	</script>
</head>
<body>
<c:forEach items="${list }" var="emp">  <!-- for(EmpVO emp : list) -->
	<div class="row">
		<span>${emp.employee_id }</span>
		<span>${emp.last_name }</span>
		<span>${emp.first_name }</span>
		<span>${emp.email }</span>
		<span>${emp.salary } </span>
		<span><fmt:formatDate value="${emp.hire_date }" pattern="yyyy-mm"/></span>
		<span><button type="button" class="btnSelect">선택</button></span>
	</div>
</c:forEach>
</body>
</html>