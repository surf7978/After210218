<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div { display: inline-block; 
	width : 100px; 
	height: 100px;
	border: 1px solid black; }
</style>

</head>
<body>
<script>
	for(i=0; i<10; i++) {
		var div = document.createElement("div");
		div.innerHTML = i;
		div.onclick = clickHandler
		document.body.appendChild(div);
	}
	function clickHandler(e) {
		console.log(e.target.innerHTML, '클릭됨')
		var len = document.getElementsByTagName("div").length;
		console.log(len, '개');
		this.remove();
		if(len==1){
			console.log('div 전부 제거');
		}
	}
	//클릭 된 태그 삭제하고 모두 제거됬으면 다 제거됬다고 콘솔에 출력되게 하기 
</script>
</body>
</html>