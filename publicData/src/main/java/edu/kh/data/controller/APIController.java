package edu.kh.data.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	
	
	private static final String serviceKey = "%2FhPScVvgblKCKM6YClMUqz2tQca0EAb6n7F%2FzhUYej3r%2BDpo3R16Dqg9QyDao56FPwJMQWcRIwlFForDtP55Bg%3D%3D";
	

	@RequestMapping(value = "busInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String busInfo() throws Exception {
		
		String url = "http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteAcctoThrghSttnList";
		url += "?serviceKey=" +serviceKey;
		url += "&cityCode=25";
		url += "&routeId=DJB30300004";
		url += "&_type=json";
			
		URL requestUrl = new URL(url);

		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();

		urlConnection.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		String responseData = "";
		String line; 

		while((line = br.readLine()) != null) {
					responseData += line;
				}
		br.close();

		urlConnection.disconnect(); 

		System.out.println("responseData::" + responseData);
				
		return responseData;
	}
	
	
	
	
}
