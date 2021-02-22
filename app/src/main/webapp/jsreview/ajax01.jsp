<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input id="userid" value="admin">
	<button type="button" onclick="loadDoc()">Change Content</button>
	<div id="demo">
		<h2>The XMLHttpRequest Object</h2>
	</div>

	<script>
		//+AJAX = Async(비동기) JAvascript XML 이라는 뜻
		function loadDoc() {
			//1.XHR객체를 생성
			var xhttp = new XMLHttpRequest();
			
			//2.콜백함수 실행
			xhttp.onreadystatechange = function() {
				if(this.readyState < 4 ){
					document.getElementById("demo").innerHTML = "loading...";
				}else if (this.readyState == 4) {
					if(this.status == 200){
						document.getElementById("demo").innerHTML = this.responseText+"<br/>"; //responseXML도 있음
					}else{
						document.getElementById("demo").innerHTML = this.status+" error <br/>";
					}
				}
			};
			
			//3.요청준비(url 입력)
			//xhttp.open("GET", "../AjaxServ"); //true로하면 비동기 false이면 동기 = 동기식으로 하면 처리 끝나야 진행됨 +default : true임
			
			//3-1.get방식 출력
			var param = "userid="+document.getElementById("userid").value;
			//xhttp.open("GET", "../FindName?"+param);
			//3-2.post방식 출력
			xhttp.open("POST", "../FindName?"); 
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			
			//4.요청시작
			//4-1.get방식 출력
			//xhttp.send();
			//4-1.post방식 출력
			xhttp.send(param);
			document.getElementById("demo").innerHTML += "ajax send<br/>"; //sevlet에 지연시켜놔서 이게 먼저 뜸(단, 위에 false로 동기식으로 바꾸면 위에꺼 뜨고 이게 뜸)
		}
	</script>

</body>
</html>