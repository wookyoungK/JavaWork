package com.lec.java.hello;
/*
 * Java 첫 프로그램.
 * [학습목표]
 * - 기본 출력 : println(), print() 
 * - 주석 (Comment)
 */

//클래스
public class Hello {
	
	//실행문
	public static void main(String[] args) {
		System.out.println("Hello Java!!"); // 한줄 주석 : line comment
		System.out.println("안녕하세요");  // println() 은 화면 출력하고 한줄 띄기.
		
		System.out.println();
		
		System.out.println(1 + 2);
		System.out.println("1" + "2");
		System.out.println('A' + 'B');
		System.out.println('1' + 2);
		System.out.println();
		System.out.println('J' + "ava");
		
		System.out.println("보이세요");
		
		System.out.print("자바");
		System.out.print("프레임워크"); // 줄바꿈없이 ln 없음 출력값확인 
		System.out.println("풀스택 과정");
		System.out.println("융두랑같이");
		
	}
}

