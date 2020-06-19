package com.lec.spring.profile4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileMain4 {

	public static void main(String[] args) {
		String config ="dev";
		//해당 프로필일때만 가능  run//dev 둘중하나선택
		
		GenericXmlApplicationContext ctx=
				new GenericXmlApplicationContext();
		//현재 활성화할 profile 이 무엇인지 세팅
		ctx.getEnvironment().setActiveProfiles(config);
		
		ctx.load("appCtx4_dev.xml", "appCtx4_run.xml");
		ctx.refresh();
		
		ServiceInfo info = ctx.getBean("serverInfo", ServiceInfo.class);
		System.out.println("ip:" + info.getIpNum());
		System.out.println("port:" + info.getPortNum());

	}

}
