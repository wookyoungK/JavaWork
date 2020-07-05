package com.lec.sts19_rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import com.lec.sts19_rest.board.command.BCommand;
import com.lec.sts19_rest.board.command.BListCommand;

@RestController
@RequestMapping("/spa")
public class AJAXController {

	private BCommand command;
	private JdbcTemplate template;

	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

//	@RequestMapping("/listJSON")
//	public List<BWriteDTO> listJSON() {
//		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
//		return dao.select();
//	}

	@RequestMapping("/list.ajax")
	public BWriteDTO[] arrJSON() {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		BWriteDTO arr[] = new BWriteDTO[list.size()];
		return list.toArray(arr);
	}

	// JSON 데이터 <-- 자바 Map<k,v>
//	@RequestMapping("/mapJSON")
//	public Map<Integer, BWriteDTO> mapJSON() {
//		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
//		List<BWriteDTO> list = dao.select();
//
//		Map<Integer, BWriteDTO> map = new HashMap<Integer, BWriteDTO>();
//
//		for (BWriteDTO dto : list) {
//			map.put(dto.getUid(), dto);
//
//		}
//		return map;
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}//end class
