package com.myhome.web.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAOP {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAOP.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
	
	// 조인포인트 설정 -> 포인트컷 으로 설정 : 포인트컷은 조인포인트의 집합.
	@Pointcut(value="execution(* com.myhome.web..*Controller.*(..))")
	private void loggingControllerCut() {}
	
	@Pointcut(value="execution(* com.myhome.web.*.service.*Service.*(..))")
	private void loggingServiceCut() {}
	
	@Pointcut(value="execution(* com.myhome.web.*.model.*DAO.*(..))")
	private void loggingDaoCut() {}
	
	@Pointcut(value="loggingControllerCut() || loggingServiceCut() || loggingDaoCut()")
	private void loggingMvcCut() {}
	
	// 어드바이스 작성 -> 메서드 생성
	@Before(value="loggingMvcCut()")
	public void beforeLogging(JoinPoint joinPoint) throws Exception {
		this._logging(joinPoint, "before");
	}
	
	@After(value="loggingMvcCut()")
	public void afterLogging(JoinPoint joinPoint) throws Exception {
		this._logging(joinPoint, "after");
	}
	
	private void _logging(JoinPoint joinPoint, String adviceType) throws Exception {
		Date date = new Date();
		
		String fullyClassName = joinPoint.getSignature().getDeclaringTypeName();	//클래스 이름
		String methodName = joinPoint.getSignature().getName();		//메서드 이름
		
		logger.info("[{}] - <<{}>>  - {}.{} ", dateFormat.format(date), adviceType.toUpperCase(), fullyClassName, methodName );

		if(logger.isDebugEnabled()) {
			for(Object arg: joinPoint.getArgs()) {
				logger.debug("[{}] - Argument Type : {}", dateFormat.format(date), arg.getClass().getSimpleName());
				logger.debug("[{}] - Argument Value : {}", dateFormat.format(date), arg);
			}
		}
	}
}
