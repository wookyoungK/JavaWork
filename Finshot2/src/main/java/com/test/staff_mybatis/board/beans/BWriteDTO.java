package com.test.staff_mybatis.board.beans;

public class BWriteDTO {
	private int uid;    
	private String name; 
	private String position;   
	private String phone;   
	private String email;   
	
	public BWriteDTO() {
		super();
	}

	public BWriteDTO(int uid, String name, String position, String phone, String email) {
		super();
		this.uid = uid;
		this.name = name;
		this.position = position;
		this.phone = phone;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
