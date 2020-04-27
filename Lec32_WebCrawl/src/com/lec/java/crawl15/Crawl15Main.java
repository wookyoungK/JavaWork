package com.lec.java.crawl15;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;


/*
샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/75417a574a7064313436764c44596c/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/75417a574a7064313436764c44596c/json/stationInfo/1/5/서울

*/
public class Crawl15Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jaskson-databind 연습2");
		ObjectMapper mapper = new ObjectMapper();
		Scanner sc = new Scanner(System.in);
		System.out.println("입력해주세요");
		String a = sc.nextLine();
//		URL url = new URL("http://swopenAPI.seoul.go.kr/api/subway/75417a574a7064313436764c44596c/xml/stationInfo/1/5/서울");
		URL url = new URL(String.format(
				"http://swopenapi.seoul.go.kr/api/subway/75417a574a7064313436764c44596c/json/stationInfo/1/5/%s",
		 URLEncoder.encode(a, "utf-8")));
//		System.out.println(url_address);
		StationList stationList = mapper.readValue(url, StationList.class);
		
		System.out.println(stationList.getStationList());

		for(Stats e : stationList.getStationList()) {
					System.out.printf(" %s  %s %s \n", 
							
							e.getStatnNm(),
							e.getSubwayId(),
							e.getSubwayNm());
		}
		System.out.println("프로그램종요");
	}// end main
}//end class

@JsonIgnoreProperties(ignoreUnknown = true) 
class StationList {

	private List<Stats> stationList;

	public List<Stats> getStationList() {
		return stationList;
	}

	public void setStationList(List<Stats> stationList) {
		this.stationList = stationList;
	}

		

	
}//end class


@JsonIgnoreProperties(ignoreUnknown = true)
class Stats{
	
	public Stats() { //기본 생성자를 무조건생성해주자!!
		super();
	}

	public String statnNm;
	public String subwayId;
	public String subwayNm;
	
	public Stats( String statnNm, String subwayId, String subwayNm) {
		super();

		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
	}

	public String getStatnNm() {
		return statnNm;
	}
	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}
	public String getSubwayId() {
		return subwayId;
	}
	public void setSubwayId(String subwayId) {
		this.subwayId = subwayId;
	}
	public String getSubwayNm() {
		return subwayNm;
	}
	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}
	
	
	
}
