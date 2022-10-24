package com.yedam.java.emp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class EmpMapperTest {
	@Autowired
	EmpMapper empMapper;
	
	@Before
	public void testBefore() {
		System.out.println("★★★★★★★★★★ 시작 전 ★★★★★★★★★★");
	}
	
	@Test
	public void returnObjectTest() {
		assertNotNull(empMapper);
		
		System.out.println("★★★★★★★★★★ returnObjectTest 끝 ★★★★★★★★★★");
	}
	
	@Test
	public void empAllSelectTest() {
		List<EmpVO> list = empMapper.getEmpList();
		for (EmpVO empInfo : list) {
			System.out.println(empInfo.getLastName());
		}
		
		System.out.println("★★★★★★★★★★ empAllSelectTest 끝 ★★★★★★★★★★");
	}
	
	@Test
	public void empSelectTest() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		empVO = empMapper.getEmp(empVO);
		System.out.println(empVO.getLastName());
		
		System.out.println("★★★★★★★★★★ empSelectTest 끝 ★★★★★★★★★★");
	}
	
	//@Test
	public void empInsertTest() {
		EmpVO empVO = new EmpVO();
		empVO.setFirstName("kil-dong");
		empVO.setLastName("Hong");
		empVO.setEmail("hgd@google.com");
		empVO.setPhoneNumber("010-1234-1234");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(3800);
		
		empMapper.insertEmp(empVO);
		assertEquals(empVO.getEmployeeId(), 207);
		
		System.out.println("★★★★★★★★★★ empInsertTest 끝 ★★★★★★★★★★");
	}
	
	//@Test
	public void updateEmpSalaryTest() {
		int result = empMapper.updateEmpSalary(207);
		assertEquals(result, 1);
		
		System.out.println("★★★★★★★★★★ updateEmpSalaryTest 끝 ★★★★★★★★★★");
	}
	
	//@Test
	public void deleteEmpInfoTest() {
		int result = empMapper.deleteEmpInfo(207);
		assertEquals(result, 1);
		
		System.out.println("★★★★★★★★★★ deleteEmpInfoTest 끝 ★★★★★★★★★★");
	}
	
	@Test
	public void updateEmpInfoTest() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		empVO.setFirstName("fff");
//		empVO.setLastName("hh");
		empVO.setEmail("nana@gmail.com");
		int result = empMapper.updateEmpInfo(empVO);
		assertEquals(result, 1);
		
		System.out.println("★★★★★★★★★★ updateEmpInfoTest 끝 ★★★★★★★★★★");
	}
	
	@Test
	public void empSelectOne() {
		EmpVO empVO = new EmpVO();
		empVO.setFirstName("Steven");
		EmpVO selected = empMapper.getEmp(empVO);
		assertNotNull(selected);
		
		System.out.println("★★★★★★★★★★ empSelectOne 끝 ★★★★★★★★★★");
	}
	
}
