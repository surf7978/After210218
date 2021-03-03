<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/dept/getDept.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
<h3>${dept.department_name }부서정보</h3>
	부서번호 : ${dept.deptloyee_id }<br />
	부서명 : ${dept.department_name}}<br />
	관리자번호 : ${dept.manager_id }<br />
	지역번호 : ${dept.location_id } <br />
	<a href="getSearchDept">목록으로</a>
</body>
</html>