<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBalance.jsp</title>
</head>
<body>
<table border="1">
		<tr>
			<td>${balance.api_tran_id }</td>
			<td>${balance.api_tran_dtm }</td>
			<td>${balance.rsp_code }</td>
			<td>${balance.rsp_message }</td>
			<td>${balance.bank_tran_id }</td>
			<td>${balance.bank_tran_date }</td>
			<td>${balance.bank_code_tran }</td>
			<td>${balance.bank_rsp_code }</td>
			<td>${balance.bank_rsp_message }</td>
			<td>${balance.bank_name }</td>
			<td>${balance.savings_bank_name }</td>
			<td>${balance.fintech_use_num }</td>
			<td>${balance.balance_amt }</td>
			<td>${balance.available_amt }</td>
			<td>${balance.account_type }</td>
			<td>${balance.product_name }</td>
			<td>${balance.account_issue_date }</td>
			<td>${balance.maturity_date }</td>
			<td>${balance.last_tran_date }</td>
		</tr> 
</table>
</body>
</html>