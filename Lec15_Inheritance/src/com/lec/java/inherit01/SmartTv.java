package com.lec.java.inherit01;

public class SmartTv {
	//basci에잇는 변수들을 상속시켜서 사용하는것
	//자바의 장점 비슷한 코드를 반복저으로 입력하지않고 불러와서 사용하는것
	//상속!!!
	//멤버변수
	boolean isPowerOn;
	int channel;
	int volume;
	String ip; // SmartTV 에서 새로이 추가된 필드
	
	//메소드
	public void displayInfo() {
		System.out.println("--- TV 현재 상태 ---");
		System.out.println("전원: " + isPowerOn);
		System.out.println("채널: " + channel);
		System.out.println("볼륨: " + volume);
		System.out.println("IP주소: " + ip); // SmartTV에서 추가된 코드
	}
}
