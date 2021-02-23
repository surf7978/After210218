<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>event1.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<button type="button" id="btnAdd">추가</button>
	<ul id="result">
		<li>스프링</li>		
	</ul>
<script>
//더 줄일 수 있음
$(function(){ //document ready
	$("#btnAdd").on("click", function(){
		$("#result").append($("<li>").html("jsp")
									 .css("background","gold")
									 .attr("id","book")
									 .prop("alt","text")
									 .data("num","10")
									 );
	});
	//$("li").bind("click", function(){//이렇게하면 body에 적힌것만 적용됨
	$("ul").bind("click","li", function(){//이렇게해서 부모태그랑 그 밑에도 다 걸리게함=그룹이벤트(이벤트 부모태그에 위임함)
		//$(this).remove();
		$(event.target).remove();
		console.log(this)
	});
});

//jQuery로 바꿔 볼 예정
/*
$(document).bind("ready",function(){
	$("#btnAdd").bind("click", function(){
		$("#result").append($("<li>").html("jsp"));
	});
});
 */

/*
	document.getElementsByTagName("ul")[0].addEventListener("click",function(){
		//this.remove();
		event.target.parentNode.removeChild(event.target);
	});
	//페이지 로드 이벤트
	window.addEventListener("load", function(){
		document.getElementById("btnAdd").addEventListener("click", function(){
			//li태그 생성
			var li = document.createElement("li");
			li.innerHTML="자바";
			document.getElementById("result").appendChild(li);
		});
		
		
	});
 */
</script>
</body>
</html>