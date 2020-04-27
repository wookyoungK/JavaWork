package com.lec.java.method09;

/*  Call By Value : 값에 의한 호출
 	Call By Reference : 참조에 의한 호출
 	
 	메소드 호출시 매개변수에 넘겨주는 값의 '복사' 가 발생.*****
 	주소가 복사됨! 
 	
 	복사가 일어난 것은 동일하나  prim(값) vs refer(주소) 인가 차이이다
 	그래서 refer에서는 값의 차이가 없다 stack 의 값이 사라지기 때문에 
 	자바에선
 	primitive type 이 매개변수 인 경우 Call By Value
 	 		: '값' 이 복사된다 
 	 		: 메소드에서 매개변수 값을 변경해도 호출한 원본 쪽은 변화 없슴
 	 		
 	reference type 이 매개변수 인 경우 Call By Reference 발생
 			: '주소' 가 복사된다.
 			: 메소드에서 매개변수 를 통해 변경하면 호출한 원본 쪽도 변화 발생
 	
 */
public class Method09Main {

	public static void main(String[] args) {
		System.out.println("Call By Value : 값에 의한 호출");
		System.out.println("Call By Reference : 참조에 의한 호출");

		int n =10;
		incNum(10);
		System.out.println("incNum(int) 호출후n : "+n);
		System.out.println();
		int [] arr = {10};
		incNum(arr);
		System.out.println("incNum(int[]) 호출후 arr[0] : "+ arr[0]);
		
		System.out.println("\n프로그램 종료");
	} // end main()
	public static void incNum(int value) {
		value++;
		System.out.println("incNum(int): "+value);
	}
	
	public static void incNum(int [] arr) {
		arr[0]++;
		System.out.println("intNum(int[]): " + arr[0]);
	}
	
} // end class
