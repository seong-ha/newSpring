package com.yedam.java.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping("/allList")
	public String getEmpList(Model model) {
		model.addAttribute("empInfoList", empService.selectAllEmp());
		
		return "emp/empList";
	}
	
	@GetMapping("/info")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findEmp = empService.selectOneEmp(empVO);
		model.addAttribute("empInfo", findEmp);
		System.out.println(findEmp);
		return "emp/empInfo";
	}

	@GetMapping("insertForm")
	public String printInsertForm() {
		return "emp/insertForm";
	}
	
	@PostMapping("insert")
	public String empInsert(EmpVO empVO, RedirectAttributes ratt) {
		int result = empService.insertEmpInfo(empVO);
		
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 등록되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 등록되지 않았습니다.");
		}
		
		return "redirect:allList";
	}
	
	@PostMapping("updateSal")
	public String updateSal(@RequestParam int employeeId, RedirectAttributes ratt) {
		int result = empService.updateEmpSal(employeeId);
		
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 처리되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 처리되지 않았습니다.");
		}
		
		return "redirect:allList";
	}
	
	// pathVariable 방식
	@GetMapping(value="delete/{empId}", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String empDelete(@PathVariable Integer empId) {
		int result = empService.deleteEmpInfo(empId);
		String message = null;
		
		if (result == 1) {
			message = "사원번호 : " + empId + "정상적으로 삭제되었습니다.";
		} else {
			message = "사원번호 : " + empId + "정상적으로 삭제되지 않았습니다.";
		}
		
		return message;
	}
	
	@PostMapping("updateForm")
	public String printUpdateFrom(EmpVO empVO, Model model) {
		EmpVO findEmp = empService.selectOneEmp(empVO);
		model.addAttribute("empInfo", findEmp);
		return "emp/updateForm";
	}
	
	@PostMapping("updateEmpInfo")
	public String updateEmpInfo(EmpVO empVO, RedirectAttributes ratt) {
		int result = empService.updateEmpInfo(empVO);
		
		if (result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 처리되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 처리되지 않았습니다.");
		}
		
		return "redirect:allList";
	}
}
