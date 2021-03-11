package com.company.temp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/getBiz") //페이지이동
	public String getBizForm() {
		return "bank/getBiz";
	}
	@PostMapping("/getBiz") //크롤링결과 조회 후 이동
	public String getBiz(
						@RequestParam String bizno
						, Model model
						) throws Exception { //VO, Map, String중 하나로 받게하셈 +이 때 VO말고 딴거로 받을꺼면 변수명 jsp파일꺼랑 맞춰줘야하고 @RequestParam넣어줘야함
		//크롤링
		String url = "https://bizno.net/?query=" + bizno;
		Document doc = Jsoup.connect(url).get();
		Elements element = doc.select(".titles>a>h4"); //웹 콘솔에서 document.querySelector("");해서 찾아서 넣기
		String bizName = element.text();
		System.out.println(bizName);
		//회사명만 추출 후 리턴 +model에 저장
		model.addAttribute("bizName", bizName);
		return "bank/getBiz";
	}
}
