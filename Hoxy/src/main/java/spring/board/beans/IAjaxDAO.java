package com.lec.spring.board.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
public interface IAjaxDAO {

	List<ReplyWriteDTO> select(int uid);
	int insertReply(String content, int buid, int cuid);
	int deleteByUid(int uid);
	int update(
            @Param("uid") int uid,
            @Param("content") String content);
}
