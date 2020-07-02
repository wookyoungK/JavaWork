package com.lec.sts19_rest.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;



public class BViewCommand implements BCommand {

	@Override
	public void excute(Model model) {

		//Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object>map = model.asMap();
		int uid = (Integer)map.get("uid");
//		BWriteDAO dao = new BWriteDAO();
//		model.addAttribute("view", Arrays.asList(dto));
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		dao.incViewCnt(uid);
		
		BWriteDTO dto= dao.selectByUid(uid);
		model.addAttribute("view", Arrays.asList(dto));
		
	}

	

}
