package com.lec.java.crawl14;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class Crawl14Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습 : URL -> json ->JAVA");

		ObjectMapper mapper = new ObjectMapper();

		URL url = new URL("http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001");

		Subway subway = mapper.readValue(url, Subway.class);

		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());
		
		for(SubRow e : subway.getCardSubwayStatsNew().getRow()) {
					System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n", 
							e.getLineNum(), 
							e.getStationName(), 
							e.getRidePassenger(), 
							e.getAlightPassenger());
				
				
		}

		System.out.println("프로그램종요");
	}// end main

}// end class

@JsonIgnoreProperties(ignoreUnknown = true) // 처음쓰는것
class Subway {
	public Stats CardSubwayStatsNew; // class 명은 내가알아서 but property 이름은 동일하게 cardsSubwayStatsNew= property*********
	// 왜 이것만 public? ;;

	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		this.CardSubwayStatsNew = cardSubwayStatsNew;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Stats { // cardsSubwayStatsNew타입이 object이기때문에 이object의 리스트 변수정의
	// (원래는 모든 property 다받아야하지만 여기서는 list_total_count받기위해 이것만 선언후
	// ignoreUnknown선언으로 오류 무시 처음나오는것 !!!!
	private int list_total_count;
	
	private List<SubRow> row;

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	
	public List<SubRow> getRow() {
		return row;
	}

	public void setRow(List<SubRow> row) {
		this.row = row;
	}
	
}

//JSON 필드명과 매핑되는 JAVA객체의 변수명을 달리 하고 싶다면
//@JsonProperty사용 
@JsonIgnoreProperties(ignoreUnknown = true)
class SubRow { // Stats의 row가 배열이지만 내용이 object이기때문에 하나만들어준다 !!***무조건 object이면 class만들어주어서 그안에
				// 배열값을 넣어준다

	@JsonProperty("LINE_NUM")   // JSON 의 LINE_NUM --> lineNum 으로 매핑
	private String lineNum;
	
	@JsonProperty("SUB_STA_NM")
	private String stationName;
	
	@JsonProperty("RIDE_PASGR_NUM")
	private int ridePassenger;   // 탑승인원
	
	@JsonProperty("ALIGHT_PASGR_NUM")
	private int alightPassenger;
	
	public SubRow() {
		super();
	}

	public SubRow(String lineNum, String stationName, int ridePassenger, int alightPassenger) {
		super();
		this.lineNum = lineNum;
		this.stationName = stationName;
		this.ridePassenger = ridePassenger;
		this.alightPassenger = alightPassenger;
	}


	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getRidePassenger() {
		return ridePassenger;
	}

	public void setRidePassenger(int ridePassenger) {
		this.ridePassenger = ridePassenger;
	}

	public int getAlightPassenger() {
		return alightPassenger;
	}

	public void setAlightPassenger(int alightPassenger) {
		this.alightPassenger = alightPassenger;
	}
	
	
}

	