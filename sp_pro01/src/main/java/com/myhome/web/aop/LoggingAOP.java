package com.myhome.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component	//bean 등록을 위한 어노테이션
@Aspect		//아래있는 클래스는 aop 클래스다.
public class LoggingAOP {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAOP.class);

	// 조인포인트 설정 -> 포인트컷으로 설정 : 포인트컷은 조인포인트의 집합.
	@Pointcut(value="execution(* com.myhome.web.*.controller.*Controller.*(..))")
	private void loggingCut() {}
	
	// 어드바이스 작성 -> 메서드 생성
	@Before(value="loggingCut()")
	public void beforeLogging(JoinPoint joinPoint) throws Exception {
		logger.info("loggingAOP Test");
	}
}
