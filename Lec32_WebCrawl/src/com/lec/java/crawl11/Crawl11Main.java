package com.lec.java.crawl11;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * HTML  -- > XML, JSON 파싱 연습
 * http://swopenapi.seoul.go.kr/api/subway/sample/xml/stationInfo/0/5/%EC%84%9C%EC%9A%B8 --url 번역하기 
 * 
 * START_INDEX	INTEGER(필수)	요청시작위치	정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
END_INDEX	INTEGER(필수)	요청종료위치	정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
statnNm	STRING(필수)	지하철역명	지하철역명 
이세개 지정
 각각의 row 
StatnNM 지역
subWayId ID
subWayNm 
 
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/75417a574a7064313436764c44596c/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/75417a574a7064313436764c44596c/json/stationInfo/1/5/서울


 */
public class Crawl11Main {

	public static final String REQ_SERVICE = "stationInfo"; // TODO
	public static final String API_KEY = "75417a574a7064313436764c44596c"; // 내키값

	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철 역사(station)정보");
		// 1 . 키값미리정하기
		String url_address = "";
		StringBuffer sb; // response 받은 텍스트

//3. sb에 제대로 url넘어오는지 확인		
		System.out.println("----XML 파싱----");
		// TODO
		url_address = buildUrlAddress("xml","서울");
		sb = readFromUrl(url_address); // --> 26강 17장에서 퍼온 매소드 그대로쓴것
		parseXML(sb.toString());

//		xml 이 제대로 넘어오는지확인

		System.out.println("----Json 파싱----"); 
		// TODO
		url_address = buildUrlAddress("json","왕십리");
		sb = readFromUrl(url_address); // -->26강 17장에서 퍼온 매소드 그대로쓴것
		parseJSON(sb.toString());

		// json 이 제대로 넘어오는지확인 , 보통은 띄어쓰기없이 나타남 사이트마다 다름

	} // end main()

	// 2. Url
	
	public static String buildUrlAddress(String reqType,String search  ) throws IOException {

		String url_address = String.format(
				"http://swopenapi.seoul.go.kr/api/subway/75417a574a7064313436764c44596c/%s/stationInfo/1/5/%s",
				
				reqType,URLEncoder.encode(search, "utf-8"));
		return url_address;

	}
	
	

//	}

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

//4. XML ,JSON 만들기
	public static void parseXML(String xmlText) {
		// XML 파싱
		// 여기서 import 는 w3c.dom 으로 다하기!
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
			docElement.normalize(); // 흩어진 text node들을 정렬하는 등의 절차,
			// XML파싱하기전에 꼭 normalize()부터 해주자

			// DOM 내의 데이터 파싱
			NodeList nList = docElement.getElementsByTagName("row"); // <row>..</row> element 들로 구성된 NodeList 리턴 nList에는
																		// 5개가저장된다
			System.out.println("<row> 개수: " + nList.getLength());

			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i); // for문 하나하나 <>row>...</row> 출력 이노드안에서 호선 ,역 인원 등 4개 찾아내야함

				// System.out.println("node type : " + node.getNodeType()); //상수값으로 정해져있음 1번
				// 노트타입

				// element node 인 경우만 파싱 진행
				if (node.getNodeType() != Node.ELEMENT_NODE)
					continue;

				Element rowElement = (Element) node;// 부모가 왼쪽이면 (Elemnet)필요없다 ! 여기선 부모가 오른쪽이기때문에 (Element)변환해준것이다.! 다형성

				// rowElement.getTextContent(); 도있음

				String statnId = rowElement.getElementsByTagName("statnNm").item(0).getChildNodes().item(0)
						.getNodeValue().trim(); // 자바에선 elements 밖에안쓴다 element ㄴㄴ
				String subwayId = rowElement.getElementsByTagName("subwayId").item(0).getChildNodes().item(0)
						.getNodeValue().trim(); // 자바에선 elements 밖에안쓴다 element ㄴㄴ
				String subwayNm = rowElement.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0)
						.getNodeValue().trim(); // 자바에선 elements 밖에안쓴다 element ㄴㄴ

				System.out.printf("%d: %5s역  %6s %6s\n", i + 1, statnId, subwayId, subwayNm);

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

		JSONObject jObj = new JSONObject(jsonText); // JSON파싱 : JSONObject <- String

		JSONArray row = jObj.getJSONArray("stationList");// jason 배열을가져온것
		// 오브젝트에서 오브젝트뽑을떄
		System.out.println("row 의 개수: " + row.length());

		System.out.println();

		for (int i = 0; i < row.length(); i++) {
			JSONObject station = row.getJSONObject(i); // 배열에서 매개변수뽀ㅃㅂ을때

			String statnNm = station.getString("statnNm");
			String subwayId = station.getString("subwayId");
			String subwayNm = station.getString("subwayNm");

			System.out.printf("%d: %5s역  %6s %6s\n", i + 1, statnNm, subwayId, subwayNm);
		}

	}

} // end class
