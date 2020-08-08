package com.lec.spring.board.command;

import com.lec.spring.board.beans.IAjaxDAO;
import com.lec.spring.board.domain.C;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		
		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class);
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		String param;
		
		param = request.getParameter("uid");
		int uid = Integer.parseInt(param);
		
		try {
			cnt = dao.deleteByUid(uid);
			if(cnt == 0) {
				message.append("[트랙잭셕 실패: 0 delete");
			} else {
				status = "OK";
			}	
		} catch (Exception e) {
			message.append("[트랜잭션 에러:" + e.getMessage() + "]");
		}
		
		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		
	}

}
