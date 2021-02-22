<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxjson.jsp</title>
</head>
<body>

	<button type="button" onclick="loadDoc()">Change Content</button>
	<div id="demo">
		<h2>The XMLHttpRequest Object</h2>
	</div>

	<script>
		function loadDoc() {
			var xhttp = new XMLHttpRequest();
			xhttp.onload = function() {
					var member = JSON.parse(this.responseText);
					for(i=0; i<member.hobbys.length; i++){
					document.getElementById("demo").innerHTML += member.hobbys[i]+" ";
					}
					document.getElementById("demo").innerHTML += "<br/>";
			};
			xhttp.onerror = function() {
				document.getElementById("demo").innerHTML += this.status+" error <br/>";
			};
			//xhttp.open("GET", "../JsonServ", true);
			xhttp.open("GET", "../FindServ", true);
			xhttp.send();
		}
	</script>

</body>
</html>