package com.yedam.shj.users.service;

import java.util.List;

public interface UsersService {
	List<UsersVO> getMainUsersList();
	List<UsersVO> getAdminUsersList();
	String loginCheck(UsersVO usersVO);
}
