package com.lec.beans;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * 참고로,
 *   일전에 JSP Model2 에서 
 *   Command 라 배웠던 객체를 'Service 단' 이라고 한다.
 *   자동주입은 생성자 ,멤버변수 ,setter에  된다
 */

public interface Service {
}

class RegisterService implements Service {
	DAO dao;

	// 기본생성자는 없다

	public RegisterService(DAO dao) {
		System.out.printf("RegisterService(%s) 생성\n", dao.toString());
		this.dao = dao;
	}

	@Override
	public String toString() {
		return String.format("[RegisterService : %s]", dao.toString());
	}
}

// 기본생성자가 없는 Service 객체 다시 생성
class ReadService implements Service {
	DAO dao;

	// 기본생성자는 없다

	// 생성자에 @Autowired 자동주입
	// 매개변수 '타입' 과 일치하는 bean 객체가 자동 주입된다.
	@Autowired
	public ReadService(DAO dao) {
		System.out.printf("ReadService(%s) 생성\n", dao.toString());
		this.dao = dao;
	}

	@Override
	public String toString() {
		return String.format("[ReadService : %s]", dao.toString());
	}
}

class UpdateService implements Service {
	// 멤버변수에 @Autowired 자동주입
	// 멤버변수 '타입' 과 일치하는 bean 객체가 자동 주입된다.
	@Autowired
	DAO dao;

	// 기본생성자는 있다!
	public UpdateService() {
		System.out.println("UpdateService() 생성");
	}

	@Override
	public String toString() {
		return String.format("[UpdateService : %s]", dao.toString());
	}
}


class DeleteService implements Service {
	// 멤버변수에 @Autowired 자동주입
	// 멤버변수 '타입' 과 일치하는 bean 객체가 자동 주입된다.
	@Autowired
	DAO dao;

	// 기본생성자는 있다!
	public DeleteService() {
		System.out.println("DeleteService() 생성");
	}
	
	public void setDao(DAO dao) {
		System.out.printf("setDao(%s) 호출\n", dao.toString());
		this.dao=dao;
	}
	@Override
	public String toString() {
		return String.format("[DeleteService : %s]", dao.toString());
	}
	
	
	
	
}
