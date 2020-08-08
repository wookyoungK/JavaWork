package com.lec.spring.hire.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.spring.hire.beans.AjaxWriteList;
import com.lec.spring.hire.beans.AjaxWriteResult;
import com.lec.spring.hire.beans.HWriteDTO;
import com.lec.spring.hire.command.DeleteCommand;
import com.lec.spring.hire.command.HListCommand;
import com.lec.spring.hire.command.HSearchCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hire/*.ajax")
public class WAjaxController {

	@RequestMapping("/hire/hirelist.ajax")
	public AjaxWriteList hirelist(HttpServletRequest request, HttpServletResponse response) {
		new HListCommand().execute(request, response);
		return buildList(request);
	} // end
	@RequestMapping("/hire/hireSearch.ajax")
	public AjaxWriteList hireSearch(HttpServletRequest request, HttpServletResponse response) {
		new HSearchCommand().execute(request, response);
		return buildList(request);
	} // end

	@RequestMapping(value= "/hire/deleteOk.ajax", method= RequestMethod.POST)
	public AjaxWriteResult deleteOk(HttpServletRequest request, HttpServletResponse response) {
		new DeleteCommand().execute(request, response);
		return buildResult(request);
	}
	
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
		List<HWriteDTO> list = (List<HWriteDTO>)request.getAttribute("list");
		
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
















