package com.test.hire_mybatis.board.beans;

public class BWriteDTO {

	private int uid;
	private String title;
	private String content;
	// private String c_uid;
	private String salary;
	private String position1;
	private String position2;
	private String part;
	private String career;
	private String degree;
	private String workform;
	private int cnt;
	private String upDate;
	private String regDate;

	public BWriteDTO() {
		super();
	}

	public BWriteDTO(int uid, String title, String content, String salary, String position1, String position2,
			String part, String career, String degree, String workform, int cnt, String upDate, String regDate) {
		super();
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.salary = salary;
		this.position1 = position1;
		this.position2 = position2;
		this.part = part;
		this.career = career;
		this.degree = degree;
		this.workform = workform;
		this.cnt = cnt;
		this.upDate = upDate;
		this.regDate = regDate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPosition1() {
		return position1;
	}

	public void setPosition1(String position1) {
		this.position1 = position1;
	}

	public String getPosition2() {
		return position2;
	}

	public void setPosition2(String position2) {
		this.position2 = position2;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getWorkform() {
		return workform;
	}

	public void setWorkform(String workform) {
		this.workform = workform;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getUpDate() {
		return upDate;
	}

	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
