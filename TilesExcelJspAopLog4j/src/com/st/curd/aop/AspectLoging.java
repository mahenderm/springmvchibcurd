package com.st.curd.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLoging {
	
	 Logger logger=Logger.getLogger(AspectLoging.class);
	
	@Around("execution(* com.st.curd.*.*.*(..))")
	public Object timeCount(ProceedingJoinPoint joinPoint){
		long startTime=System.currentTimeMillis();
		//System.out.println("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
	//logger.info("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		logger.trace("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		logger.info("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		logger.warn("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		logger.error("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		logger.fatal("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		logger.debug("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());

	Object obj=null;
	
	try {
		obj=joinPoint.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	long endTime=System.currentTimeMillis();
		//System.out.println("After method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		logger.info("After method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		//System.out.println(endTime-startTime);
		logger.info(endTime-startTime);
		return obj;
	}
	@AfterReturning(pointcut="execution(* com.st.curd.*.*.*(..))",returning="obj")
	public void afterReturning(JoinPoint joinPoint,Object obj){
		//System.out.println("After Returning::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		logger.info("After Returning::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		
	}
	
/*	
	@Around("execution(* com.st.curd.*.*.*(..))")
	public Object timeCount(ProceedingJoinPoint joinPoint){
		long startTime=System.currentTimeMillis();
		System.out.println("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
	

	Object obj=null;
	
	try {
		obj=joinPoint.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	long endTime=System.currentTimeMillis();
		System.out.println("After method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		
		System.out.println(endTime-startTime);
		return obj;
	}
	@AfterReturning(pointcut="execution(* com.st.curd.*.*.*(..))",returning="obj")
	public void afterReturning(JoinPoint joinPoint,Object obj){
		System.out.println("After Returning::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		
	}*/
	
	/*long startTime=0;
	@Before("execution(* com.st.curd.*.*.*(..))")
	public void beforeMethod(JoinPoint joinPoint){
		long startTime=System.currentTimeMillis();
		System.out.println("Before method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		
	}
	@After("execution(* com.st.curd.*.*.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		
		System.out.println("After method calling::"+joinPoint.getSignature().getName()+"::"+joinPoint.getTarget().getClass());
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}*/

}
