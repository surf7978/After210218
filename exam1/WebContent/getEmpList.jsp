﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
   <head>
      <title>JSTL sql:query Tag</title>
      <style>
      	th { min-width: 160px;}
      </style>
      <script src="./scripts/jquery-3.2.1.min.js"></script>
      <script>      
      	function makeData(){
      		let list = [];
      		
			//체크한 행만 전송할 데이터 만들기. 은행계좌가 입력된 경우만 포함함.
      		$("[name='selId']:checked").each(function(i, checkbox){
      			var tr = $(checkbox).parent().parent();
				var td = $(tr).children();
				var obj = {};
				
				var employee_id = td.eq(1).text();
				var bankAcct    = td.eq(6).find("input").val();
				var salary      = td.eq(3).text();
				var commission  = td.eq(4).text();
				if(commission==null || commission=="" || commission=="NaN" || commission==0){ //걍 모르겠으면 조건 다 적어주면 편함
					commission = 0;// 급여
				}
				//은행계좌가 없으면 skip
				if(bankAcct == '') {
					return;
				}
				//객체에 담기
				//obj["slipAmount"] = parseFloat(salary)+parseFloat(commission);// 급여 + 상여금
				obj["slipAmount"] = salary*1+commission*1;// *1하면 자동으로 숫자형으로 바뀜
				obj["salDt"] = '202103';         // 급여년월 (현재년월)
				obj["customer"] = employee_id;   // 사번_이름
				obj["bankAcct"] = bankAcct;      // 은행계좌
				
				//목록에 담기
				list.push(obj);
      		});
		
			//객체를 string으로 변환
      		console.log(JSON.stringify(list)); //이게 보낼 데이터임

      		//ajax 호출 
      		$.ajax({
      			//url : "http://localhost/exam/insertSlip",
      			//url : "/exam/insertSlip", //이렇게 적어도 됨
      			
      			//url : "http://192.168.0.83/exam/insertSlip", //blocked by CORS policy에러뜸 = ajax는 다른 도메인에 요청 불가능 +저쪽에서 ajax되게 jsoup 처리해주면 가능
      			//도메인 다를경우 servlet으로 하면 됨
      			url : "insertSlip", //servlet으로 보낼 때는 servlet안에 적은 명칭으로
				//data : JSON.stringify(list), 
				data : {param :JSON.stringify(list)}, //servlet으로 보낼때는 이렇게
				
      			method : 'post',
      			
      			//servlet으로 할 때는 contentType json으로 넘겨주면안됨
      			//contentType:'application/json;charset=utf-8', //보낼때는 contentType, 받을때는 contextType
				dataType : "json", //json으로 받겠다
				
				success : function(response){
					console.log(response.cnt); //cnt = exam2의 Map에 있는 key값
				},
				error:function(xhr,status,msg){
					console.log("상태값 : "+status+", Http에러메세지 : "+msg);
				}
      		})
      	}
      </script>
   </head>

   <body>
	<!-- 데이터조회 시작 -->
      <sql:setDataSource var = "snapshot" driver = "oracle.jdbc.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:xe"
         user = "hr"  password = "hr"/>

         <sql:query dataSource = "${snapshot}" var = "result">
            SELECT e.*, round(salary*commission_pct, 2) as commission, d.department_name 
              FROM Employees e, departments d 
             WHERE e.department_id =d.department_id 
--               AND commission_pct>0
             ORDER BY first_name  
         </sql:query>
	<!-- 데이터조회 끝--> 
	
      <button type="button" id="" onclick="makeData()">급여신청</button>
      <!-- 목록 시작  -->
      <table border = "1" width = "40%">
         <tr>
         	<th><input type="checkbox" id="chkAll"></th>
            <th>Employee_id</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Commission</th>            
            <th>Deaprtment</th>
            <th>bank</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}"> 
            <tr>
               <td align="center"><input type="checkbox" name="selId"></td>
               <td align="center"><c:out value = "${row.employee_id}"/></td>
               <td><c:out value = "${row.first_name} ${row.last_name}"/></td>
               <td align="right"><c:out value = "${row.salary}"/></td>
               <td align="right"><c:out value = "${row.commission}"/></td>
               <td align="center"><c:out value = "${row.department_name}"/></td>
               <td><input type="text" name="bank"></td>
            </tr>
         </c:forEach>
      </table>
      <!-- 목록 끝  -->
   </body>
</html>