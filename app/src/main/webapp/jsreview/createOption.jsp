<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>createOption.jsp</title>
<script>
	function addFruit(){
		if(fruit.value != ""){
			//input tag의 값을 select의 option 태그 만들어서 추가
			var op = document.createElement("option");
			op.innerHTML = fruit.value;
			list.add(op);
		
			var table = document.getElementById("tbl");
			row = table.insertRow();
			cell = row.insertCell();
			cell.innerText = fruit.value;
			cell1 = row.insertCell();
			cell1.innerText = fruit.value;
			
			fruit.value="";
		}else{
			alert("값을 입력하세요");
		}
	}
</script>
</head>
<body>
<input id="fruit"><button type="button" onclick="addFruit()">등록</button><hr>
<select id="list" size="10"></select><hr>
<table id="tbl" border="1"></table>
</body>
</html>