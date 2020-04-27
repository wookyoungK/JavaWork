package com.lec.java.crawl01;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl01Main {

/*시험예시 6문제 답
 * 외부 라이브러리를 사용한 자바 프로젝트
 * 
 * 1. 라이브러리 다운로드
 * 
 * 2.프로젝트내 (혹은 특정경로)에 라이브러리 저장
 * 
 * 3. 프로젝트의 BuildPath 설정
 * 
 */
	
/*		java.lang에있는것들은 import 하지않아도된다
 * 		같은 class에 있는것들도 import 하지않아도된다
 * 		build path - configure build path - libraries  - Add jars - jar 할 파일
 * 
 * 1. https://jsoup.org/ 에서 다운로드
 * 
 * 2. 프로젝트에 폴더만들고(ex: libs) 라이브러리 복사
 * jRE(java Runtime environment) 자바의 라이브러리를 압축해서모아놓은것
 * 
 * 3. 프로젝트 우클릭 : build path - configure build path - libraries  - Add jars - jar 할 파일
 * jar할 파일은 폴더를만들어서 그곳에넣어놓고 build path해준다
 * 
 *jre꺠지는경우가 서버쪽에서많다 
 * 
 */
	
	/*
	 * 네이버 뉴스캐스트
	 * import 는 jsoup로 하기 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트 크롤링");
		
		String url; //크롤링할 주소 url
		Response response; //response 객체  request을받는곳
		Document doc; //JSOUP의 document object model객체로 되어있어야 찾아낼수있다
		Element element; //<~~> 클롤링도 element 단위로 이루어짐 /  HTML의 element 표현객체
		
		url ="https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		response =Jsoup.connect(url).execute(); 
						//GET 방식 request 는 다음과 같이 해도된다.
						//Jsoup.connect(url).get();
		
		
												// 커넥션을 수행하라 try커넥션하지말고 throw로 예외처리
												//반복되는 코드들을 모아서 쉽게 Lec26 17_16에서의 파일들
		System.out.println(response.statusCode());
		
//		request 결과코드
//		200 성공
//		404 url 존재하지 않음
//		500 서버 내부 
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러
	
		System.out.println(response.statusMessage());
		
		//특정부분에서 내가 원한는부분을 꺼내는것 parsing ******************************
		doc =response.parse();
		
		System.out.println(doc.title());//<title> element 의 텍스트
		System.out.println(doc.location()); //현재 웹문서의 url
		
		String outerHtml = doc.outerHtml();
//		System.out.println(outerHtml);	//현재 node의 outer html text
//		System.out.println(outerHtml.substring(0,200)+"...");
		
		
//-----------------------------------------------------------------------이위에는 서비스 아래가진짜 
		// Document 나 Elment 객체의
		// select(), selectFirst() 메소드로 특정 element(들)을추줄
		// 추출하려는 문장 에서 가장위인 iD를 찾는다
		System.out.println("[네이버 뉴스 캐스트]");
		
		element = doc.selectFirst("#news_cast"); //id값 
	//System.out.println(element.outerHtml());	selectFirst는  검색된 Elemnet 들 중 최초 1개만 Element 로 리턴

		Elements newsElements =doc.select("#news_cast li.ca_item"); //중간에 공백있음 , 말로설명할수있어야함 
										//검색된 Element 들이 담겨 있느 Elements 리턴
										//시행착오가 제일많이나옴
		
		//목록 크롤링 할시 , 내가 원하는 '개수' 만큼 크롤링 되었는지 우선 확인해보자!
		System.out.println(newsElements.size()+"개");
		
		for(Element e :newsElements) {
			//System.out.println(e.outerHtml());
			element = e.selectFirst("a"); // 앞글자하나 ? ;
			System.out.println(element.text()); //Element의 text() -> text들을 묶어서 하나로 출력
			System.out.println(element.attr("href")); //뽑아내고자하는 url 이름 
		
		}
		
		System.out.println("\n프로그램 종료");
	}// end main()

}//end class
