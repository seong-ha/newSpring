package com.yedam.java.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.java.test.mapper.AaaMapper;
import com.yedam.java.test.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{

	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional
	@Override
	public void insert() {
		aaaMapper.insert("101"); // 각각 commit; (이건 들어감)
		aaaMapper.insert("값"); // 각각 rollback; (이건 number가 아니라 실패해서 값 안들어감.
		// 이렇게 해서 어떤 것은 들어가고 어떤 것은 안 들어간다.
	}

	@Override
	public void test() {
		this.insert(); // 이거는 인터페이스구현기반으로 돌아가는 aop입장에서는 transactional 안먹는다.
		// 그래서 this를 쓸 수 밖에 없는 상황인데 쓰려면 이 메서드에도 transactional 붙여주면 된다.
		// 최종적으로 감싸는 부분에 transactional을 적어줘야한다.
	}
	
}
