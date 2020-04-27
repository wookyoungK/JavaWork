package com.lec.java.crawl16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5108593855466&lng=127.029258482886&order=rank&page=0&search=
public class Crawl16Main {

	public static void main(String[] args) throws IOException {
		System.out.println("요기요 맛집정보 : header 추가");

		String url = "https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5108593855466&lng=127.029258482886&order=rank&page=0&search=";
		StringBuffer sb = readFromUrl(url);

		// 맛집 이름/ 평점
		ObjectMapper mapper = new ObjectMapper();

		Restaurants restaurants = mapper.readValue(sb.toString(), Restaurants.class);

		for(Stats e : restaurants.getRestaurants()) {
			System.out.printf(" %s  %.2f\n", 
					e.getSlug(),
					e.getReview_avg());
					
					
		}
		System.out.println("\n 프로그램 종료");
	}// end main

	public static StringBuffer readFromUrl(String urlAddress) {

		// append 하기위해서 Stringbuffer를 쓴것이다
		// String 은 conenct
		// 여러데이터를 게쏙붙이기위해
		StringBuffer sb = new StringBuffer(""); // response 받은 데이터 담을객체
		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null; // stream으로끝나서 byte단위
		InputStreamReader reader = null; // byte스트림 -->문자기반Reader
		BufferedReader br = null;

		char[] buf = new char[512]; // 문자용 버퍼

		// 순서 : BufferedReader <-InputStreamReader <- InputStream <-HttpURLConnection
		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // Connection객체생성

			if (conn != null) {
				conn.setConnectTimeout(2000); // 2초이내에 '연결'이 수립안되면
												// java.net.socketTimeoutException발생

				conn.setRequestMethod("GET"); // GET방식 request
												// "GET","POST"...
				conn.setRequestProperty("Conetnt-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				// request를 하는데 이러한 문자열 형식을쓰겟다.
				conn.setUseCaches(false); // 캐시사용안함 기억하는것?

				// 헤더 정보 추가 4.03일에 추가
				conn.setRequestProperty("X-ApiKey", "iphoneap");
				conn.setRequestProperty("X-ApiSecret", "fe5183cc3dea12bd0ce299cf110a75a2");

				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 -->이후 response 받을때까지 delay
				System.out.println("response 완료");

				// response 받은후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				// request를 보내면 response로 코드값을 받아온다 그떄 200이라는 코드값을 받아와야 정상잉다!!!!!!*******
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if (responseCode == HttpURLConnection.HTTP_OK) {// URL 200 을나타낸다

					in = conn.getInputStream(); // InputStream <-HttpURLConnection
					reader = new InputStreamReader(in, "utf-8");// InputStreamReader <- InputStream
					br = new BufferedReader(reader); // BufferedReader <-InputStreamReader
					// 한줄로출 가능
					int cnt; // 읽은 글자 개수
					while ((cnt = br.read(buf)) != -1) { // 읽는 글자개수가 0일떄까지
						sb.append(buf, 0, cnt);// response 받은 텍스트를 StringBuffer 에 추가
					}

				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (conn != null)
				conn.disconnect(); // 작업 끝나고 Connection 해제
		}
		return sb;

	}
}// end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Restaurants {

	public List<Stats> restaurants;

	public List<Stats> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Stats> restaurants) {
		this.restaurants = restaurants;
	}

}// end class

@JsonIgnoreProperties(ignoreUnknown = true) 
class Stats{
	private String slug;
	private double review_avg;
	public Stats() {
		super();
	}
	public Stats(String slug, double review_avg) {
		super();
		this.slug = slug;
		this.review_avg = review_avg;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public double getReview_avg() {
		return review_avg;
	}
	public void setReview_avg(double review_avg) {
		this.review_avg = review_avg;
	}
	
	
}
