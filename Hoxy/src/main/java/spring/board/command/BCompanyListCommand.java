package com.lec.spring.board.command;

import com.lec.spring.board.beans.IWriteDAO;
import com.lec.spring.board.domain.C;
import org.springframework.ui.Model;


public class BCompanyListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("comlist", dao.selectCompany());
		
	}

}
