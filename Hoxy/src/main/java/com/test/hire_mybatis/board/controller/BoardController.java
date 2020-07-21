package com.test.hire_mybatis.board.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.hire_mybatis.board.C;
import com.test.hire_mybatis.board.beans.BWriteDTO;
import com.test.hire_mybatis.board.command.BCommand;
import com.test.hire_mybatis.board.command.BDeleteCommand;
import com.test.hire_mybatis.board.command.BListCommand;
import com.test.hire_mybatis.board.command.BSelectCommand;
import com.test.hire_mybatis.board.command.BViewCommand;
import com.test.hire_mybatis.board.command.BWriteCommand;
import com.test.hire_mybatis.board.command.UpdateCommand;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BCommand command;
	
	private SqlSession sqlSession;
	
	

	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}
	
	@RequestMapping("/hirelist.do")
	public String list(Model model) {
		command = new BListCommand();
		command.excute(model);
		return "board/hirelist";
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
	public String update(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BSelectCommand().excute(model);
		return "board/update";
	}
	
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













