package com.company.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.common.MovieAPI;

@Controller
public class MovieController {
	
	@Autowired MovieAPI movieAPI;
	
	@RequestMapping("/boxOffice")
	@ResponseBody
	public List<String> boxOffice() {
		List<String> list = new ArrayList<>();
		Map map = movieAPI.getBoxOffice();
		//boxOfficeResult(Map타입)의 dailyBoxOfficeList 안에 배열[]들을 가져와야함
		Map boxOfficeResult = (Map) map.get("boxOfficeResult");
		List<Map> dailyBoxOfficeList = (List<Map>) boxOfficeResult.get("dailyBoxOfficeList");
		for(Map movie : dailyBoxOfficeList ) {
			list.add((String)movie.get("movieNm")+" : "+(String)movie.get("movieCd"));
		}
		return list;
	}
	
	@RequestMapping("/movieActor")
	@ResponseBody
	public List<String> movieActor(String MovieCd) {
		List<String> list = new ArrayList<>();
		MovieCd = "20200703";
		Map map = movieAPI.getMovieInfo(MovieCd);
		Map movieInfoResult = (Map) map.get("movieInfoResult");
		Map movieInfo = (Map) movieInfoResult.get("movieInfo");
		List<Map> actors = (List<Map>) movieInfo.get("actors");
		for(Map actor : actors ) {
			list.add((String)actor.get("peopleNm")+"("+(String)actor.get("peopleNmEn")+")");
		}
		return list;
	}
}
