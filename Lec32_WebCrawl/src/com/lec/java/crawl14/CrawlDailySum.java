package com.lec.java.crawl14;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;



public class CrawlDailySum {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습 : URL -> json ->JAVA");

		ObjectMapper mapper = new ObjectMapper();

		URL url2 = new URL(
				"http://openapi.seoul.go.kr:8088/75417a574a7064313436764c44596c/json/SPOP_DAILYSUM_JACHI/1/5/20190101");

		Ingu ingu = mapper.readValue(url2, Ingu.class);

		System.out.println(ingu.getSPOP_DAILYSUM_JACHI().getList_total_count());

		for (SubRo e : ingu.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.printf("%s  %s  %s  %s \n", 
					e.getStdr(),
					e.getCode(),
					e.getTot(),
					e.getMax());


		}

		System.out.println("프로그램종요");

	}

}

@JsonIgnoreProperties(ignoreUnknown = true) // 처음쓰는것
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

