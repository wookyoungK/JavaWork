package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/InitS"},
		initParams= {
				@WebInitParam(name = "id", value = "test1"),
				@WebInitParam(name = "pw", value = "1000"),
				@WebInitParam(name = "local", value = "san")
		}


		) // web.xml과 동시에 사용불가 
			//2.방법2: Servlet 파일에 초기화 파라미터를 직접 기술하는 방법


public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InitServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletConfig의 메소드를 사용
		//왜 굳이 이렇게사용하는가  생각해보기 (유지보수적 측면)
		//방법1: web.xml에 초기화 파라미터 기술하는 방법
		String id =getInitParameter("id");
		String pw =getInitParameter("pw");
		String local =getInitParameter("local");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("id : "+id+"<br>");
		out.println("pw : "+pw+"<br>");
		out.println("local : "+local+"<br>");
		
		out.close();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
