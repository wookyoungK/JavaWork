package com.lec.sts13_jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.sts13_jdbc.board.C;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;
import com.lec.sts13_jdbc.board.command.BCommand;
import com.lec.sts13_jdbc.board.command.BDeleteCommand;
import com.lec.sts13_jdbc.board.command.BListCommand;
import com.lec.sts13_jdbc.board.command.BSelectCommand;
import com.lec.sts13_jdbc.board.command.BViewCommand;
import com.lec.sts13_jdbc.board.command.BWriteCommand;
import com.lec.sts13_jdbc.board.command.UpdateCommand;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BCommand command;
	private JdbcTemplate template;
	
	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		System.out.println("setTemplate() 호출");
		this.template = template;
		C.template = template;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		command = new BListCommand();
		command.excute(model);
		return "board/list";
	}
	
	@RequestMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	}
	
	@RequestMapping(value = "/writeOk.do", method = RequestMethod.POST)
	public String writeOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BWriteCommand().excute(model);
		return "board/writeOk";
	}
	
	@RequestMapping("/view.do")
	public String view(Model model, int uid) {
		model.addAttribute("uid", uid);
		command = new BViewCommand();
		command.excute(model);
		return "board/view";
	}
	
	@RequestMapping("/update.do")
	public String select(Model model, int uid) {
		model.addAttribute("uid", uid);
		command = new BSelectCommand();
		command.excute(model);
		return "board/update";
	}
	
	//내가수정한내용이기때문에 POST 방식
	@RequestMapping(value = "/updateOk.do", method = RequestMethod.POST)
	public String updateOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new UpdateCommand().excute(model);
		return "board/updateOk";
	}
	
	
	@RequestMapping("/deleteOk.do")
	public String delete(Model model, int uid) {
		model.addAttribute("uid", uid);
		command = new BDeleteCommand();
		command.excute(model);
		return "board/deleteOk";
	}
	
}













