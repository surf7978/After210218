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
	
	//부서정보를 저장
	var depts = [ //
			{ //
			department_id:10 //
			, department_name:"Administration" //
			, managet_id:200 //
			, location_id:1700 //
			}, //
			{ //
				department_id:20 //
				, department_name:"Marketing" //
				, managet_id:201 //
				, location_id:1800 //
			} //
				];
	
	var member = { name:"hong", hobbys:["독서", "달리기"]};
	//첫번째 취미 출력
	document.getElementById("result").innerHTML += "첫번째 취미 : "+ member.hobbys[0];
	
	var members = [
			{ name:"hong", hobbys:["독서", "달리기"]},
			{ name:"kang", hobbys:["스키", "음악"]},
				  ]
	//두번째 사람의 첫번째 취미 출력
	document.getElementById("result").innerHTML += "<br/>두번째 사람의 첫번째 취미 : "+ members[1].hobbys[0];
	
	//typeof = 타입확인 
	//+ JSON.stringify() = 다른 곳에 정보줄때 JSON구조의 스트링으로 변환해서 넘겨줌
	//+ JSON.parse(), 받은 정보 사용할때 다시 변환함

</script>
</body>
</html>