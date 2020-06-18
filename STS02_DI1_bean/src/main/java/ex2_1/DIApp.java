package ex2_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.MessageBean;

public class DIApp {

	public static void main(String[] args) {
		
	
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("컨테이너 생성\n");

		OperatorBean operator=null;
		operator = ctx.getBean("op", OperatorBean.class);
		int value = operator.doOperate();
		System.out.println("결과:" + value);

		
		
		
		
		ctx.close(); //Application Context 컨테이너는 반드시close()!
		System.out.println("Main 종료");
	} // end main

}
