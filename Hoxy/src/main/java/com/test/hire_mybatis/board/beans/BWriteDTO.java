package com.test.hire_mybatis.board.beans;

public class BWriteDTO {

	private int h_uid;
	private int h_content;
	// private int h_uid;
	private int h_salary;
	private int h_position1;
	private int h_position2;
	private int h_part;
	private int h_career;
	private int h_degree;
	private int h_workform;
	private int h_cnt;
	private int h_upDate;
	private int h_regDate;

	public BWriteDTO() {
		super();
	}

	public BWriteDTO(int h_uid, int h_content, int h_salary, int h_position1, int h_position2, int h_part, int h_career,
			int h_degree, int h_workform, int h_cnt, int h_upDate, int h_regDate) {
		super();
		this.h_uid = h_uid;
		this.h_content = h_content;
		this.h_salary = h_salary;
		this.h_position1 = h_position1;
		this.h_position2 = h_position2;
		this.h_part = h_part;
		this.h_career = h_career;
		this.h_degree = h_degree;
		this.h_workform = h_workform;
		this.h_cnt = h_cnt;
		this.h_upDate = h_upDate;
		this.h_regDate = h_regDate;
	}

	public int getH_uid() {
		return h_uid;
	}

	public void setH_uid(int h_uid) {
		this.h_uid = h_uid;
	}

	public int getH_content() {
		return h_content;
	}

	public void setH_content(int h_content) {
		this.h_content = h_content;
	}

	public int getH_salary() {
		return h_salary;
	}

	public void setH_salary(int h_salary) {
		this.h_salary = h_salary;
	}

	public int getH_position1() {
		return h_position1;
	}

	public void setH_position1(int h_position1) {
		this.h_position1 = h_position1;
	}

	public int getH_position2() {
		return h_position2;
	}

	public void setH_position2(int h_position2) {
		this.h_position2 = h_position2;
	}

	public int getH_part() {
		return h_part;
	}

	public void setH_part(int h_part) {
		this.h_part = h_part;
	}

	public int getH_career() {
		return h_career;
	}

	public void setH_career(int h_career) {
		this.h_career = h_career;
	}

	public int getH_degree() {
		return h_degree;
	}

	public void setH_degree(int h_degree) {
		this.h_degree = h_degree;
	}

	public int getH_workform() {
		return h_workform;
	}

	public void setH_workform(int h_workform) {
		this.h_workform = h_workform;
	}

	public int getH_cnt() {
		return h_cnt;
	}

	public void setH_cnt(int h_cnt) {
		this.h_cnt = h_cnt;
	}

	public int getH_upDate() {
		return h_upDate;
	}

	public void setH_upDate(int h_upDate) {
		this.h_upDate = h_upDate;
	}

	public int getH_regDate() {
		return h_regDate;
	}

	public void setH_regDate(int h_regDate) {
		this.h_regDate = h_regDate;
	}

}
