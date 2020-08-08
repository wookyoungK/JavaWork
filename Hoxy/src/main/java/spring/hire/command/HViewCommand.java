package com.lec.spring.hire.command;


import com.lec.spring.hire.beans.HWriteDTO;
import com.lec.spring.hire.beans.IWriteDAO;
import com.lec.spring.hire.domain.C;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Map;


public class HViewCommand implements HCommand {

	@Override
	public void excute(Model model) {


//		int h_uid = (int) model.getAttribute("h_uid");
//		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
//
//		HWriteDTO dto= dao.selectByUid(h_uid);
//		model.addAttribute("view", Arrays.asList(dto));

		Map<String, Object>map = model.asMap();
		int h_uid = (Integer)map.get("h_uid");
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);

		HWriteDTO dto= dao.selectByUid(h_uid);
		dao.incViewCnt(h_uid);
		model.addAttribute("view", Arrays.asList(dto));

	}



}
