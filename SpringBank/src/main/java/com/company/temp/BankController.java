package com.company.temp;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankController {
	@RequestMapping("auth")
	public void auth() {
		String reqURL = "https://openapi.openbanking.or.kr/oauth/2.0/authorize";
		String param = "?response_type="
					  +"&client_id="
					  +"&redirect_uri="
					  +"&scope="
					  +"&state="
					  +"&auth_type="
					  +"&lang="
					  +"&cellphone_cert_yn="
					  +"&authorized_cert_yn="
					  +"&account_hold_auth_yn=";
		URL url = new URL(reqURL+param);
		HttpURLConnection conn =(HttpURLConnection) url.openConnection();
					  
					  
	}
}
