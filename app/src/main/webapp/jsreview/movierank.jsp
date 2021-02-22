<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movierank.jsp</title>
</head>
<body>
	<button id="btn" onclick="loadMovie()">박스오피스조회</button>
	<div id="result"></div>
<script>
	function loadMovie(){
		var xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			// 결과 파싱해서(parse)
			var rank = JSON.parse(xhttp.responseText);
			//console.log(rank)
			var movieList = rank.boxOfficeResult.dailyBoxOfficeList;
			//console.log(movieList)
			
			//for문 사용 이름만 출력
			for(field of movieList){
				//console.log(field)
				document.getElementById("result").innerHTML += 
					"<div onclick=loadInfo('"+field.movieCd+"')>"
					+ field.movieNm+" : "+field.movieCd+"</div>";	
			}
		};
		var url="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20210221";
		xhttp.open("get", url);
		xhttp.send();
	}
	
	function loadInfo(e){
		var xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			// 결과 파싱해서(parse)
			var rank = JSON.parse(xhttp.responseText);
			console.log(rank)
			var movieList = rank.movieInfoResult.movieInfo;
			console.log(movieList)
			//for문 사용 이름만 출력
			for(field of movieList){
				console.log(field)
				document.getElementById("result").innerHTML += 
					"<div>"+ field.movieNm+" : "+field.movieCd+"</div>";	
			}
		};
		var url="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+e;
		xhttp.open("get", url);
		xhttp.send();
	}
</script>
</body>
</html>