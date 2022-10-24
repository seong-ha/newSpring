package com.yedam.java.user.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.java.user.service.UserVO;

@Controller
public class UserController {

	@RequestMapping(value = "inputForm", method = {RequestMethod.POST, RequestMethod.GET})
	public String inputForm(Model model) {
		return "inputForm";
	}
	
//	@RequestMapping("users")
//	public String process(UserVO uservo) {
//		System.out.println("이름 : " + uservo.getName());
//		System.out.println("나이 : " + uservo.getAge());
//		return "";
//	}
	
	// RequestParam 사용
//	@RequestMapping("users")
//	public String process(
//			@RequestParam("name") String userName, @RequestParam("age") int userAge) {
//		System.out.println("RequestParam 이름 : " + userName);
//		System.out.println("RequestParam 나이 : " + userAge);
//		return "";
//	}
	
	// Map 사용
	@RequestMapping("users")
	public String process(@RequestParam Map<String, Object> map) {
		System.out.println("Map<String, Object> 이름 : " + map.get("name"));
		System.out.println("Map<String, Object> 나이 : " + map.get("age"));
		return "";
	}
	
	// RequestParam으로 배열 처리
	@RequestMapping("nameList")
	public String nameProcess(@RequestParam List<String> name) {
		for (String temp : name) {
			System.out.println(temp);
		}
		return "";
	}
	
	// List를 가지고 있는 객체
//	@RequestMapping("userList")
//	public String listProcess(UserListVO userListVO) {
//		for (UserVO uservo : userListVO.getList()) {
//			System.out.println("이름 : " + uservo.getName());
//			System.out.println("나이 : " + uservo.getAge());
//		}
//		return "";
//	}
	
	@RequestMapping("userList")
	public String listProcess(@RequestBody List<UserVO> userList) {
		for (UserVO uservo : userList) {
			System.out.println("이름 : " + uservo.getName());
			System.out.println("나이 : " + uservo.getAge());
		}
		return "";
	}
	
	
}
