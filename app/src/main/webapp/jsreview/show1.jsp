<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show1.jsp</title>
</head>
<body>
<button type="button" id="btn">숨기기</button>
<div id="info">js 영화정보.....</div>
<script>
	btn.onclick=function(){
		var st = info.style.display;
		if(st == 'none'){
			info.style.display='';
		}else{
			info.style.display='none';
		}
	}
</script>
</body>
</html>