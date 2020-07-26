package com.test.hire_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.test.hire_mybatis.board.C;
import com.test.hire_mybatis.board.beans.BWriteDTO;
import com.test.hire_mybatis.board.beans.IWriteDAO;

public class UpdateCommand implements BCommand {

//	@Override
//	public void excute(Model model) {
//
//		 Map<String, Object> map = model.asMap(); BWriteDTO dto =
//		  (BWriteDTO)map.get("dto"); IWriteDAO dao =
//		  C.sqlSession.getMapper(IWriteDAO.class);
//
//		  model.addAttribute("result", dao.update(dto.getUid(), dto));
//
//	}
//
//}
//
//

	@Override
	public void excute(Model model) {
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("result", dao.update(dto.getUid(), dto));
	}

}









