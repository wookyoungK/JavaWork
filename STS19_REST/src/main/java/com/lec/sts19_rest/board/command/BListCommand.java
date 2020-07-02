package com.lec.sts19_rest.board.command;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.IWriteDAO;



public class BListCommand implements BCommand {

	@Override
	public void excute(Model model) {
//		BWriteDAO dao =new BWriteDAO();
//		List<BWriteDTO> list = dao.select();
//		model.addAttribute("list",list);
		
		//Mybatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class); //알아서 mybatis가 dao객체를 만들어서 준다!
		model.addAttribute("list",dao.select());
				
		

	}

}
