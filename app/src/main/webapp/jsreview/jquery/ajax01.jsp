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
			$("#btn").on("click",function(){
				var param = "userid="+$("#userid").val();
				var url = "../../FindName";
				
				//1.load 함수 사용
				/*
				$("#demo").load(url+"?"+param);	
				*/
				
				//2.get, post 함수 사용 get(url, [, date] [, success] [, dataType])
				/*
				param = { userid : $("#userid").val(), dept : "개발" }; // = ?userid=입력값&dept=개발 +jQruery일때는 이렇게 적어도됨
				$.post(url, param, function(response){
					$("#demo").append("post방식 : "+response); //append라서 덮어쓰기가 아니라 계속 추가됨
				});
				*/
				
				//3.ajax 함수 사용
				$.ajax(url, {
					async : true, //비동기 +false:동기
					success : function(response){
						$("#demo").append("ajax함수 : "+response);	
					},
					/*
					error : function(){
						
					},
					complete : function(){
						
					}
					*/
					data : param
				});				
			});
				
		});
	</script>
</head>
<body>
	<input id="userid">
	<button type="button" id="btn">Change Content</button>
	<div id="demo">
		<h2>The XMLHttpRequest Object</h2>
	</div>
</body>
</html>