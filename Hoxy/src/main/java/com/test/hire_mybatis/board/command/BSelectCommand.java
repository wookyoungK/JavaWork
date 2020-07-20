package com.test.hire_mybatis.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.test.hire_mybatis.board.C;
import com.test.hire_mybatis.board.beans.BWriteDTO;
import com.test.hire_mybatis.board.beans.IWriteDAO;

public class BSelectCommand implements BCommand {

	@Override
	public void excute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer) map.get("uid");
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto= dao.selectByUid(uid);
		model.addAttribute("select", Arrays.asList(dto));
		

	}

}
