package com.lec.beans;


//Person 빈(bean) 객체 정의  를 바꾸면 서버를  restart 해야한다!!!  여기에있는것이다 beab객체



// 만약 setName, setname이 있을경우 소문자를 먼저 찾는다
public class Person {
	private String name;
	private int age;
	private int id;
	private String gender;
	
	
	
	//기본 생성자 , 매개변수 생성자 ,  getter/setter
	//만약 기본생성자가 없다면 !! error --> usebean은 기본생성자를 호출하기때문에 에러  BeanBasic 가보면 밑에 적어놓음
	public Person() {
		super();
	}
	
	
	
	public Person(String name, int age, int id, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.gender = gender;
	}


//	setname 으로 바꾸어도 잘동작한다 --> 여기에서는 대소문자구분을 안하나부다
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
