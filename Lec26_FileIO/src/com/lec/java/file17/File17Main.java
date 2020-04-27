package com.lec.java.file17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	1.URL : 웹 상의 주소, 
 * 	2.HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 * client ---- server
 * client가 어떤 request(URL,...여러가지등)를 server에 요청
 * server이 client에게request에대한 response
 * chrome F12 - Network (request , response 값을 주고받는다)
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");

		String url = "https://www.naver.com/srchrank?frm=main&ag=all&gr=1&ma=-2&si=0&en=0&sp=0";

		StringBuffer sb = readFromUrl(url);
		//System.out.println(sb.toString().substring(0, 200)); 상위만받고싶을때
		System.out.println(sb);

		System.out.println("\n프로그램 종료");
	} // end main()

	/**
	 * 
	 * @param urlAddress :주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML)리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {
		// append 하기위해서 Stringbuffer를 쓴것이다
		// String 은 conenct
		// 여러데이터를 게쏙붙이기위해
		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을객체
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

} // end class
