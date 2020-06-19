package com.lec.spring.config04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//4.Java에서 XML 포함 설정
public class ConfigMain04 {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig04.class);
		
		
		
		//XML 에서 설정
		System.out.println(ctx.getBean("score1"));
		
		//Java에서 설정
		System.out.println(ctx.getBean("score2"));
		
		ctx.close();

	}

}
