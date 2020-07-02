package com.lec.sts19_rest.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import com.lec.sts19_rest.board.command.BCommand;
import com.lec.sts19_rest.board.command.BListCommand;

@RestController
@RequestMapping("/SPA")
public class SPAController {

	private BCommand command;
	private JdbcTemplate template;

	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

	@RequestMapping("/list.ajax")
	public BWriteDTO[] arrJSON() {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		BWriteDTO arr[] = new BWriteDTO[list.size()];
		return list.toArray(arr);
	}

	@RequestMapping("/index.do")
	public String list(Model model) {
		command = new BListCommand();
		command.excute(model);
		return "index.jsp";
	}

}
