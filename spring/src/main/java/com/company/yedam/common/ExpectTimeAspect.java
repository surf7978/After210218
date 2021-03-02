package com.company.yedam.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExpectTimeAspect {
	@Pointcut("execution(* com.company.yedam..*Impl.*One(..))") //selectOne의 *One임
	public void getpointcut() {}
	
	@Around("getpointcut()")
	public Object measure(ProceedingJoinPoint pjp) {
		System.out.println("[around] before");
		long start = System.nanoTime();
		Object result = null;
		try {
			result = pjp.proceed();
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			long finish = System.nanoTime(); //실행시간 :  704937100 = 0.7초
			System.out.println("[around] after 실행시간 :  "+(finish-start));
		}
		return result;
	}
}
