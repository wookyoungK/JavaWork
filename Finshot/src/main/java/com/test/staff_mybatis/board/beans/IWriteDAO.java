package com.test.staff_mybatis.board.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
@MapperScan
public interface IWriteDAO {


	public List<BWriteDTO> select(); 
	public int insert(final BWriteDTO dto);
	public BWriteDTO selectByUid(final int uid);
	public int update(int uid,@Param("a") BWriteDTO dto);
	public int deleteByUid(final int uid);
	



	
}
