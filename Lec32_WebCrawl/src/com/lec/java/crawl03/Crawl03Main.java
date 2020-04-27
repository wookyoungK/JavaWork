package com.lec.java.crawl03;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");
		String url;
		Response response;
		Document doc;
		Element element;

		url = "https://www.daum.net/";
		response = Jsoup.connect(url).execute();
		System.out.println(response.statusCode());// 200호출

		doc = response.parse();
		Elements nateElements = doc.select("div.slide_favorsch li a"); //사람마다 다르다
		System.out.println(nateElements.size());
		System.out.println(nateElements.outerHtml()); //뽑아서 구성보고 다음 select 찾기
		//nateElements = nateElements.select("a"); //

		for (Element e : nateElements) {
			// System.out.println(e.outerHtml());
			System.out.println(e.text());
			System.out.println(e.attr("href"));

		}
		System.out.println("\n 프로그램종료");
	}
}
