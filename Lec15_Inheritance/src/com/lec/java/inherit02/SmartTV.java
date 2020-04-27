package com.lec.java.inherit02;

//Basic TV로부터 상속받은 SmartTv
public class SmartTV extends BasicTV {
	String ip;

	public void displayInfo() {
		super.displayInfo();
		System.out.println("IP 주소: " + ip);

	}
}
