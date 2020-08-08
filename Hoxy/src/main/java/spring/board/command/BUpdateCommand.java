package com.lec.spring.board.command;

import java.util.Map;

import com.lec.spring.board.beans.BWriteDTO;
import com.lec.spring.board.beans.IWriteDAO;
import com.lec.spring.board.domain.C;
import org.springframework.ui.Model;



public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
//		BWriteDAO dao = new BWriteDAO();
//		int cnt = dao.update(dto);
//		model.addAttribute("result", cnt);
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
//		model.addAttribute("result", dao.update(dto));
	
		model.addAttribute("result", dao.update(dto.getUid(), dto));
		
	}

}












