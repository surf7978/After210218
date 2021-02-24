<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl.jsp</title>
</head>
<body>
<c:forTokens items="s,r,a" delims="," var="hobby">
	${hobby } <br/>
</c:forTokens>

<!--
	이것과 같은 EL문 만들어보기 
	int sum=0;
	for(int i=0; i<10; i+=2){
		sum+=i;
	}
	out.print(sum);
 -->
<c:set var="sum" value="0"/>
${sum } <br/>
<c:forEach var="i" begin="0" end="10" step="2">
	<c:set var="sum" value="${sum+i }"/>
</c:forEach>
${sum }
</body>
</html>