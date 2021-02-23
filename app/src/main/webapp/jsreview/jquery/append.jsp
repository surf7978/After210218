<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{margin:10px; padding:20px; border:1px solid black;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#choose").prepend($("#banana")) //종속하는데 앞으로 붙임
		$("#apple").before($("#kiwi")) //같은 형제 노드의 경우 before, after써야 앞뒤로 붙이기 가능
		$("#choose").append($("#apple").clone()) //.clone()복제함
	})
</script>
</head>
<body>
	<div id="bucket">
		<div id="apple">사과</div>	
		<div id="banana">바나나</div>
		<div id="kiwi">키위</div>
	</div>
	<div id="choose"></div>
</body>
</html>