<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/get.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
</script>
</head>
<body>
	<input id="userid" name="userid" placeholder="userid"><br/>
	<select name="job">
		<option value="d">디자이너
		<option value="p">프로그래머
	</select>
	<input type="checkbox" name="hobby" value="read" checked="checked">독서
	<input type="checkbox" name="hobby" value="ski">스키
	<div class="good" data-num="g1" data-name="상품1">상품1</div>
	<div class="good" data-num="g2" data-name="상품2">상품2</div>
</body>
</html>