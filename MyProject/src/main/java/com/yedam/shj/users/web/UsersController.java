package com.yedam.shj.users.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.shj.users.service.UsersService;
import com.yedam.shj.users.service.UsersVO;

@Controller
@RequestMapping("users")
public class UsersController {
	@Autowired
	UsersService usersService;
	
	// 메인 페이지용 리스트
	@GetMapping("mainList")
	public String mainList(Model model) {
		model.addAttribute("list", usersService.getMainUsersList());
		return "users/mainList";
	}
	
	// 관리자 로그인 폼
	@GetMapping("loginForm")
	public String loginForm() {
		return "users/loginForm";
	}
	
	// 관리자 로그인 체그(아이디, 비번, 권한)
	@PostMapping("loginCheck")
	@ResponseBody
	public Map<String, String> loginCheck(UsersVO usersVO) {
		Map<String, String> map = usersService.loginCheck(usersVO);
		return map;
	}
	
	// 관리자 로그인 성공 후 관리자 페이지용 리스트
	@PostMapping("login")
	public String login(UsersVO usersVO, Model model) {
		System.out.println(usersVO.getUserType());
		model.addAttribute("list", usersService.getAdminUsersList());
		model.addAttribute("type", usersVO.getUserType());
		return "users/adminList";
	}
}
