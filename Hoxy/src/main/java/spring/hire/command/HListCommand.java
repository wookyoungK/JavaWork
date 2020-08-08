
package com.lec.spring.hire.command;


import com.lec.spring.hire.beans.HWriteDTO;
import com.lec.spring.hire.beans.IAjaxDAO;
import com.lec.spring.hire.domain.C;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class HListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class);
		List<HWriteDTO> arr = null;
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL

		// 페이징 관련 세팅값들
		int page = 1;  // 현재 페이지 (디폴트는 1 page)
		int pageRows = 5;   // 한 '페이지' 에 몇개의 글을 리스트? (디폴트 8개)
		int writePages = 7;  // 한 [페이징] 에 몇개의 '페이지' 를 표시? (디폴트 10)
		int totalCnt = 0;    // 글은 총 몇개인지?
		int totalPage = 0;   // 총 몇 '페이지' 분량인지?
		String param;



		// page 값 : 현재 몇 페이지?
		param = request.getParameter("page");
		if(param != null && param.trim().length() != 0) {
			try {
				page = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}

		// pageRows 값 :  '한 페이지' 에 몇개의 글?
		param = request.getParameter("pageRows");
		if(param != null && param.trim().length() != 0) {
			try {
				pageRows = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}

		param = request.getParameter("c_uid");
		int c_uid = Integer.parseInt(param);



		try {
			// 글 전체 개수 구하기
			totalCnt = dao.hcountAll();

			// 총 몇 페이지 분량인가?
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);

			// 몇번재 row 부터 ?
			int fromRow = (page - 1) * pageRows + 1;  // ORACLE 은 1부터 ROWNUM시작


			//dao = new WriteDAO();
//			arr = dao.selectHireList(c_uid);
			arr = dao.selectHireList(c_uid);

			if(arr == null) {
				message.append("[리스트할 데이터가 없습니다]");
			} else {
				status = "OK";
			}

		} catch(Exception e) {
			//e.printStackTrace();
			message.append("[트랜잭션 에러:" + e.getMessage()+ "]");
		} // end try

		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);

		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("writePages", writePages);
		request.setAttribute("pageRows", pageRows);
		request.setAttribute("totalCnt", totalCnt);

	} // end execute()
} // end Command






