package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;



public class UpdateCommand implements BCommand {

	@Override
	public void excute(Model model) {
		Map<String, Object>map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		
//		BWriteDAO dao = new BWriteDAO();
//		int result = dao.update(dto);
//		model.addAttribute("result", result);
		
		//MyBatis 사용
				IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
				//model.addAttribute("result",dao.insert(dto));
				model.addAttribute("result",
						dao.update(dto.getSubject(), dto.getContent(), dto.getUid()));
		
		

	}

}
