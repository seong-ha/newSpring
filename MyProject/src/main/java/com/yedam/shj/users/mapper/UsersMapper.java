package com.yedam.shj.users.mapper;

import java.util.List;

import com.yedam.shj.users.service.UsersVO;

public interface UsersMapper {
	List<UsersVO> mainSelectUsersList();
	List<UsersVO> adminSelectUsersList();
	
	UsersVO selectUsers(UsersVO usersVO);
	int insertUsers(UsersVO usersVO);
	int updateUsers(UsersVO usersVO);
	int deleteUsers(UsersVO usersVO);
}
