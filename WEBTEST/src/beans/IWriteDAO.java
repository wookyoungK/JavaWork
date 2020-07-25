package com.lec.spring.hire.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface IWriteDAO {


	// 페이징용 SELECT
	// from : 몇번재 row 부터
	// pageRows : 몇개의 데이터(게시글)
	public List<HWriteDTO> selectFromRow(
			@Param("from") int from,
			@Param("pageRows") int pageRows
	);
	// 전체글의 개수
	public int countAll();


	public List<HWriteDTO> select();
	public int insert(final HWriteDTO dto);
//	public int insert(String name, String title, String salary,String position1, String position2, String part,String career, String degree, String workform,String upDate, String regDate);
	public HWriteDTO selectByUid(final int uid);
	public int update(int uid,@Param("a") HWriteDTO dto);
	public int deleteByUid(final int uid);
	


}
