package com.yedam.java.test.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		// Aop가 적용되는 메서드의 이름을 가져올게요.
		String signatureStr = joinpoint.getSignature().toString();
		System.out.println("시작 : " + signatureStr);
		
		// 공통기능
		System.out.println("핵심 기능 전에 실행할 공통 기능 : " + System.currentTimeMillis());
		
		try {
			Object obj = joinpoint.proceed(); // 핵심기능 실행
			return obj;
		} finally {
			System.out.println("핵심 기능 후에 실행할 공통기능 : " + System.currentTimeMillis());
			System.out.println("끝 : " + signatureStr);
		}
	}
}
