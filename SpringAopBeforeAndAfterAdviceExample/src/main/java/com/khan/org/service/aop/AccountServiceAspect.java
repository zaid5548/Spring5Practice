package com.khan.org.service.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

import com.khan.org.model.Account;

public class AccountServiceAspect {

	private static Log log = LogFactory.getLog(AccountServiceAspect.class.getName());

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

	public void afterAdvice(JoinPoint joinpoint) {
		log.info("After Method: " + joinpoint.getSignature());
	}

}
