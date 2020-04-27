package com.lec.java.wrapper05;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다. 거의만능
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 */
public class Wrapper05Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");

		Object[] obj = new Object[5];
		obj[0] = new Wrapper05Main(); // object는 최상위 이기때문에 인스턴스로 생성가능 반대경우는 ㅌxxxx
		obj[1] = new A();
		obj[2] = new A2();
		obj[3] = new B();
		obj[4] = 123; // object가 primitive type도 받을수 있다!?
						// 이유 : auto-boxing + polymorphism(다형성)
						//Object <-- Integer <--int

		System.out.println();
		
		for(Object e: obj) {
			System.out.println(e);
		} //Wrapper 는 자동적으로 auto -unboxing 발생
		
		System.out.println();
		//int num = obj[4] *3;  object로인식
		int num =(Integer) obj[4] *3;//형변환해주면 간으
		
		System.out.println("\n프로그램 종료");
	} // end main()

	// TODO

} // end class

class A {
}

class A2 extends B {
}

class B {
}