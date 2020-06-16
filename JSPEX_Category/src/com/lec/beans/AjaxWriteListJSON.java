package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxWriteListJSON {
	int count;
	String status; //처리결과
	@JsonProperty("list")
	private List<CategoryDTO> list;


	public AjaxWriteListJSON() {
		super();
	}

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public List<CategoryDTO> getList() {
		return list;
	}


	public void setList(List<CategoryDTO> list) {
		this.list = list;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
