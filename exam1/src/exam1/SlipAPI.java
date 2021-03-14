package exam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class SlipAPI {
	public Map<String, Object> insertSlip(String param) {
		String reqURL = "http://192.168.0.83/exam/insertSlip";
		Map<String, Object> map = new HashMap<>();

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //  HttpURLConnection = ajax url

			// POST 요청을 하려면 기본값이 false인 setDoOutput을 true로 설정해야 한다.
			conn.setRequestMethod("POST"); 
			conn.setDoOutput(true);
			
			//header 타입 바꾸기
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			//servlet용은 network >>> preview에 타입보고 적어야함 contentType >>> Content-Type임

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			OutputStream os = conn.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			writer.write(param); // 파라미터와 &= 합체.
			writer.flush();
			writer.close();
			os.close();

			StringBuilder sb = new StringBuilder();
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				System.out.println("" + sb.toString());
			} else {
				System.out.println("error 이유 : " + conn.getResponseMessage());
			}
            
            // Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성  "{}"
            Gson gson = new Gson();
            map = gson.fromJson(sb.toString(), Map.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	} 
	
}
