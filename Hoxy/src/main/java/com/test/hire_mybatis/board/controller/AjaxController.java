package com.test.hire_mybatis.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.hire_mybatis.board.beans.AjaxWriteList;
import com.test.hire_mybatis.board.beans.AjaxWriteResult;
import com.test.hire_mybatis.board.beans.BWriteDTO;
import com.test.hire_mybatis.board.command.BListCommand;



@RestController
@RequestMapping("/hire/*.ajax")
public class AjaxController {

	@RequestMapping("/hire/hirelist.ajax")
	public AjaxWriteList list(HttpServletRequest request, HttpServletResponse response) {
		new BListCommand().execute(request, response);
		return buildList(request);
	} // end 
	
	
	// response 할 메소드
	public AjaxWriteResult buildResult(HttpServletRequest request) {
		AjaxWriteResult result = new AjaxWriteResult();
		
		result.setStatus((String)request.getAttribute("status"));
		result.setMessage((String)request.getAttribute("message"));
		result.setCount((Integer)request.getAttribute("result"));
		
		return result;
	} // end execute()
	
	@SuppressWarnings("unchecked")
	public AjaxWriteList buildList(HttpServletRequest request) {
		List<BWriteDTO> list = (List<BWriteDTO>)request.getAttribute("list");
		
		AjaxWriteList result = new AjaxWriteList();
		result.setStatus((String)request.getAttribute("status"));
		result.setMessage((String)request.getAttribute("message"));
		
		if(list != null) {			
			result.setCount(list.size());
			result.setList(list);
		}

		// 페이징 할때만 필요한 것들.
		try {
			result.setPage((Integer)request.getAttribute("page"));
			result.setTotalPage((Integer)request.getAttribute("totalPage"));
			result.setWritePages((Integer)request.getAttribute("writePages"));
			result.setPageRows((Integer)request.getAttribute("pageRows"));
			result.setTotalCnt((Integer)request.getAttribute("totalCnt"));
		} catch(Exception e) {
			//e.printStackTrace();
		}
		
		return result;
	} // end buildList()
	
}
















