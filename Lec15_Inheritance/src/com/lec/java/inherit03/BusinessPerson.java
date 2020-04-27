package com.lec.java.inherit03;

//자바는 다중상속  허용하지않는다
//반드시 하나의 부모로부터만 상속받는다 
public class BusinessPerson extends Person {

	String company;

	public void showInfo() {
		whoAmI();
		System.out.println("회사는" + company + "입니다");
	}
}
