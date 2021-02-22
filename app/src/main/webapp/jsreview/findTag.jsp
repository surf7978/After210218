<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findTag.jsp</title>
<script>
	function toSm(){
		//현재 이미지의 크기를 확인
		var s = document.getElementById("img1").width;
		//var s = imgs[0].style.width;
		//slice(0,-2)로 "px" 빼도 됨
		//크기를 100을 빼서 크기지정
		var Sm = parseInt(s)-100;
		//모든 이미지의 크기를 100 감소
		//document.getElementById("img1").style.width = Sm+"px";
		//document.querySelector(".backimg").style.width= Sm+"px"; //첫번째꺼만 찾음
		//document.querySelectorAll(".backimg")[1].style.width= Sm+"px";
		for(var i=0; i<document.getElementsByTagName("img").length; i++){
			document.getElementsByTagName("img")[i].style.width= Sm+"px";
		}
	}
</script>
</head>
<body>
	<button type="button" onclick="toSm()">작게</button>
	<img id="img1" src="../images/Chrysanthemum.jpg" style="width:300px;">
	<img class="backimg" src="../images/Hydrangeas.jpg" style="width:350px;">
	<img class="backimg" src="../images/Jellyfish.jpg" style="width:400px;">
</body>
</html>