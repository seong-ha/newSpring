package com.yedam.java.free.service;

import java.util.List;
import java.util.Map;

public interface FBService {
	// 전체 조회
	List<FBVO> selectBoardList();
	// 단건 조회
	FBVO selectBoardInfo(FBVO fbVO);
	// 등록
	Map<String, Object> insertBoardInfo(FBVO fbVO);
	// 수정
	Map<String, Object> udpateBoardInfo(FBVO fbVO);
	// 삭제
	Map<String, Object> deleteBoardInfo(FBVO fbVO);
	// 입력될 게시글 조회
	int getBoardNo();
}
