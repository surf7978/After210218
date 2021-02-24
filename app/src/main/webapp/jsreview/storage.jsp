<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>storage.jsp</title>
</head>
<body>
<script>
	function save(){
		localStorage.setItem("name", "John Doe")
	}
	function del(){
		localStorage.removeItem("name")
	}
</script>
	<button type="button" onclick="save()">저장</button>
	<button type="button" onclick="del()">삭제</button>
	스토리지에 저장
	<a href="../index.jsp">index로 이동</a>
</body>
</html>