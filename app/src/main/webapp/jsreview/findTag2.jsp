<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function calc1(){
		var table = document.getElementById("tbl1");
		/*
		var trs = table.getElementsByTagName("tr");
		var total = 0;
		for(i=0; i<trs.length; i++) {
			var score = trs[i].getElementsByTagName("td")[0].innerText;
			console.log(score);
			if(score.trim() != ""){ //합계란에 &nbsp; 있어서 trim으로 잘라내야함
				total += parseInt(score);
			}
		}
		console.log(total);
		trs[trs.length-1].getElementsByTagName("td")[0].innerText = total;
		*/
		var sum = 0;
		for(i=0; i<table.rows.length-1; i++){
			var score = table.rows[i].cells[0].innerText;
			sum += parseInt(score);
		}
		table.rows[table.rows.length-1].cells[0].innerText = sum;
	}
	
	function calc2(){
		var table = document.getElementById("tbl2");
		var trs = table.getElementsByTagName("tr");
		var total = 0;
		for(i=0; i<trs.length-1; i++) {
			var score = trs[i].getElementsByTagName("td")[1].innerText;
			console.log(score);
			total += parseInt(score);
		}
		console.log(total);
		trs[trs.length-1].getElementsByTagName("td")[1].innerText = total;
	}
</script>
</head>
<body>
<button type="button" onclick="calc1()">계산</button>
<table id="tbl1" border="1">
<tbody >
	<tr><td>100</td></tr>
	<tr><td>90</td></tr>
	<tr><td>80</td></tr>
	<tr><td>100</td></tr>
	<tr><td>&nbsp;</td></tr>
</tbody>	
</table>
<button type="button" onclick="calc2()">계산</button>
<table id="tbl2" border="1">
	<tr><td>홍길동</td><td>100</td></tr>
	<tr><td>김기자</td><td>90</td></tr>
	<tr><td>이순신</td><td>80</td></tr>
	<tr><td>총점</td><td>&nbsp;</td></tr>
</table>
</body>
</html>