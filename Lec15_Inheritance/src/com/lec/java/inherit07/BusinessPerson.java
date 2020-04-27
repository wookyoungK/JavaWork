package com.lec.java.inherit07;

public class BusinessPerson extends Person {
	// 받아온 멤버까지 총 8개
	private String company;

	// getter & setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override // annotation : 애노테이션.
	public void showInfo() {
		super.showInfo();
		System.out.println("회사: " + company);
	}

	// 메소드 오버로딩 (Overloading)
	public void showInfo(int id) {
		System.out.println("id: " + id);
		showInfo();
	}
}

// 이클립스 단축키
// ALT + SHIFT + S, V

/*
 * @Override public void whoAreYou() { // TODO Auto-generated method stub
 * super.whoAreYou(); } 더이상 오버라이딩 불가
 * 
 * @Override public String toString() { return "BusinessPerson:" + getName() +
 * " " + company; }
 * 
 * }
 */
