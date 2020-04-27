package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;



/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/75417a574a7064313436764c44596c/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/75417a574a7064313436764c44596c/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요************************************
// JSON 은  jackson 을 활용하여 파싱하세요**************************************
//내키값 75417a574a7064313436764c44596c

public class DailySumMain {
	// XML - jsoup 활용
	public static final String API_KEY = "75417a574a7064313436764c44596c"; // 내키값

	public static void main(String[] args) throws IOException {
		System.out.println("자치구단위 서울 생활인구 일별 집계표");
		String url = buildUrlAddress("xml", 1, 5, "20190101");

		// XML 파싱할때는 xml parser를 사용한다.
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get(); // 이부분이다름
		Elements elements = doc.select("row");
		System.out.println("jsoup-databind 연습 : URL -> XML ->JAVA");
		for (Element e : elements) {
			String STDR_DE_ID = // 날짜
					e.selectFirst("STDR_DE_ID").text().trim();
			String SIGNGU_CODE_SE = // 구 ID
					e.selectFirst("SIGNGU_CODE_SE").text().trim();
			String TOT_LVPOP_CO = e.selectFirst("TOT_LVPOP_CO").text().trim();
			String DAIL_MXMM_MVMN_LVPOP_CO = e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();

			System.out.printf("%5s  %8s  %6s  %6s\n", STDR_DE_ID, SIGNGU_CODE_SE, TOT_LVPOP_CO,
					DAIL_MXMM_MVMN_LVPOP_CO);

		}
//-------------------------------------------------------------------------------jackson
		ObjectMapper mapper = new ObjectMapper();		
		URL url2 = new URL(
	"http://openapi.seoul.go.kr:8088/75417a574a7064313436764c44596c/json/SPOP_DAILYSUM_JACHI/1/5/20190101");
			
		Ingu ingu = mapper.readValue(url2, Ingu.class);
		
		//System.out.println(ingu.getSPOP_DAILYSUM_JACHI().getList_total_count());
		System.out.println("\njackson-databind 연습 : URL -> json ->JAVA");
		for (SubRo e : ingu.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.printf("%s  %s  %s  %s \n", 
					e.getStdr(),
					e.getCode(),
					e.getTot(),
					e.getMax());
		}

		System.out.println("프로그램종요");
	}// end main

	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/SPOP_DAILYSUM_JACHI/%d/%d/%s/",
				API_KEY, reqType, startIndex, endIndex, date);

		return url_address;
	}
} 


//--------------------------------------jackson----------------------------

@JsonIgnoreProperties(ignoreUnknown = true) 
class Ingu {
	public Stat SPOP_DAILYSUM_JACHI;

	public Ingu() {
		super();
	}

	public Ingu(Stat sPOP_DAILYSUM_JACHI) {
		super();
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}

	public Stat getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(Stat sPOP_DAILYSUM_JACHI) {
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Stat { 
	private int list_total_count;
	
	private List<SubRo> row;

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	
	public List<SubRo> getRow() {
		return row;
	}

	public void setRow(List<SubRo> row) {
		this.row = row;
	}
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class SubRo { 
	@JsonProperty("STDR_DE_ID")   // JSON 의 LINE_NUM --> lineNum 으로 매핑
	private String stdr;
	
	@JsonProperty("SIGNGU_CODE_SE")
	private String code;
	
	@JsonProperty("TOT_LVPOP_CO")
	private String tot;   // 탑승인원
	
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String max;

	public SubRo() {
		super();
	}

	public SubRo(String stdr, String code, String tot, String max) {
		super();
		this.stdr = stdr;
		this.code = code;
		this.tot = tot;
		this.max = max;
	}

	public String getStdr() {
		return stdr;
	}

	public void setStdr(String stdr) {
		this.stdr = stdr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTot() {
		return tot;
	}

	public void setTot(String tot) {
		this.tot = tot;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}
	
}

