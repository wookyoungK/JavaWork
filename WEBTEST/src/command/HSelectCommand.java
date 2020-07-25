package com.lec.spring.hire.command;


import com.lec.spring.hire.beans.HWriteDTO;
import com.lec.spring.hire.beans.IWriteDAO;
import com.lec.spring.hire.domain.C;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Map;

public class HSelectCommand implements HCommand {

	@Override
	public void excute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer) map.get("uid");
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		HWriteDTO dto= dao.selectByUid(uid);
		model.addAttribute("select", Arrays.asList(dto));
		

	}

}
