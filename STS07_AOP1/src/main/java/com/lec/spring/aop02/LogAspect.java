package com.lec.spring.aop02;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.lec.beans.Logger;

//Aspect : Advisor 들을 모아놓은 객체
//Avisor : Advice + Pointcut
//Advice : 공통기능










//이 클래스가 Aspect 역할을 할 클래스 임을 명시
@Aspect
public class LogAspect {
	
	//Advisor 하나 구성 
	@Before("within(com.lec.spring.aop02.*)") //Pointcut
	public void beforeAdvice() {
		System.out.println("[Before] ");
		new Logger().logIn(); //공통코드. Advice!
	}

}
