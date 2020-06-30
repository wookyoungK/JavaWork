package com.lec.sts13_jdbc.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class UpdateCommand implements BCommand {

	@Override
	public void excute(Model model) {
		Map<String, Object>map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		BWriteDAO dao = new BWriteDAO();
		int result = dao.update(dto);
		model.addAttribute("result", result);

	}

}
