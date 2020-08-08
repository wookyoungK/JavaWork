package com.lec.spring.hire.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface IWriteDAO {


	public List<HWriteDTO> select();
	public List<HWriteDTO> adminselect();
	public int insert(final HWriteDTO dto);
	public HWriteDTO selectByUid(final int h_uid);
	public int update(int h_uid,@Param("a") HWriteDTO dto);
//	public int deleteByUid(final int h_uid);
	public int incViewCnt(int h_uid); // 조회수 증가



}
