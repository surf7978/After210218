package com.company.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Component
public class BankAPI {

	String host = "https://testapi.openbanking.or.kr";
	String client_id = "cc16bd49-236f-4f63-9e08-c2a54ddcad24";
	String client_secret = "beb1d02a-86b6-4be2-be9d-2f38e4da6c10";
	String redirect_uri = "http://localhost/temp/callback";
	String use_org_code = "M202111685";
	String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMTExNjg1Iiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjIzMzA2NDg3LCJqdGkiOiJhMWUyODdiMy1hMmFhLTQ5YzEtYmVjNi0wOGU3ZWE4MTUyYTYifQ.u7LJLTQAJDFYNawsKxYUBri-Cd6yKsejXFNcoC69PPU";

	public HashMap<String, Object> getAccessToken(String authorize_code) {
		HashMap<String, Object> access = new HashMap<>();
		String access_token = "";
		String refresh_Token = "";
		String user_seq_no = "";
		String reqURL = host + "/oauth/2.0/token"; // 여기 바꿀것

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // url요청해서 url 받아오는 것??
																				// HttpURLConnection는 자바에서 제공하는 것.

			// POST 요청을 하려면 기본값이 false인 setDoOutput을 true로 설정해야 한다.
			conn.setRequestMethod("POST"); // HEADER+BODY 파라미터값
			conn.setDoOutput(true); // BODY가 있다고 알려주는?

			StringBuilder sb = new StringBuilder();
			sb.append("code=" + authorize_code); // pdf에서 지정해준 다섯개의 파라미터로 바꿀 것.
			sb.append("&client_id=" + client_id);
			sb.append("&client_secret=" + client_secret);
			sb.append("&redirect_uri=" + redirect_uri);
			sb.append("&grant_type=authorization_code");

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			OutputStream os = conn.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));// 자바교재2권 1021쪽에 설명

			bw.write(sb.toString());
			bw.flush();
			bw.close();

			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}

			System.out.println("response body : " + result);

			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			access_token = element.getAsJsonObject().get("access_token").getAsString(); // 토큰 넘겨받음
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
			user_seq_no = element.getAsJsonObject().get("user_seq_no").getAsString();

			access.put("access_token", access_token);
			access.put("refresh_Token", refresh_Token);
			access.put("user_seq_no", user_seq_no);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return access;
	} // end of getAccessToken

	// 카카오 정보 get
	public HashMap<String, Object> getAccountList(String access_token, String use_num) {

		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> map = new HashMap<>();
		String reqURL = host+"/v2.0/account/list"; // get방식이면 url 뒤에 붙는다.
		StringBuilder qstr = new StringBuilder();
		qstr.append("user_seq_no=" + use_num)
			.append("&include_cancel_yn=Y")
			.append("&sort_order=D");

		try {
			URL url = new URL(reqURL + "?" + qstr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_token);

			// 출력되는 값이 200이면 정상작동
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			
			//String 맵에 담기
			Gson gson = new Gson();
			map = gson.fromJson(result, HashMap.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public String getDate() {
		String str = "";
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		str = format.format(date);
		return str;
	}
	
	public String getRand() { //9자리 난수값 만들기
		long time = System.currentTimeMillis();
		String str = Long.toString(time);
		return str.substring(str.length()-9);//13자리(str.length())중 9자리수부터 자름
	}
	
	public String getRand32() { //32byte 난수 만들기\
		
		return "";
	}
	
	public HashMap<String, Object> getBalance(BankVO vo, String access_token) {
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
				HashMap<String, Object> map = new HashMap<>();
				String reqURL = host+"/v2.0/account/balance/fin_num"; // get방식이면 url 뒤에 붙는다.
				StringBuilder qstr = new StringBuilder();
				qstr.append("bank_tran_id=").append(use_org_code+"U"+getRand())
					.append("&fintech_use_num=").append(vo.fintech_use_num)
					.append("&tran_dtime=").append(getDate());

				try {
					URL url = new URL(reqURL + "?" + qstr);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");

					// 요청에 필요한 Header에 포함될 내용
					conn.setRequestProperty("Authorization", "Bearer " + access_token);

					// 출력되는 값이 200이면 정상작동
					int responseCode = conn.getResponseCode();
					System.out.println("responseCode : " + responseCode);

					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

					String line = "";
					String result = "";

					while ((line = br.readLine()) != null) {
						result += line;
					}
					System.out.println("response body : " + result);
					
					//String 맵에 담기
					Gson gson = new Gson();
					map = gson.fromJson(result, HashMap.class);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return map;
	}
	
	public HashMap<String, Object> getOrgAuthorize() {
		HashMap<String, Object> map = new HashMap<>();
		String reqURL = host + "/oauth/2.0/token"; // 여기 바꿀것

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // url요청해서 url 받아오는 것??
																				// HttpURLConnection는 자바에서 제공하는 것.

			// POST 요청을 하려면 기본값이 false인 setDoOutput을 true로 설정해야 한다.
			conn.setRequestMethod("POST"); // HEADER+BODY 파라미터값
			conn.setDoOutput(true); // BODY가 있다고 알려주는?
			
			//header 타입 바꾸기
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			
			StringBuilder sb = new StringBuilder();
			sb.append("client_id=").append(client_id)
			  .append("&client_secret=").append(client_secret)
			  .append("&scope=").append("oob")
			  .append("&grant_type=").append("client_credentials");

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			OutputStream os = conn.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));// 자바교재2권 1021쪽에 설명

			bw.write(sb.toString());
			bw.flush();
			bw.close();

			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}

			System.out.println("response body : " + result);

			Gson gson = new Gson();
			map = gson.fromJson(result, HashMap.class);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	} 
	
	public Map<String, Object> getOrgAccessTokenRestTemplate() {
		String reqURL = host + "/oauth/2.0/token";   
        MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
        param.add("client_id", client_id);
        param.add("client_secret", client_secret);
        param.add("scope", "oob");
        param.add("grant_type", "client_credentials");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        HttpEntity<MultiValueMap<String, String>> request = 
        		new HttpEntity<MultiValueMap<String, String>>(param, headers);
        
        
        //Rest객체가 기존에 했던 API 소스코드 다 만들어줌
        RestTemplate restTemplate = new RestTemplate();
        Map map = restTemplate.postForObject(reqURL, request, Map.class);
        return map;
	}
}
