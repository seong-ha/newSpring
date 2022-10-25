package com.yedam.shj.users.service;

import java.util.Date;

import lombok.Data;

@Data
public class UsersVO {
	private String userId;
	private String userName;
	private String userPassword;
	private String userNic;
	private Date userDate;
	private String userPhone;
	private String userEmail;
	private String userType;
}
