package com.lec.spring.hire.controller;



import com.lec.spring.hire.beans.AjaxWriteList;
import com.lec.spring.hire.beans.AjaxWriteResult;
import com.lec.spring.hire.beans.HWriteDTO;
import com.lec.spring.hire.command.*;
import com.lec.spring.hire.domain.C;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/hire")
public class HireController {

	private HCommand command;

	private SqlSession sqlSession;

	public HireController() {
		super();
		System.out.println("hireController() 생성");
	}

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

/*	@RequestMapping("/hirelist.do")
	public String list(Model model) {
		command = new HListCommand();
		command.excute(model);
		return "hire/hirelist";
	}*/


	@RequestMapping("/write.do")
	public String write(Model model) {
		return "hire/write";
	}

	@RequestMapping(value = "/writeOk.do", method = RequestMethod.POST)
	public String writeOk(HWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new HWriteCommand().excute(model);
		return "hire/writeOk";
	}

	@RequestMapping("/view.do")
	public String view(Model model, int uid) {
		model.addAttribute("uid", uid);
		command = new HViewCommand();
		command.excute(model);
		return "hire/view";
	}

	@RequestMapping("/update.do")
	public String update(int uid, Model model) {
		model.addAttribute("uid", uid);
		new HSelectCommand().excute(model);
		return "hire/update";
	}

	@RequestMapping(value = "/updateOk.do", method = RequestMethod.POST)
	public String updateOk(HWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new UpdateCommand().excute(model);
		return "hire/updateOk";
	}

	@RequestMapping("/deleteOk.do")
	public String delete(Model model, int uid) {
		model.addAttribute("uid", uid);
		command = new HDeleteCommand();
		command.excute(model);
		return "hire/deleteOk";
	}
	/*
	 * @RequestMapping(value = "/fileupload.do", method = RequestMethod.POST) public
	 * void upload(MultipartFile uploadfile) { logger.info("upload() POST 호출");
	 * logger.info("파일 이름: {}", uploadfile.getOriginalFilename());
	 * logger.info("파일 크기: {}", uploadfile.getSize());
	 * 
	 * saveFile(uploadfile);
	 * 
	 * }
	 * 
	 * private String saveFile(MultipartFile file) { // 파일 이름 변경 UUID uuid =
	 * UUID.randomUUID(); String saveName = uuid + "_" + file.getOriginalFilename();
	 * 
	 * logger.info("saveName: {}", saveName);
	 * 
	 * // 저장할 File 객체를 생성(껍데기 파일)ㄴ File saveFile = new File(UPLOAD_PATH, saveName);
	 * // 저장할 폴더 이름, 저장할 파일 이름
	 * 
	 * try { file.transferTo(saveFile); // 업로드 파일에 saveFile이라는 껍데기 입힘 } catch
	 * (IOException e) { e.printStackTrace(); return null; }
	 * 
	 * return saveName; } // end saveFile(
	 */



	@RequestMapping("/hirelist.do")
	public AjaxWriteList list(HttpServletRequest request, HttpServletResponse response) {
		new HListCommand().excute(request, response);
		return buildList(request);
	} // end


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
