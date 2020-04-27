package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.********
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.*****
	 방법 2) 익명클래스***
	 방법 3) 람다 표현식 lambda expression***
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		
//		 방법 1) 클래스 implements 인터페이스 + 오버라이딩.*****
		//덧셈연산
		Operable operate2 =new Op();
		double result = operate2.Operate(1, 2);
		System.out.println("클래스 implements 인터페이스 + 오버라이딩\n = "+result);
		
//		 방법 2) 익명클래스***
		Operable operate3 =new Operable() {
			@Override
			public double Operate(double x, double y) {
				return x-y;
			}
		};
		result = operate3.Operate(2, 3);
		System.out.println("익명클래스 \n= "+result);
		
		
//		 방법 3) 람다 표현식 lambda expression***
		Operable operate4 = (x,y) ->Math.pow(2, 3); 
		result=operate4.Operate(2, 3);
		System.out.println("람다 표현식 lambda expression\n"+result);
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class




//public 는 항상 ㅍ자기파일이름이랑 같아야한다
//인터페이스 추상메소드 하는법
interface Operable{
	
	public abstract double Operate(double x, double y);
	
}

class Op implements Operable{

	@Override
	public double Operate(double x, double y) {

		return x+y;
	}

}