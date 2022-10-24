package com.yedam.java.free.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.free.service.FBService;
import com.yedam.java.free.service.FBVO;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	
	@Autowired
	FBService fbService;
	
	// 등록 - form
	@GetMapping("insert")
	public String insertForm(Model model) {
		model.addAttribute("no", fbService.getBoardNo());
		return "freeBoard/insertForm";
	}
	
	// 등록 - DB insert
	@PostMapping("insert")
	public String insert(FBVO fbVO, RedirectAttributes ratt) {
		Map<String, Object> result = fbService.insertBoardInfo(fbVO);
		ratt.addFlashAttribute("msg", result.get("result") + "건이 등록되었습니다.");
		return "redirect:list";
	}
	
	// 전체 조회
	@GetMapping("list")
	public String selectFreeBoardList(Model model) {
		model.addAttribute("fbList", fbService.selectBoardList());
		return "freeBoard/boardList";
	}
	
	// 단건 조회
	@GetMapping("info")
	public String selectFreeBoard(FBVO fbvo, Model model) {
		model.addAttribute("board", fbService.selectBoardInfo(fbvo));
		return "freeBoard/boardInfo";
	}

	// 수정 - form
	@PostMapping("updateForm")
	public String updateForm(FBVO fbVO, Model model) {
		System.out.println("왔니");
		model.addAttribute("board", fbService.selectBoardInfo(fbVO));
		return "freeBoard/updateForm";
	}
	
	// 수정 - DB update
	@PostMapping("update")
	public String update(FBVO fbVO, RedirectAttributes ratt) {
		Map<String, Object> result = fbService.udpateBoardInfo(fbVO);
		ratt.addFlashAttribute("msg", result.get("result") + "건이 수정되었습니다.");
		return "redirect:list";
	}
	
	// 삭제
	@PostMapping("delete")
	public String delete(FBVO fbVO, RedirectAttributes ratt) {
		Map<String, Object> result = fbService.deleteBoardInfo(fbVO);
		ratt.addFlashAttribute("msg", result.get("result") + "건이 삭제되었습니다.");
		return "redirect:list";
	}
}
