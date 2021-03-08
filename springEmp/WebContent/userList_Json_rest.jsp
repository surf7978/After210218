<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./resources/js/json.min.js"></script>
<script type="text/javascript" >
	$(function(){
		userList();

		userSelect();
		
		userDelete();
		
		userInsert();
	
		userUpdate();
		
		init();
	});
	
	//초기화
	function init() {
		//초기화 버튼 클릭
		$('#btnInit').on('click',function(){
			$('#form1').each(function(){
				this.reset();
			});
		});
	}//init
	
	//사용자 삭제 요청
	function userDelete() {
		//삭제 버튼 클릭
		$('body').on('click','#btnDelete',function(){
			if(! confirm('삭제할까요?')){ //이렇게 하면 간단하게 Y/N만듬
				return;
			}			
			var tr = $(this).closest('tr');
			var userId = $(this).closest('tr').find('#hidden_userId').val();
			$.ajax({
					url:'user/'+userId,
					method:'DELETE',
					dataType:'json',
					success:function(response){
						//userList(); 밑에처럼 하면 효율적임
						if(response.cnt == 1){ //cnt=com.yedam.emp.controller에 적어놓은 cnt임
							tr.remove();
						}else{
							alert('삭제오류');
						}
					}
				});
		}); //삭제 버튼 클릭
	}//userDelete
	
	//사용자 조회 요청
	function userSelect() {
		//조회 버튼 클릭
		$('body').on('click','#btnSelect',function(){ //$('#btnSelect').on('click',function(){ 이렇게 안한 이유 = 생성된거라 이렇게 못함
			var userId = $(this).closest('tr').find('#hidden_userId').val();
			$.ajax({
					url:'user/'+userId,
					method:'GET',
					contentType:'application/json;charset=utf-8',
					dataType:'json',
					success:function(data){
						userSelectResult(data);
					}
				});
		}); //조회 버튼 클릭
	}//userSelect
	
	//사용자 조회 응답
	function userSelectResult(user) {
		$('input:text[name="id"]').val(user.id);
		$('input:text[name="name"]').val(user.name);
		$('input:text[name="password"]').val(user.password);
		$('select[name="role"]').val(user.role).attr("selected", "selected");
	}//userSelectResult
	
	//사용자 수정 요청
	function userUpdate() {
		//수정 버튼 클릭
		$('#btnUpdate').on('click',function(){
			$.ajax({
					url:"user",
					method:"put",
					data:JSON.stringify($("#form1").serializeObject()),
					contentType:"application/json",
					dataType:"json",
					success:function(response){
							//폼필드 초기화
							document.form1.reset(); //이거해주면 폼에 적은 내용 없어짐 +name="form1" 찾아감
							
							//tr태그 수정된 데이터 교체하든지 아니면 전체조회
							var tr = makeTr(response);
							var oldTr = $("td:contains('"+response.id+"')").parent();
							oldTr.replaceWith(tr);
						}
			});
		});//수정 버튼 클릭
	}//userUpdate
	
	//사용자 등록 요청
	function userInsert(){
		//등록 버튼 클릭
		$('#btnInsert').on('click',function(){
//			var param = {
//							id : $("[name=id]").val()
//							, name : $("[name=name]").val()
//							, password : $("[name=password]").val()
//							, role : $("[name=role]").val()
//						};
 			$.ajax({
 				url : "user",
 				method : "post",
 				data : JSON.stringify($("#form1").serializeObject()), // JSON.stringify(param) 과 같음
 				contentType : 'application/json', //보낼데이터 json -> @requestBody
 				dataType : "json",				  //응답결과가 json -> JSON.parse()
 				success : function(response){
 					console.table(response);
 					document.form1.reset();
 					userList();
 				}
 			});
		});//등록 버튼 클릭
	}//userInsert
	
	//사용자 목록 조회 요청
	function userList() {
		$.ajax({
			url:'user',
			type:'GET',
			dataType:'json',
			error:function(xhr,status,msg){
				alert("상태값 :" + status + " Http에러메시지 :"+msg);
			},
			success:userListResult
		});
	}//userList
	
	//사용자 목록 조회 응답
	function userListResult(data) {
		$("tbody").empty();
		$.each(data,function(idx,item){
			var tr = makeTr(item);
			tr.appendTo("tbody");
		});//each
	}//userListResult
	
	function makeTr(item){
		return $('<tr>')
		.append($('<td>').html(item.id))
		.append($('<td>').html(item.name))
		.append($('<td>').html(item.password))
		.append($('<td>').html(item.role))
		.append($('<td>').html('<button id=\'btnSelect\'>조회</button>'))
		.append($('<td>').html('<button id=\'btnDelete\'>삭제</button>'))
		.append($('<input type=\'hidden\' id=\'hidden_userId\'>').val(item.id));
	}
</script>
</head>
<body>
<a href="../springEmp/">메인으로</a>
<div class="container">
	<form id="form1" name="form1" class="form-horizontal">
		<h2>사용자 등록 및 수정</h2>
		<div class="form-group">		
			<label >아이디:</label>
			<input type="text"  class="form-control" name="id" >
		</div>	
		<div class="form-group">
			<label>이름:</label>
			<input type="text"  class="form-control"  name="name" >
		</div>	
		<div class="form-group">
			<label>패스워드:</label>
			<input type="text"  class="form-control"  name="password" >
		</div>			
<!-- 		
		<div class="form-group">
			<label >성별:</label>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="남">남</label>
			</div>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="여">여</label>
			</div>	
		</div>	 
-->    
		<div class="form-group">   
			<label>역할:</label>
				<select class="form-control" name="role">
					   		<option value="Admin">관리자</option>
					   		<option value="User">사용자</option>
				</select>
		</div>  
		<div class="btn-group">      
				<input type="button"  class="btn btn-primary" value="등록"  id="btnInsert" /> 
				<input type="button"  class="btn btn-primary" value="수정"  id="btnUpdate" />
				<input type="button"  class="btn btn-primary" value="초기화" id="btnInit" />
		</div>
	</form>
</div>		
<hr/>		
<div class="container">	
	<h2>사용자 목록</h2>
	<table class="table text-center">
		<thead>
		<tr>
			<th class="text-center">아이디</th>
			<th class="text-center">이름</th>
			<th class="text-center">패스워드</th>
			<th class="text-center">역할</th>
		</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>	
</body>
</html>