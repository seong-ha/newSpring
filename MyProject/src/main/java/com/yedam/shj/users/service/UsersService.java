package com.yedam.shj.users.service;

import java.util.List;
import java.util.Map;

public interface UsersService {
	List<UsersVO> getMainUsersList();
	List<UsersVO> getAdminUsersList();
	Map<String, String> loginCheck(UsersVO usersVO);
}
