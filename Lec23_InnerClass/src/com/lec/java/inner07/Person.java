package com.lec.java.inner07;


public class Person {
	// Person 외부 클래스의 멤버 변수
	private String name;
	
	// Person 외부 클래스의 생성자
	public Person(String name) {
		this.name = name;
	}
	
	/*
	public PersonAge createInstance(int age) {
		
		// Local inner class 
		class PersonAge{
			public void readInfo() {
				System.out.println("이름 " + name);
				System.out.println("나이 " + age);
			}
		}
		
		PersonAge p = new PersonAge();
		
		return p;
		
	} // end createInstance()
	*/
	
	/*
	 지역 클래스는 메소드 실행이 끝나게 되면 정의 자체가 사라지게 되는 클래스임.
	 메소드 내부에 정의된 지역 클래스 타입을 리턴하는 메소드는 만들 수 없다.
	 경우에 따라서는, 지역 클래스에 정의된 메소드를
	 외부에서 직접 사용하고자 하는 경우가 발생할 수도 있습니다.
	 그걸 가능하게 하는 방법이 
	
	 인터페이스(interface) + 다형성(polymorphism):
	 
	 1. 외부에서 사용하고 싶은 메소드를 선언한 인터페이스를 작성
	 2. 메소드의 리턴타입은 정의한 인터페이스 타입으로 정의
	 3. 로컬 클래스는 인터페이스를 구현(implements)하도록 정의
	 4. 로컬 클래스의 인스턴스를 생성하고 리턴해줌
	*/
	
	// 2.
	public Readable createInstance(int age) { //내부에서 Local inner inner를 만든것을 밖으로 꺼내놓은것
		// 익명 내부 클래스:
		// 인스턴스 생성과 동시에 클래스가 정의됨.
		// new 인터페이스() { 익명 클래스 내부 작성 }; 
		// new 부모클래스() { 익명 클래스 내부 작성 };
		return new Readable() { // new 생성자()  무조건 익명 클래스
			
			
			@Override
			public void readInfo() {
			System.out.println("이름: "+name);	
			System.out.println("나이: "+age);	
				
			}
		};
		//원래 인터페이스나 ,abstract 는 new로생성하거나 호출할수없음!!!
		
	} // end createInstance()
	
	

	
}  // end class Person

// 1. //내부에서 Local inner inner를 만든것을 밖으로 꺼내놓은것
interface Readable {
	public abstract void readInfo();
}

//인터페이스 뿐만아니라 추상메소드도 가능하다 abstract method
















