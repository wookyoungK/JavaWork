package com.lec.java.exception08;

// TODO : Exceptio 상속받은 예외 클래스 만들기
public class AgeInputException extends Exception {
	
	
	public AgeInputException() {
		super("점수 입력 오류");
		
	}
	
	public AgeInputException(String str) {
		super(str);
	}

	
} // end class AgeInputException
