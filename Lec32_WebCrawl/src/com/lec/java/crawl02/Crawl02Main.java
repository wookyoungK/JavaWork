package com.lec.java.crawl02;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {

	public static void main(String[] args) throws IOException {
		System.out.println("영화 인기 검색어");

		String url;
		Response response;
		Document doc;
		Element element;

		url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		response = Jsoup.connect(url).execute();
		System.out.println("\n 프로그램종료");
		doc = response.parse();
		Elements nateElements = doc.select("#assistant > div:nth-child(1) > ul");
		nateElements = nateElements.select("a");

		for (Element e : nateElements) {

			System.out.println(e.text().trim());
			

		}

	}

}
