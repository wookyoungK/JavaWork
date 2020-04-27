package com.lec.java.wrapper02;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");

		Integer num1 =10; //Integer.valueOf(10);   <--auto-boxing
		Integer num2 = 20; //거의 primitive와 비슷하게 동작한다 하지만 reference
		System.out.println(num1 + num2); //auto-unboxing
		System.out.println(num1.intValue()+num2.intValue()); //<< 자동으동작 num1+num2와같음 (명시를하지 않아도)
		System.out.println();
		Integer num3 = num1 + num2;
		Integer num30 =Integer.valueOf(num1.intValue()+num2.intValue()); //실제로는 이렇게 동작하지만 이렇게 복잡하게 쓰지않는다.
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
		
		Integer num4 = 100;  // Integer.valueOf(100);
		int n4 = num4;  // num4.intValue();
		System.out.println("n4 = " + n4);
		
		
		
		
		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");

		// TODO
		
		System.out.println();
		System.out.println("wrapper 클래스들");
		
		Long num100 =Long.valueOf(1000000000000L);
		Long num101= 100000000000000000L;
		
		Double num200 =3.14; //Double num20 =ValueOf(3.14)
		
		System.out.println(num1.intValue()); //unboxing
		System.out.println(num1.doubleValue());//내가 원하는 방식 (타입)으로 꺼낼수있다.
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class















