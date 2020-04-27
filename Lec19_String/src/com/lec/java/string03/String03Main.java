package com.lec.java.string03;

/*  StringBuffer, StringBuilder

	 String 클래스는 immutable 클래스이고,  변수 주소가 변할수없다가아니라 M.A지역에 literal 값이 변할수없다는것이다
	 StringBuffer, StringBuilder는 mutable 클래스임


	 StringBuffer:
		Java ver 1.0부터 있던 클래스
		쓰레드에 안전(thread-safe), 속도가 느림
	
	 StringBuilder:
		Java 5부터 생긴 클래스
		쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
	
		그 외에는 StringBuffer와 StringBuilder는 같은 기능(메소드)을 갖고 있음
		

	** 웹 프로그래밍 등에선 문자열을 '붙여 나가며' 완성하는 동작을 많이 함
		실무에서는
			String 을 concat() (혹은 + 연산)하기 보다는
			StringBuffer 를 append() 하는 것을 더 많이 사용함  (성능 UP)
			
		※ 그러나 학습예제에선 예제단순화를 위해 String 을 기본적으로 사용하니 참조 바랍니다
 */
public class String03Main {

	public static void main(String[] args) {
		System.out.println("[1] StringBuffer, StringBuilder");
		// String 클래스는 immutable 클래스이고,
		// StringBuffer, StringBuilder는 mutable 클래스임
		
		System.out.println("[String: immutable]");

		String str1 = "Hello";
		String str2 = str1;
		
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		
		if(str1==str2) {
			System.out.println("동일 참조");
		}else {
			System.out.println("다른 참조");
		}
		
		System.out.println(str1.concat("java")); // H.A의 literal값이 변하는것이아니라 
												//  heap에 새로운 값이 생기는것이다 , 만들어지고나서 다시 바로사라진다!!!****
		
		System.out.println();
		System.out.println(str1);//hellojava가아니라 hello 출력  String는 변경불가 변수임!!!! 잠시 concat으로 붙여준것
		
		if(str1==str2) {
			System.out.println("동일 참조");
		}else {
			System.out.println("다른 참조");
		}

		
		str1 = str1.concat("JAVA"); //str1값인  hellojava가 사라지고 다른것이 str1에 저장되고 사라지지않는다 . 그결과 str2와 다른참조가 된다.!!
		System.out.println(str1);
		
		if(str1==str2) {
			System.out.println("동일 참조");
		}else {
			System.out.println("다른 참조");
		}
		
		
		
		
		
		
		System.out.println();
		System.out.println("[StringBuffer: mutable]"); 
		
		StringBuffer buff1 =new StringBuffer("Hello"); //
		StringBuffer buff2 =buff1;
		
		System.out.println("buff1 = "+ buff1);
		System.out.println("buff2 = "+ buff2);
		
		if(buff1==buff2) {
			System.out.println("==동일 참조");
		}else {
			System.out.println("==다른 참조");
		}
		
		System.out.println(buff1.append("java"));
		System.out.println(buff1);//허걱 바꼇답
		
		if(buff1==buff2) {
			System.out.println("==동일 참조");
		}else {
			System.out.println("==다른 참조");
		}
		
		System.out.println(buff2); //buff2도바뀌었다. 띠용!!
		
		
		
		// StringBuffer:
		//  Java ver 1.0부터 있던 클래스
		//  쓰레드에 안전(thread-safe), 속도가 느림
		
		// StringBuilder:
		// Java 5부터 생긴 클래스
		// 쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
		
		// 그 외에는 StringBuffer와 StringBuilder는 같은 기능을 갖고 있음
		
		
		StringBuilder buff3= new StringBuilder("Hello");
		System.out.println(buff3.append("Java"));
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












