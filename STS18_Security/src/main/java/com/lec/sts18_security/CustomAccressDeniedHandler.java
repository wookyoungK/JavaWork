package com.lec.sts18_security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccressDeniedHandler implements AccessDeniedHandler {


	//이거 패키지 하나 더만들어서  com.lec.sts18_security.security.CustomAccressDeniedHandler 이렇게해야하는디 잘못함
	//request , response 를 매개변수로 받기 때문에, 서블릿 APU 직접 이용하여 Handle 가능.
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		System.out.println("Access Denied Handler");
		System.out.println("redirect 합니다 ...");
		response.sendRedirect(request.getContextPath()+"/accessError");
		//이렇게 직접해줄수잇다는것
	}

}
