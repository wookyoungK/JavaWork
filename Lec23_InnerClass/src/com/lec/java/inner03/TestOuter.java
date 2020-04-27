package com.lec.java.inner03;

public class TestOuter {
	private int value;//1.이걸 출력
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	//멤버 내부 클래스
	public class TestInner{
		private int value;//2. 이걸출력
		
	public TestInner() {}
	public TestInner(int value) {
		this.value =value;
	}
	
	public void printValue() {
		int value =10;
		System.out.println("value ="+value); //***
		System.out.println("this.value= "+this.value);//****
		System.out.println("outer= "+TestOuter.this.value);
		//3번째것은 보기힘듬 ..: TestOuter에있는 인스턴스 변수의 값

	}
	
	
	
	
	
	}//end class TestInner

} // end class TestOuter














