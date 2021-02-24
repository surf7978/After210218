<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>JSTL sql:query Tag</title>
</head>
<body>
 
<sql:setDataSource var="ds" dataSource="jdbc/myoracle"/>

<sql:query dataSource="${ds }" var="result">
SELECT * from Employees;
</sql:query>
 
<table border="1" width="100%">
<tr>
<th>Emp ID</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td>${row.employee_id}</td>
<td>${row.first_name}</td>
<td>${row.last_name}</td>
</tr>
</c:forEach>
</table>

</body>
</html>