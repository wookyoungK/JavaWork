package com.lec.java.crawl05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl05Main {
/*
 *'검색어' 입력받아서 
 * 첫페이지의 '국내도서' 첫페이지 20개 아이템 크롤링
 * 책이름 /책가격/상세페이지 url /썸네일 url  ---->한번에 4개
 * 
 * yes24.com 검색페이지는 euc-kr로 URL인코딩 되어 있다.
 * 한글1글자당 2byte 인코딩
 *
 */
	private static final String PATH = "books";
	public static void main(String[] args) throws IOException {
		System.out.println("yes24.com 검색 결과 페이지");
	
		Scanner sc=new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		String search =sc.nextLine();
		sc.close();
		
		Crawl05Main app =new Crawl05Main();
		ArrayList<InfoBook> list =app.crawlYes24(search);
		
		//썸네일 이미지 다운로드 받아서
		//thumb001.jpg ~ thumb020.jpg ........
		int fileIndex = 1;
		for(InfoBook e : list) {
			System.out.println(e);  // 크롤링 정보 출력
			
			// 썸네일 이미지 다운로드
			String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
			URL imgUrl = new URL(e.getImgurl());
			
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData, "jpg", file);			
			
			System.out.println(fileName + " 이 저장되었습니다");
			fileIndex++;
		}
		
		System.out.println("\n프로그램 종료");
		//썸네일 이미지 다운로드
		
	}//end main()
	private ArrayList<InfoBook> crawlYes24(String search) throws IOException{ //static으로 선언되지않아서 main에서 직접입력할수없다
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		String url;
		Response response;
		Document doc;
		Elements elements;
		Elements rowElements;
		
		//#schMid_wrap > div:nth-child(4)
		url = "http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C0%FC%C3%BC&Wcode=001_005&query="
		+ URLEncoder.encode(search, "euc-kr");
		System.out.println(url);
		
		doc =Jsoup.connect(url).execute().parse();
//		elements = doc.select("#schMid_wrap > div.goods_list_wrap.mgt30");//?
//		rowElements = elements.get(0).select("tr:nth-child(odd)");//?
		rowElements = doc.select("#schMid_wrap > div.goods_list_wrap.mgt30").get(0).select("tr:nth-child(odd)"); 
		
//		System.out.println(rowElements.size()+'개'); //이상함 다시보기
		
		
		
		for (Element e : rowElements) {
			
			String imgUrl = e.selectFirst("td.goods_img >a>img").attr("src").trim();
			System.out.println(imgUrl); 
//			Element infoElement = e.selectFirst("td.goods_infogrp > p.goods_name > a"); //원래이게 찾이어려움
//			
//			String bookTitle = infoElement.text().trim();
//			String linkUrl = "http://www.yes24.com"+infoElement.attr("href").trim();
//			System.out.println(bookTitle + " : " + linkUrl);  // 확인용
//			 위의 infoElement에서 받아온것
//			double price =Double.parseDouble(
//			e.selectFirst("td.goods_infogrp > div.goods_price > em.yes_b").text().trim().replace(",", ""));
//			System.out.println(price + "원"); 확인용
//			가격은 문자열로 표시되어있기때문에 , 를 제거하고 문자열을 숫자형탑입으로변환해야하는 작업을해야한다
//			
//			
//			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));

		}
		return list;
	}
}//end class
