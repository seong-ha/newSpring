package com.yedam.shj.users.service;

import java.util.Date;

import lombok.Data;

@Data
public class NotesVO {
	private Date updateDate;
	private String updateUser;
	private String updateContent;
}
