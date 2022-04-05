package com.khan.org.service.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.khan.org.model.Account;

@Aspect
@Service
public class AccountServiceAspect {

	private static Log log = LogFactory.getLog(AccountServiceAspect.class.getName());

	@Before(value="selectAll()")
	public void beforeAdvice(JoinPoint joinpoint) {
		Object[] args = joinpoint.getArgs();
		for (Object object : args) {
			if(object instanceof Account) {
				System.out.println((Account)object);
			}else if(object instanceof Long) {
				System.out.println("Amount to be transferred="+(Long)object);
			}
		}
		log.info("Before Method: " + joinpoint.getSignature());
	}

	@After(value="selectAll()")
	public void afterAdvice(JoinPoint joinpoint) {
		log.info("After Method: " + joinpoint.getSignature());
	}

	@Pointcut("execution(* com.khan.org.serviceImpl.AccountServiceImpl.*(..))")
	public void selectAll() {
		
	}
	
}
