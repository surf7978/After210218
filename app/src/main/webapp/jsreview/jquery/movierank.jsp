<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movierank.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<button id="btn">박스오피스조회</button>
	<div id="rank"></div>
	<div id="info"></div>
<script>
	$(function(){
		//버튼 클릭하면 박스오피스 정보를 조회해서 영화제목과 영화코드를 div#rank에 출력
		$("#btn").on("click", function(){
			$.ajax({
					url : "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20210222",
					success : function(result){
						console.log(result.boxOfficeResult.dailyBoxOfficeList[0].movieNm)
						//$("#rank").append(result.boxOfficeResult.dailyBoxOfficeList[0].movieNm+"&nbsp;"+result.boxOfficeResult.dailyBoxOfficeList[0].movieCd)
						for(field of result.boxOfficeResult.dailyBoxOfficeList){
							$("#rank").append("<div id="+field.movieCd+">"+field.movieNm+"&nbsp;"+field.movieCd+"</div><br/>");
//							var cd = field.movieCd;
//							$("#"+cd+"\"").click(function(cd){
//								$.ajax({
//									url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+cd,
//									success : furnction(result){
//										console.log("인포성공");
//									},
//									dataType : "json"
//								});
//							});
						}
					},
					dataType : "json"
			});
		});
	});
</script>
</body>
</html>