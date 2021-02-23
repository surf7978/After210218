<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$(".btn").on("click", function(){
			alert($(this).closest("div").children().first().html());
			alert($(this).closest("div").children().eq(1).html());
			alert($(this).closest("div span").children().last().html());
			alert($(this).closest("div").find("span:eq(1)").html());
			alert($(this).parent().prev().html());
		});
	});
</script>
</head>
<body>
	<div>
		<span>1</span>
		<span>상품1</span>
		<span><button type="button" class="btn">선택</button></span>
	</div>
	<div>
		<span>2</span>
		<span>상품2</span>
		<span><button type="button" class="btn">선택</button></span>
	</div>
	<div>
		<span>3</span>
		<span>상품3</span>
		<span><button type="button" class="btn">선택</button></span>
	</div>
</body>
</html>