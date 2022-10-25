package com.yedam.java.test.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {
	@Insert("INSERT INTO aaa VALUES (#{value})")
	void insert(String value);
}
