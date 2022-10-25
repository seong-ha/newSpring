package com.yedam.shj.users.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.shj.users.service.UsersService;
import com.yedam.shj.users.service.UsersVO;

@Controller
@RequestMapping("users")
public class UsersController {
	@Autowired
	UsersService usersService;
	
	@GetMapping("mainList")
	public String mainList(Model model) {
		List<UsersVO> list = usersService.getMainUsersList();
		model.addAttribute("list", usersService.getMainUsersList());
		return "users/mainList";
	}
	
	@GetMapping("loginForm")
	public String loginForm() {
		return "users/loginForm";
	}
	
	@PostMapping("loginCheck")
	@ResponseBody
	public String loginCheck(@RequestBody UsersVO usersVO) {
		String msg = usersService.loginCheck(usersVO);
		return msg;
	}
}
