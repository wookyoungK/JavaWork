package com.lec.beans;

public class DAO {

	String uid; // DAO 객체 식별용 필드

	public DAO() {
		System.out.println("DAO() 생성");
	}

	public DAO(String uid) {
		super();
		System.out.printf("DAO(%s) 생성\n", uid);
		this.uid = uid;
	}

	@Override
	public String toString() {
		return String.format("[DAO: %s]", this.uid);
	}

}
