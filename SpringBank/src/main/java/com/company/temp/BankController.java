package com.company.temp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.common.BankAPI;

@Controller
public class BankController {
	
	@Autowired BankAPI bankAPI;
	
	@RequestMapping("/auth")
	public String auth() throws Exception {
		String reqURL = "https://testapi.openbanking.or.kr/oauth/2.0/authorize_account";
		String response_type = "code";
		String client_id = "cc16bd49-236f-4f63-9e08-c2a54ddcad24";
		String redirect_uri = "http://localhost/temp/callback";
		String scope = "login inquiry transfer";
		String state = "01234567890123456789012345678901";
		String auth_type = "0";
		
		StringBuilder qstr = new StringBuilder();
		qstr.append("response_type="+response_type)
			.append("&client_id="+client_id)
			.append("&redirect_uri="+redirect_uri)
			.append("&scope="+scope)
			.append("&state="+state)
			.append("&auth_type="+auth_type);
		return "redirect:"+reqURL+"?"+qstr.toString();
	}
	
	@RequestMapping("/callback")
	public String callback(@RequestParam Map<String, Object> map, HttpSession session) {
		
		String code = (String) map.get("code");
		System.out.println("code 값은 : " + code);
		//access_token 받기
		String access_token = bankAPI.getAccessToken(code);
		System.out.println("access_token 값은 : "+access_token);
		
		//session에 저장
		session.setAttribute("access_token", access_token);
		
		
		return "home";
	}
	
	@RequestMapping("/userInfo")
	public String userInfo(HttpSession session, HttpServletRequest request) {
		//String access_token = (String) session.getAttribute("access_token");
		
		String access_token = (String) request.getParameter("access_token");
		String use_num = "1100770530";
		Map<String, Object> userInfo = bankAPI.getUserInfo(access_token, use_num);
		System.out.println("userInfo 값은 : "+userInfo);
		
		return "home";
	}
	
}
