<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
<script>
	function validateForm() {
		var x = document.forms["myForm"]["fname"].value;
		if (x == "") {
			alert("Name must be filled out");
			return false;
		}
		//value, selectedIndex
		var x = document.forms["myForm"]["job"].value;
		var x = document.forms[0].elements["job"].value;
		var x = document.getElementsByName("job")[0].value;
		var x = document.myForm.job.value;//제일많이씀
		if(x == "") {
			alert("job must be select");
			return false;
		}
		var x = document.myForm.job.selectedIndex;
		if(x <= 0) { //아무것도 선택안하면 -1임
			alert("job must be select");
			return false;
		}
		//체크박스 과제
		for(var i=0; i<document.myForm.hobby.length; i++){
			if (document.myForm.hobby[i].checked != 'true'){
				alert("hobby must be check");
				return false;
			}
		}
		document.forms["myForm"].submit();
	}
</script>
</head>
<body>
	<form name="myForm" action="action_page.jsp" method="post">
		Name: <input type="text" name="fname" value="hong"> <br>
		
		<select name="job">
			<option value="">선택</option>
			<option value="dgn">디자니어</option>
			<option value="pgm">프로그래머</option>
		</select><br>
		취미
		<input type="checkbox" name="hobby" value="read">독서
		<input type="checkbox" name="hobby" value="jog">달리기<br>
		
		<button type="button" onclick="validateForm()">등록</button>
	</form>
</body>
</html>