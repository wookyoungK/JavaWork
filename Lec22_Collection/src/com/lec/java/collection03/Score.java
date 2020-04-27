package com.lec.java.collection03;

public class Score {
	private int korean;
	private int english;
	private int math; //매개변수
	
	public Score() {} //디폴트 생성자 
	public Score(int kor, int eng, int math) { //기본 생성자d
		this.korean = kor;
		this.english = eng;
		this.math = math;
	}
	
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	
} // end class Score
