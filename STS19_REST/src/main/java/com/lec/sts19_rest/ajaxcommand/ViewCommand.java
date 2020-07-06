package com.lec.sts19_rest.ajaxcommand;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IAjaxDAO;
public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		WriteDAO dao = new WriteDAO();
		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class); //mybatis 용 dao
		BWriteDTO dto = null;
		
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		String param = request.getParameter("uid");
		
		// 유효성 검사
		if(param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else {			
			try {
				int uid = Integer.parseInt(param);
				
				dao.incViewCnt(uid);  // 조회수 증가
				dto =dao.selectByUid(uid); // 읽기
				if(dto == null) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status = "OK";
				}
				
			} catch (NumberFormatException e) {  
				//e.printStackTrace();
				message.append("[유효하지 않은 parameter]");
			} catch (Exception e) {
				message.append("[예외발생:" + e.getMessage() + "]");
			}// end try
		} // end if

		request.setAttribute("list", Arrays.asList(dto));
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}

}











