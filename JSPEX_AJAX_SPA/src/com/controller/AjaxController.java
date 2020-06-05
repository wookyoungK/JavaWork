package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.*;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxController() {
        super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ajaxAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ajaxAction(request, response);
	}

	protected void ajaxAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ajaxAction() 호출");
		request.setCharacterEncoding("utf-8");

		// 바구니에 돌아가면서 사탕을담는것으로 생각해보자

		// 컨트롤러는 다음 두개를 선택해야 한다.
		
		Command command = null; // 어떠한 커맨드? --? 어떠한 로직 수행.

		// URL로부터 URI, ContextPath, Command 분리
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		// 테스트 출력
		System.out.println("uri: " + uri);
		System.out.println("conPath: " + conPath);
		System.out.println("com: " + com);
		
		switch(com) {
		case "/list.ajax":   // A 글목록(페이징)
			new ListCommand().excute(request, response);
			new AjaxListCommand().excute(request, response);
			break;
		
		case "/view.ajax":  // B 글 읽기
			new ViewCommand().excute(request, response);
			new AjaxListCommand().excute(request, response);
			break;
			
		case "/writeOk.ajax": // C 글작성
			new WriteCommand().excute(request, response);
			new AjaxResultCommand().excute(request, response);
			break;
		
		case "/updateOk.ajax": // D 글 수정
			new UpdateCommand().excute(request, response);
			new AjaxResultCommand().excute(request, response);
			break;
		
		case "/deleteOk.ajax":  // F 글 삭제
			new DeleteCommand().excute(request, response);
			new AjaxResultCommand().excute(request, response);
			break;
		} // end switch
		
		
		}//end switch
	
}
