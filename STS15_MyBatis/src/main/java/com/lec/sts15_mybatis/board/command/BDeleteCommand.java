package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void excute(Model model) {
		//Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object>map = model.asMap();
		int uid = (Integer)map.get("uid");
		
		
//		BWriteDAO dao = new BWriteDAO();
//		int delete = dao.deleteByUid(uid);
//		model.addAttribute("delete", delete);
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("delete", dao.deleteByUid(uid));
		

	}
	
//	 강사님꺼
//	Map<String, Object> map = model.asMap();
//	int uid = (Integer)map.get("uid");
//	BWriteDAO dao = new BWriteDAO();
//	
//	int cnt = dao.deleteByUid(uid);
//	model.addAttribute("result", cnt);	

}
