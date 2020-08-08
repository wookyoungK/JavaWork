package com.lec.spring.board.command;

import java.util.Map;

import com.lec.spring.board.beans.IWriteDAO;
import com.lec.spring.board.domain.C;
import org.springframework.ui.Model;


public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
//		BWriteDAO dao = new BWriteDAO();
//		
//		int cnt = dao.deleteByUid(uid);
//		model.addAttribute("result", cnt);
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("result", dao.deleteByUid(uid));
		
	}

}














