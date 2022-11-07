package com.yedam.java.free;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

	@Test
	public void test() {
		// 스프링 표준 패스워드 암호화 인코더
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder();
		String pass = enco.encode("1111");
		System.out.println(pass); // 암호화된 패스워드
		System.out.println(enco.matches("1111", pass)); // 암호화 전 패스워드와 암호화된 패스워드 일치하는지 확인 
		;
	}
}
