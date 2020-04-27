package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//연습
//네이버 '검색어' 
//블로그 
//- post title
//- post url
//- blog title

//페이징 구현!
public class Crawl09Main {

	public static void main(String[] args) throws IOException {
	System.out.println("네이버 검색, 페이징");
	
	for(int i =0; i<10; i++) {
		crawlNaverBlog("파이썬", 2);
	}


		
	System.out.println("\n프로그램 종료");
	}//end main
	
public static void crawlNaverBlog(String search, int page) throws IOException {
		
		
		// 목록에서 크롤링 할 내용
		//  post title :
		//  post link url
		//  blog title :  
		
		
		//매개변수 검증 
		if(search == null || search.length() == 0 || page< 1) return;//항상  검색결과없을때를 체크해주어야한다!! 항상!! 
			
		String url;
		Response response;
		Document doc;
		Elements elements;
		Elements rowElements;
	
		//System.out.println(page + " 페이지");
		//&query=%s 여기가 "파이썬"해석되는곳( %e%E%D이렇게 번역되는것 ) , page=%ds
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d", 
				URLEncoder.encode(search, "utf-8"), (page - 1) * 10 + 1); //%s에 URLEncoder.encode(search, "utf-8") %d 에 page 출력
		doc = Jsoup.connect(url).execute().parse();
		//System.out.println(url); // 확인용
		//"#elThumbnailResultArea"
		elements = doc.select("#elThumbnailResultArea > li.sh_blog_top");
		//System.out.println(elements.size()); 10출력
		// > 아들 만되는것  그냥 " " 손자 의 손자의 손자 손자 되는것
		for(Element e: elements) {
			String postTitle = e.selectFirst("a.sh_blog_title").text().trim();
			String blogTitle = e.selectFirst("dd.txt_block a.txt84").text().trim();
			String postUrl= e.selectFirst("a.sh_blog_title").attr("href").trim();
			
			System.out.println(postTitle+ " : " +blogTitle+ " : " +postUrl);

		}
		System.out.println();
			
			
			
	} // end crawlDaumBl

}//end class
