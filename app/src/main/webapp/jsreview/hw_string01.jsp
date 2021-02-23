<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>homework3_array.jsp</title></head>
<body>
<input type="text" id="userno">
<input type="text" id="username">
<input type="text" id="userId">
<input type="text" id="userRegDate">
<div id="result">1,홍길동,hong,2019/12/01</div>
<script>
	//div의 값을 콤마(,)로 분리하여 각각의 텍스트필드에 출력
	document.getElementById("userno").value= document.getElementById("result").innerHTML.substr(0,1);
	document.getElementById("username").value=document.getElementById("result").innerHTML.substr(2,3);
	document.getElementById("userId").value=document.getElementById("result").innerHTML.substr(6,4);
	document.getElementById("userRegDate").value=document.getElementById("result").innerHTML.substr(11,10);
</script>
</body>
</html>