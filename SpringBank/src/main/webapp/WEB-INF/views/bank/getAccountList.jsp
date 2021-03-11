<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getAccountList.jsp</title>
</head>
<body>
<table border="1">
	<c:forEach items="${list.res_list }" var="bank">
		<tr>
			<td><a href="getBalance?fintech_use_num=${bank.fintech_use_num }">${bank.fintech_use_num }</a></td>
			<td><a href="#" onclick="getBalance('${bank.fintech_use_num }')">${bank.fintech_use_num }</a></td>
			<td><a class="btn" href="#">${bank.fintech_use_num }</a></td><!-- id로하면 최상위 1개만 됨 class로 해야됨 -->
			<td><a href="#" onclick="getBalance2('${bank.fintech_use_num }')">${bank.fintech_use_num }</a></td>
			<td>${bank.account_alias }</td>
			<td>${bank.bank_code_std }</td>
			<td>${bank.bank_code_sub }</td>
			<td>${bank.bank_name }</td>
			<td>${bank.account_num_masked }</td>
			<td>${bank.account_holder_name }</td>
			<td>${bank.account_holder_type }</td>
			<td>${bank.inquiry_agree_yn }</td>
			<td>${bank.inquiry_agree_dtime }</td>
			<td>${bank.transfer_agree_yn }</td>
			<td>${bank.transfer_agree_dtime }</td>
			<td>${bank.account_state }</td>
			<td>${bank.savings_bank_name }</td>
			<td>${bank.account_seq }</td>
			<td>${bank.account_type }</td>
		</tr> 
	</c:forEach>
</table>
<h3>ajax호출</h3>
<div id="result">
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function getBalance(fin){
		location.href="getBalance?fintech_use_num="+fin;
	}
	//ajax호출로 만들기 ajaxGetBalance
	$(".btn").on("click",function(){
		var fin = $(this).html();
		$.ajax({
				url : "ajaxGetBalance",
				data : {fintech_use_num : fin}, //"fintech_use_num="+fin 
				dataType : "json",
				success : function(response){
					$("#result").empty();
					$("#result").append("bank_name : "+response.bank_name+"<br>")
								.append("product_name : "+response.product_name+"<br>")
								.append("balance_amt : "+response.balance_amt+"<br>")
								.append("available_amt : "+response.available_amt+"<br>");
				}
		});				
	});
	
	function getBalance2(fin){
		$.ajax({
				url : "getBalance",
				data : {fintech_use_num : fin}, //"fintech_use_num="+fin 
				success : function(response){
					$("#result").html(response);
				}
		});				
	};
</script>
</body>
</html>