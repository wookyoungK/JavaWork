package com.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.lec.beans.CategoryDTO;
import com.lec.beans.AjaxWriteListJSON;
import com.lec.beans.CategoryDAO;

public class AjaxListCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		CategoryDTO [] dtoArr = (CategoryDTO []) request.getAttribute("list");
		AjaxWriteListJSON result = new AjaxWriteListJSON();
		
		if(dtoArr == null) {
			result.setStatus("FAIL");
		} else {
			result.setStatus("OK");
			result.setCount(dtoArr.length);
			result.setList(Arrays.asList(dtoArr));
		}
		


		ObjectMapper mapper = new ObjectMapper();// JSON 으로 매핑할 Mapper 객체

		try {
			String jsonString = mapper.writeValueAsString(result);

			response.setContentType("application/json; charset=utf-8"); // MIME 설정
			response.getWriter().write(jsonString); // response 보내기.
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end responseJSON2()

}
