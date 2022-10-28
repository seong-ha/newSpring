package com.yedam.shj.users.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<UsersVO> getAdminUsersList() {
		return usersMapper.adminSelectUsersList();
	}
	
	@Override
	public Map<String, String> loginCheck(UsersVO usersVO) {
		Map<String, String> map = new HashMap<>();
		String msg = "";
		String type = "";
		
		// DB에서 가져온 아이디, 비번, 권한을 비교한 결과에 따라 msg 코드 return
		UsersVO vo = usersMapper.selectUsers(usersVO);
		if (vo == null) {
			msg = "id";
		} else if (!usersVO.getUserPassword().equals(vo.getUserPassword())) {
			msg = "pw";
		} else {
			msg = "success";
			type = vo.getUserType();
		}
		
		map.put("msg", msg);
		map.put("type", type);
		
		return map;
	}

	
	
}
