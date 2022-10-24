package com.yedam.java.emp.service;

import java.util.List;

public interface EmpService {
	// 전체 조회
	List<EmpVO> selectAllEmp();
	// 단건 조회
	EmpVO selectOneEmp(EmpVO empVO);
	// 등록
	int insertEmpInfo(EmpVO empVO);
	// 수정
	int updateEmpSal(int empId);
	int updateEmpInfo(EmpVO empVO);
	// 삭제
	int deleteEmpInfo(int empId);
}
