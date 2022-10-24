package com.yedam.java.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.java.emp.service.EmpVO;	

public interface EmpMapper {
	// 전체조회
	List<EmpVO> getEmpList();
	// 단건조회: 조회조건 - EmpVO  (조회조건 적어주는 게 좋다.)
	EmpVO getEmp(EmpVO empVO);
	// 등록
	int insertEmp(EmpVO empVO);
	// 수정 - 수정내용 : 연봉 10% 인상 (수정조건 적어주는 게 좋다.)
	int updateEmpSalary(@Param("eId") int employeeId);
	// 수정2 - 수정내용 : 사원정보를 받아서 이름, 성, 이메일을 수정(골라서도 수정가능)
	int updateEmpInfo(EmpVO empVO);
	// 삭제
	int deleteEmpInfo(int employeeId);
}
