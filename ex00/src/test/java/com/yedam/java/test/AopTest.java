package com.yedam.java.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.java.test.service.Cats;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AopTest {
	@Autowired
	Cats myCat;
	
	@Test
	public void aopTest() {
		System.out.println("===============");
		System.out.println(myCat.getName());
		
		System.out.println("1)");
		String catName = myCat.getName();
		
		System.out.println("\n2)");
		System.out.println(catName);
		
	}
	
	@Test
	public void aopTest2() {
		// Aop가 적용되려면 인터페이스가 있고 그 구현클래스 이렇게 되어야하는데,
		// 지금은 구현클래스에만 되어있으니. this를 써버리면 aop가 적용이 안 된다.
		myCat.printInfo();
		System.out.println("========");
		myCat.printData();
	}
}
