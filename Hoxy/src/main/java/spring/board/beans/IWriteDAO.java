package com.lec.spring.board.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IWriteDAO {
	List<BWriteDTO> select();
//	public List<BWriteDTO> selectByCategory(String categoryName);
List<String> selectCompany();
	int insert(final BWriteDTO dto);
//	public int insert(String subject, String content, String name);
//	public BWriteDTO readByUid(final int uid);

	BWriteDTO selectByUid(final int uid);
	int update(final BWriteDTO dto);
	int update(int uid, @Param("a") BWriteDTO dto);
	int deleteByUid(final int uid);

	int countAll(); // 전체 개수
	int countAllByCategory(String category); // 카테고리 개수
	int countAllBySearch(String word); // 제목+회사명 검색 개수
	int countAllBySearch2(String word); // 제목만검색개수
	int countAllBySearch3(String word); // 회사명만검색개수
	List<BWriteDTO> selectByPages(int from, int pageRows); // 전체뽑기
	List<BWriteDTO> selectByCategory(String categoryName, int from, int pageRows); // 카테고리별뽑기
	List<BWriteDTO> selectNotice(); // 공지뽑기
	List<BWriteDTO> selectBySearch(String word, int from, int pageRows); // 제목 + 회사명 검색 리스트
	List<BWriteDTO> selectBySearch2(String word, int from, int pageRows); // 제목 검색 리스트
	List<BWriteDTO> selectBySearch3(String word, int from, int pageRows); // 회사 검색 리스트
	int incViewCnt(int uid); // 조회수 증가

	BWriteDTO searchBySubject(String subject);
	int replyCnt(int uid);
	
}
