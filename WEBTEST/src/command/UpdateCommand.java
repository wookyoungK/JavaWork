package com.lec.spring.hire.command;

import com.lec.spring.hire.beans.HWriteDTO;
import com.lec.spring.hire.beans.IWriteDAO;
import com.lec.spring.hire.domain.C;
import org.springframework.ui.Model;

import java.util.Map;

public class UpdateCommand implements HCommand {

	@Override
	public void excute(Model model) {

		 Map<String, Object> map = model.asMap(); HWriteDTO dto =
		  (HWriteDTO)map.get("dto"); IWriteDAO dao =
		  C.sqlSession.getMapper(IWriteDAO.class);

		  model.addAttribute("result", dao.update(dto.getUid(), dto));

	}

}












