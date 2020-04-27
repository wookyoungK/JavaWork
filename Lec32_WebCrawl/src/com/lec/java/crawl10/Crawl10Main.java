package com.lec.java.crawl10;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//여태까지 jsoup를사용하여 HTML  --paring한것임

/* XML, Json 파싱1 ********************************************************************************************
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/75417a574a7064313436764c44596c/xml/CardSubwayStatsNew/1/5/20181001
 *   //   parameter 는 /c / b /a /  각각슬래쉬 하나하나 가 parameter가된다.
 *   //요청인자(request)는 외부에서 정해져있다. 남의 API를 받을때 파라미터 ,값들이 어떤식으로 적용되는지 알아야한다.	
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/75417a574a7064313436764c44596c/json/CardSubwayStatsNew/1/5/20181001 
 * */

/* JSON 파싱
java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
	├─ java.io.InputStreamReader    // 스트림 기반의 reader
 	└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class Crawl10Main {

	public static final String REQ_SERVICE = "CardSubwayStatsNew";
	public static final String API_KEY = "75417a574a7064313436764c44596c"; // 내키값

	public static void main(String[] args) {
		System.out.println("서울시 지하철호선별 역별 승하차 인원 정보");
		// 1 . 키값미리정하기
		int startIndex; // 요청시작위치 정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
		int endIndex; // 요청종료위치 정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
		String date; // 날짜 yyyymmdd 형식

		String url_address;
		StringBuffer sb; // response 받은 텍스트

		//여기 값들을조정
		startIndex = 1;
		endIndex = 5;
		date = "20200329";
//3. sb에 제대로 url넘어오는지 확인		
		System.out.println("----XML 파싱----");
		url_address = buildUrlAddress("xml", startIndex, endIndex, date);
		sb = readFromUrl(url_address); // --> 26강 17장에서 퍼온 매소드 그대로쓴것
		parseXML(sb.toString());

//		System.out.println(sb);
//		xml 이 제대로 넘어오는지확인

		System.out.println("----XML 파싱----");
		url_address = buildUrlAddress("json", startIndex, endIndex, date);
		sb = readFromUrl(url_address); //-->26강 17장에서 퍼온 매소드 그대로쓴것
		parseJSON(sb.toString());
		
//		System.out.println(sb);
		// json 이 제대로 넘어오는지확인 , 보통은 띄어쓰기없이 나타남 사이트마다 다름

	} // end main()

	// 2. url매서드만들기
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/CardSubwayStatsNew/%d/%d/%s", API_KEY,
				reqType, startIndex, endIndex, date);

		return url_address;
	}

	/**
	 * 26장 17에서 퍼옴
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

//4. parseXML? 만들기
	public static void parseXML(String xmlText) {
		// XML 파싱
		//여기서 import 는 w3c.dom 으로 다하기!
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;

		try {
			// DOM parser 객체 생성
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();

			// String -> InputStream 변환
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));
			
			// InputStream -> DOM 객체 생성
			Document dom = dBuilder.parse(in);
			
			// DOM 최상위 document element 추출
			Element docElement = dom.getDocumentElement(); // DOM의 최상위 element
			// 파싱하기전 normalize()
			docElement.normalize(); //흩어진 text node들을 정렬하는 등의 절차,
								//XML파싱하기전에 꼭  normalize()부터 해주자

			// DOM 내의 데이터 파싱
			NodeList nList = docElement.getElementsByTagName("row"); //<row>..</row> element 들로 구성된 NodeList 리턴  nList에는 5개가저장된다
			System.out.println("<row> 개수: " + nList.getLength() );
			
			System.out.println();
			for(int i=0; i <nList.getLength(); i++) {
				Node node = nList.item(i); //for문 하나하나 <>row>...</row> 출력 이노드안에서 호선 ,역 인원 등 4개 찾아내야함 
				
				//System.out.println("node type : " + node.getNodeType()); //상수값으로 정해져있음 1번 노트타입
				
				// element node 인 경우만 파싱 진행
				if(node.getNodeType() !=Node.ELEMENT_NODE )continue;
			
				Element rowElement = (Element)node;//부모가 왼쪽이면 (Elemnet)필요없다 ! 여기선 부모가 오른쪽이기때문에 (Element)변환해준것이다.! 다형성
				
				//rowElement.getTextContent(); 도있음
				
				
				String LINE_NUM =rowElement.getElementsByTagName("LINE_NUM").item(0).getChildNodes().item(0).getNodeValue().trim(); //자바에선 elements 밖에안쓴다 element ㄴㄴ
				String SUB_STA_NM=rowElement.getElementsByTagName("SUB_STA_NM").item(0).getChildNodes().item(0).getNodeValue().trim(); //자바에선 elements 밖에안쓴다 element ㄴㄴ
				String RIDE_PASGR_NUM=rowElement.getElementsByTagName("RIDE_PASGR_NUM").item(0).getChildNodes().item(0).getNodeValue().trim(); //자바에선 elements 밖에안쓴다 element ㄴㄴ
				String ALIGHT_PASGR_NUM=rowElement.getElementsByTagName("ALIGHT_PASGR_NUM").item(0).getChildNodes().item(0).getNodeValue().trim(); //자바에선 elements 밖에안쓴다 element ㄴㄴ
				
				System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n",
						LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);

				
			}
		
			
			
			
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void parseJSON(String jsonText) {
		// org.json  라이브러리 다운로드
		// https://mvnrepository.com/artifact/org.json/json
		// 최신버젼 클릭후, Files 항목 클릭해서 다운로드
		
		//처음쓰는것  response 받은것이 object이기때문에 object로변환 
		JSONObject jObj = new JSONObject(jsonText); //JSON파싱 : JSONObject <- String
		//jObj.getJSONObject("CardSubwayStatsNew");  object를가져온것
		JSONArray row = jObj.getJSONObject("CardSubwayStatsNew").getJSONArray("row");//jason 배열을가져온것
		               // 오브젝트에서 오브젝트뽑을떄
		System.out.println("row 의 개수: "+row.length());
		System.out.println();
		
		for(int i=0; i<row.length(); i++) {
			JSONObject station = row.getJSONObject(i); //배열에서 매개변수뽀ㅃㅂ을때
			
			String LINE_NUM = station.getString("LINE_NUM");
			String SUB_STA_NM = station.getString("SUB_STA_NM");
			int RIDE_PASGR_NUM = station.getInt("RIDE_PASGR_NUM");
			int ALIGHT_PASGR_NUM = station.getInt("ALIGHT_PASGR_NUM");
			
			System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n",LINE_NUM,SUB_STA_NM,RIDE_PASGR_NUM,ALIGHT_PASGR_NUM);
		}


		
	}
} // end class
