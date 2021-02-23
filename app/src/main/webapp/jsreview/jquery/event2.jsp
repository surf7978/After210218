<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>event2.jsp</title>
</head>
<body>
	<div id="result">event test</div>
<script>
	//result.onclick=function(){}
	result.addEventListener("click", function(){
		alert(this.innerHTML);
	});
	result.addEventListener("click", function(){
		alert("click!!");
	});
</script>
</body>
</html>