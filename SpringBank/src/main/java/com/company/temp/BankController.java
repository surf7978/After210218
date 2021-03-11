package com.company.temp;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.common.BankAPI;
import com.company.common.BankVO;

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
		HashMap<String, Object> access_token = bankAPI.getAccessToken(code);
		System.out.println("access_token 값은 : "+access_token);
		
		//session에 저장
		session.setAttribute("access_token", access_token);
		
		return "home";
	}
	
	@RequestMapping("/getAccountList")
	public String userInfo(
							//HttpSession session
							Model model
							, HttpServletRequest request
						  ) {
		//String access_token = (String) session.getAttribute("access_token");
		
		String access_token = 
								//(String) request.getParameter("access_token"); 
								"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzcwNTMwIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MjMxOTg3MjYsImp0aSI6IjliZTE4YzcyLWVlMTQtNDA0YS1hYTgyLTFjZDgxYTc1NDNmMiJ9.a7M8AbgKlhRNc7qcJhWHva2UaN2J9sAwd_H4kKURiiQ"; 
		String use_num = 
							
							"1100770530";
		Map<String, Object> map = bankAPI.getAccountList(access_token, use_num);
		System.out.println("getAccountList 값은 : "+map);
		model.addAttribute("list", map);
		
		return "bank/getAccountList";
	}
	
	@RequestMapping("/getBalance")
	public String getBalance(
							BankVO vo
							, Model model 
							) {
		String access_token = 
								//(String) request.getParameter("access_token"); 
								"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzcwNTMwIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MjMxOTg3MjYsImp0aSI6IjliZTE4YzcyLWVlMTQtNDA0YS1hYTgyLTFjZDgxYTc1NDNmMiJ9.a7M8AbgKlhRNc7qcJhWHva2UaN2J9sAwd_H4kKURiiQ";
		Map<String, Object> map = bankAPI.getBalance(vo, access_token);
		System.out.println("잔액="+map);
		model.addAttribute("balance", map);
		return "bank/getBalance";
	}
	
	@ResponseBody
	@RequestMapping("/ajaxGetBalance")
	public Map<String, Object> ajaxGetBalance(BankVO vo) {
		String access_token = 
				//(String) request.getParameter("access_token"); 
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzcwNTMwIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MjMxOTg3MjYsImp0aSI6IjliZTE4YzcyLWVlMTQtNDA0YS1hYTgyLTFjZDgxYTc1NDNmMiJ9.a7M8AbgKlhRNc7qcJhWHva2UaN2J9sAwd_H4kKURiiQ";
		Map<String, Object> map = bankAPI.getBalance(vo, access_token);
		return map;
	}
	
	@RequestMapping("/getOrgAuthorize")
	public String getOrgAuthorize() {
		Map<String, Object> map = bankAPI.getOrgAuthorize();
		System.out.println("access_token 값은 : "+map.get("access_token"));
		//결과 access_token 값은 : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMTExNjg1Iiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjIzMjIzOTg5LCJqdGkiOiJiOTZmNmY2My04N2FlLTQ5NTAtYjBiNC1mY2QwMjA2OGJjZjQifQ.2R5aMex2iyJ8dT46VPCl7vxKvk-ewMS4cpTyjFpuNoE
		return "home";
	}
}
