<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show2.jsp</title>
</head>
<body>
<button type="button" id="btn">숨기기</button>
<div id="info">jquery 영화정보.....</div>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
	$("#btn").click(function(){
		$("#info").toggle();
	})
</script>
</body>
</html>