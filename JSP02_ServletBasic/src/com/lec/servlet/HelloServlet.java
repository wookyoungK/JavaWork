package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/He")
//여기서는 url mapping하는방법을다른방법으로한것이다
//WEB-INF안의 web.xml 에서  url을 mapping하여 연결한것이다 
//실행시 주소창을보면 알수있다. 

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();

	}
		//get 방식으로 받을때!!
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		System.out.println("안녕하세요 첫번째 Servlet 입니다.");
		//서블릿으로 HTML , 문서 response 하기
		//1. content type 설정
		//2. PrintWriter 객체 생성 <-- response 객체로부터
		//3. PrintWriter 객체로 HTML 스트림에 쓰기.
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		
		// 우리는 html 로 보여주기때문에 기본 문법
		// setContentType는 --> 아래 HttpServletResponse 객체인 response 로 
		
		//출력 스트림 객체
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>서블릿 response</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>HTML문서 response</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
