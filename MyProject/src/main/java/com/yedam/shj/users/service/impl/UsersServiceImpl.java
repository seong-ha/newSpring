package com.yedam.shj.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.shj.users.mapper.UsersMapper;
import com.yedam.shj.users.service.UsersService;
import com.yedam.shj.users.service.UsersVO;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	UsersMapper usersMapper;
	
	@Override
	public List<UsersVO> getMainUsersList() {
		return usersMapper.mainSelectUsersList();
	}

	@Override
	public String loginCheck(UsersVO usersVO) {
		String msg = "";
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
		// DB에서 가져온 아이디 비번과 비교한 결과에 따라 msg return
		UsersVO vo = usersMapper.selectUsers(usersVO);
		if (!usersVO.getUserId().equals(vo.getUserId())) {
			msg = "id";
		} else if (!usersVO.getUserPassword().equals(vo.getUserPassword())) {
			msg = "pw";
		} else {
			msg ="success";
		}
		return msg;
	}
	
}
