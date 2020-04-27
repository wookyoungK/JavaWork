package com.lec.java.static03;

public class Test {
	private int num;
	
	static int count = 0;
	
	//singleton패턴
	//기본생성자
	private Test() {
		count ++;
		System.out.println(count+"번째 인스턴스생성");
	}
	
	private static Test aa = null;
	public static Test getInstance() {
		if(aa == null) {
			aa = new Test(); //인스턴스생성 
		} //하나만생성하게 하도록 만든다.
		return aa;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
 
}
