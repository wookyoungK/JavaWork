package com.lec.java.static02;

public class Test {
	int num; //인스턴스변수
	static int sNum; //클래스 변수(static 변수)
	
	// 인스턴스 메소드
	public void show() {
		System.out.println("인스턴스 num = " + num);
		System.out.println("클래스(static) sNum ="+sNum);
		
		
	}
	
	//클래스 메소드 (static)메소드
	public static void show2() {
		//System.out.println("인스턴스 num = " + num);
		//static는 static아닌것을 사용하면 error
		System.out.println("클래스(static) sNum ="+sNum);
		
	}
}
