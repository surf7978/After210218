<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxjson.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$(function(){
			$("#btn1").on("click", function(){
				
				//1.post
				$.post("../../JsonServ", function(obj){
					//var obj = JSON.parse(response); //뒤에 "json" 타입 파싱해줘서 안적어도됨
					$("#demo").append(obj[0]);
				},
				"json"
				)	
				
				//2.ajax
				$.ajax({
					url : "../../JsonServ",
					success : function(obj){
						$("#demo").append("&nbsp;")
						$("#demo").append(obj[1]);
					},
					dataType : "json"
				});
				$("#demo").append("<hr/>")
			})
			
			$("#btn2").on("click", function(){
				
				//1.post
				$.post("../../FindServ", function(obj){
					//var obj = JSON.parse(response); //뒤에 "json" 타입 파싱해줘서 안적어도됨
					$("#demo").append(obj.name);
				},
				"json"
				)	
				
				//2.ajax
				$.ajax({
					url : "../../FindServ",
					success : function(obj){
						$("#demo").append("&nbsp;")
						$("#demo").append(obj.hobbys[0]);
						$("#demo").append("&nbsp;")
						$("#demo").append(obj.hobbys[1]);
					},
					dataType : "json"
				});
				$("#demo").append("<hr/>")
			})
		});
	</script>
</head>
<body>

	<button type="button" id="btn1">JsonServ</button>
	<button type="button" id="btn2">FindMember</button>
	<div id="demo">
		<h2>The XMLHttpRequest Object</h2>
	</div>

</body>
</html>