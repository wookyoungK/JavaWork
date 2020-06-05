package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		WriteDAO dao = new WriteDAO(); // DAO 객체 생성
		WriteDTO[] arr = null;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 페이징 관련 세팅값들
		int page = 1; // 현재 페이지 (디폴트는 1 page)
		int pageRows = 8; // 한 '페이지' 에 몇개의 글을 리스트? (디폴트 8개)
		int writePages = 10; // 한 [페이징] 에 몇개의 '페이지' 를 표시? (디폴트 10)
		int totalCnt = 0; // 글은 총 몇개인지?
		int totalPage = 0; // 총 몇 '페이지' 분량인지?

		String param;
		param = request.getParameter("page");
		if (param != null && param.trim().length() != 0) {
			try {
				page = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		try {
			// 트랜직션수행
			arr = dao.select();

			// "list" 란 name 으로 request 에 arr 값 전달
			// 즉 request 에 담아서 컨트롤러에 전달되는 셈.
			request.setAttribute("list", arr);

		} catch (SQLException e) {
			// 만약 CP 사용한다면
			// NamingException 도 처리 해야함 .

			e.printStackTrace();
		}
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}

}
