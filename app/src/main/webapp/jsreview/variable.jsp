<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>variable.jsp</title>
<script>
	//"use strict";//무조건 변수 선언해야 사용되게 하는 JS명령문 
	v1=10; //전역변수
	function f1(){
		i1 = 10; //전역변수라 밑에 f2함수에도 찍힘
		{
			//var i1 = 10; //지역변수로 선언해도 밑에 콘솔에 찍힘
			//let i1 = 10; 
		}
		v1 = 20;
		console.log(i1); //let i1 하면 블럭변수라 안됨
	}
	
	function f2(){
		v1 = 30;
		console.log(i1); //지역변수로 선언 안해서 콘솔에 찍힘
	}
</script>
</head>
<body>

</body>
</html>