package com.lec.java.inner02;

public class Car {
	// 멤버 변수( outer )
	private String color;
	
	// 생성자
	public Car(String color) {
		this.color = color;
	}
	
	// 메소드
	public void displayCarInfo() {
		System.out.println("color: " + color);
	}
	//멤버 내부 클래스
	public class Tire{
		private int radius;
		
		public Tire() {}
		public Tire(int radius) {
			this.radius = radius;
		}
		
		public void dispalyInfo() {
			System.out.println("---자동차 정보---");
			System.out.println("color : "+color); //아우터 쪽
			System.out.println("tire : "+radius); // 이너
		}
	}
	
	
} // end class Car











