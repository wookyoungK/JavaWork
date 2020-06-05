package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class DeleteCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO(); //DAO 객체 생성
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		
		int cnt=0;
		int uid = Integer.parseInt(request.getParameter("uid"));
		// 매개변수 받아오기

		try {
			//트랜직션수행
			cnt= dao.deleteByUid(uid);
		
			request.setAttribute("delete", cnt);
			
		} catch(SQLException e) {

			e.printStackTrace();
		}
		
		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}


}