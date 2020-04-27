package com.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Jsoup");

		Element element;
		Elements elements;

		File f = new File("data/hello.html"); // 원래 윈도우는 /안됨
		Document doc = Jsoup.parse(f, "UTF-8"); // 파일 -> Document변환 (DOM구조변환)
		// System.out.println(doc.outerHtml()); //전체 코드 보여줌

		// Document 나 Element 객체에서
		// Select() , seleceFirst() 메소드로 element()객체 추출
		element = doc.selectFirst("div");
		// System.out.println(element.outerHtml());//첫번째 div출력
		elements = doc.select("div");
		System.out.println(elements.size() + "개");//

		// Elements 의 get(n) ->n번째 Element리턴

//		element = elements.get(2); 
//		System.out.println(element.outerHtml()); //2번쨰  div 출력
//		element = elements.get(3); 
//		System.out.println(element.outerHtml()); //3번쨰  div 출력
//		element = elements.get(4); 
//		System.out.println(element.outerHtml()); //4번쨰  div 출력
//		for (int i = 0; i < elements.size(); i++) {
//			element = elements.get(i);
//			System.out.println(element.outerHtml());
//			System.out.println("\n*********************\n");
//			
//		}
//		//enhanced for
//		for(Element e: elements) {
//			System.out.println(e.outerHtml());
//		}
//		
//		element =doc.selectFirst("div#addr");
//		System.out.println(element.outerHtml()); //addr인것을출력 element 3번째문의 첫div이니까
//		
//		elements = element.select("ul.favorite a");//class favorite 에서 ul 에서 a를찾기때문에elements
//		System.out.println(elements.size()+"개"); //a의개수 출력
//		
//		for(Element e :elements) {
//			//System.out.println(e.outerHtml());
//			System.out.println(e.text().trim());//text값출력
//			System.out.println(e.attr("href").trim());//attr  
//		}
		

		System.out.println(element.outerHtml());
		for(Element img: doc.select("img")) {
			System.out.println(img.attr("src").trim());
		}
		

		System.out.println("\n프로그램 종료");

	}// end main()

}// end class
