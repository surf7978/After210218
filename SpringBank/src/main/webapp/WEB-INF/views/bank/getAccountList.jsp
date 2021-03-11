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
			<td><a href="ajaxGetBalance">${bank.fintech_use_num }</a></td>
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
<div id="result">
</div>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
	function getBalance(fin){
		location.href="getBalance?fintech_use_num="+fin;
	}
	//ajax호출로 만들기 ajaxGetBalance
</script>
</body>
</html>