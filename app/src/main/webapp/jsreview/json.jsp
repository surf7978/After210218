<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json.jsp</title>
</head>
<body>
<div id="result"></div>
<script>
	var emp = [
		{id:100, name:"scott", hiredate:"2020/01/01"},
		{id:101, name:"홍길동", hiredate:"2020/01/02"},
		{id:102, name:"김유신", hiredate:"2020/01/03"},
			  ]
	//사원의 이름을 div에 출력
	for(field of emp){
		document.getElementById("result").innerHTML += field.name+"<br/>";
	}
	
	var table = document.createElement("table");
	table.setAttribute("border", "1");
	result.append(table);
	for(field of emp){
		var tr = document.createElement("tr");
		for(fld in field){
			var td = document.createElement("td");
			td.setAttribute("style", "text-align:center");
			td.innerHTML = field[fld];
			tr.append(td);
		}
		table.append(tr);
	}
	
</script>
</body>
</html>