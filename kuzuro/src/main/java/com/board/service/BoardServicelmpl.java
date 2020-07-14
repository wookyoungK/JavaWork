package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServicelmpl implements BoardService {

	@Inject
	private BoardDAO dao;

	public List<BoardVO> list() throws Exception {

		return dao.list();
	}

	public void write(BoardVO vo) throws Exception {

		dao.write(vo);
	}
	
	public BoardVO view(int bno ) throws Exception {

		return dao.view(bno);
	}
	public void modify(BoardVO vo ) throws Exception {
		
		dao.modify(vo);
	}
	public void delete(int bno ) throws Exception {
		
		dao.delete(bno);
	}
	public int count( ) throws Exception {
		
		return dao.count();
	}

}