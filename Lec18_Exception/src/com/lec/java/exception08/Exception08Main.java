package com.lec.java.exception08;

import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);

	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException {
		System.out.println("나이 입력:");
		int age = sc.nextInt();
		if (age < 0 || age>1000) {
			AgeInputException ex = new AgeInputException(age+"적절한값이아닙니다");
			throw ex;
		}

		// TODO : AgeInputException 을 throw 하기

		return age;

	} // end inputAge()

	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");
		
		int i= 0;
		while(i<3)
		try {

			int Age = inputAge();
			System.out.println("age = " + Age);
			i++;
		} catch (AgeInputException ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println("프로그램 종료...");

	} // end main()

} // end class Exception08Main
