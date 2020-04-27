package com.lec.java.crawl04;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException{
		System.out.println("네이버 연관 검색어");
		String url;
		Response response;
		Document doc;
		Elements elements;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		searchKeyword =sc.nextLine();
		sc.close();
		
		String encoded = URLEncoder.encode(searchKeyword ,"utf-8"); //내가crawl링 할 사이트가 어떤타입인지 보고 타입의 종류를 써주어야 한다.
		
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=" +encoded;
		//System.out.println(url); //생성된 url 확인해보자
		
		doc =Jsoup.connect(url).execute().parse();
		
		elements = doc.select("ul._related_keyword_ul a");
		
		for (Element e : elements) {
			// System.out.println(e.outerHtml());
			System.out.println(e.text().trim());
			//System.out.println(e.attr("href"));

		
		
		}
		System.out.println("\n 프로그램 종료");
		

	}

}
