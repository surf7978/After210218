<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/emp/updateEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btngetSearchEmp").on("click", function(){
			window.open('getSearchEmp','emp','width=500, height=800');
		});
	});
	
	
	$(function(){
		$("#btngetProduct").on("click", function(){
			var product_id = $("[name=product_id1]").val();
				console.log(product_id);
			$.ajax({
    			url : "/temp/getProduct", //이렇게 적어도 됨
      			method : 'post',
      			data: JSON.stringify({product_id : product_id}),
      			contentType:'application/json;charset=utf-8',
				dataType : "json", 
				success : function(response){
					console.log(response);
					var getProduct = window.open('./getEmp','emp','width=500, height=800'); //여기 emp는 걍 창이름임...
					getProduct.write();
				},
				error:function(xhr,status,msg){
					console.log("상태값 : "+status+", Http에러메세지 : "+msg);
				}
      		})
		});
	});
	
	$(function(){
		$("#btninsertProduct").on("click", function(){
			var product_id = $("[name=product_id2]").val();
			var sale_qty   = $("[name=sale_qty]").val();
			var member_id  = $("[name=member_id1]").val();
	  		var sale_seq   = $("[name=sale_seq]").val();
	  		$.ajax({
		  		url : "/temp/insertProduct",
				data : JSON.stringify({
							product_id : product_id
							, sale_qty:sale_qty
							, member_id:member_id
							, sale_seq:sale_seq
						}), 
		  		method : 'post',
		  		contentType:'application/json;charset=utf-8', //보낼때는 contentType, 받을때는 contextType
				dataType : "json",
				success : function(response){
					console.log(response); 
				},
				error:function(xhr,status,msg){
					console.log("상태값 : "+status+", Http에러메세지 : "+msg);
				}
		  	})
		});
	});
	
</script>
<style>
	.error{color:red;}
</style>
</head>
<body>
<!-- 
<h3 id="top">입력</h3>
<form:form modelAttribute="empVO" action="insertEmp" method="post" name="frm">
	product_id <form:input path="product_id" /><form:errors path="product_id" cssClass="error"/><br>
	product_name  <form:input path="product_name" /><form:errors path="product_name" cssClass="error"/><br>
	product_price  <form:input path="product_price" /><form:errors path="product_price" cssClass="error"/><br>
	product_info<form:input type="text" path="product_info" /><br><form:errors path="product_info" cssClass="error"/>
	product_date   <form:input type="text" path="product_date" /><form:errors path="product_date" cssClass="error"/><br>
	company   <form:input type="text" path="company" /><form:errors path="company" cssClass="error"/><br>
	manager_id   <form:input type="text" path="manager_id" /><form:errors path="manager_id" cssClass="error"/><br>
	<button type="submit">저장</button>
	<button type="reset">초기화</button><br/>
</form:form>
 -->
	<button type="button" id="btngetSearchEmp">전체조회</button><br>	
	product_id <input name="product_id1"><br>
	<button type="button" id="btngetProduct">선택조회</button><br>	
	product_id <input name="product_id2"><br>
	sale_qty <input name="sale_qty"><br>
	manager_id <input name="member_id1"><br>
	sale_seq <input name="sale_seq"><br>
	<button type="button" id="btninsertProduct">입력</button><br>	
</body>
</html>
