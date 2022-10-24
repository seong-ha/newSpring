package com.yedam.java.free.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.java.free.service.FBVO;

public interface FBMapper {
	// 전체 조회
	List<FBVO> getBoardList();
	// 단건 조회
	FBVO getBoardInfo(FBVO fbVO);
	// 등록
	int insertBoard(FBVO fbvo);
	// 수정
	int updateBoard(FBVO fbvo);
	// 삭제
	int deleteBoard(@Param("bno") int boardNo);
	
	// 등록 시 입력된 게시글 번호 기반으로 최대값을 return 하게끔
	// 입력될 게시글 번호를 조회(현재 게시글번호 최고값)
	FBVO getBoardNo();
}
