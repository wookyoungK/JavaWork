package com.lec.spring.board.command;

import java.util.Arrays;
import java.util.Map;

import com.lec.spring.board.beans.IWriteDAO;
import com.lec.spring.board.domain.C;
import org.springframework.ui.Model;



public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		System.out.println(uid);
//		BWriteDAO dao = new BWriteDAO();
//		BWriteDTO dto = dao.readByUid(uid);
//		model.addAttribute("list", Arrays.asList(dto));
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		dao.incViewCnt(uid);
		model.addAttribute("list", Arrays.asList(dao.selectByUid(uid)));
		
		
		// Arrays.asList(new String[]{"aaa", "bbb"})
		// Arrays.asList("aaa", "bbb")

	}

}















