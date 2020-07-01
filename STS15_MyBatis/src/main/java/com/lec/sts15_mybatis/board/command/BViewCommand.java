package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;



public class BViewCommand implements BCommand {

	@Override
	public void excute(Model model) {

		//Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object>map = model.asMap();
		int uid = (Integer)map.get("uid");
//		BWriteDAO dao = new BWriteDAO();
//		BWriteDTO dto= dao.readByUid(uid);
//		model.addAttribute("view", Arrays.asList(dto));
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("select",
				dao.selectByUid(uid));
		
	}

	

}
