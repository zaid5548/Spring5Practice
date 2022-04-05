package com.khan.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.org.model.Account;
import com.khan.org.service.AccountService;
import com.khan.org.serviceImpl.AccountServiceImpl;


public class ClientTest {

	public static void main(String[] args) {

		ApplicationContext applicationContext = null;

		try {
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			AccountService accountService=applicationContext.getBean("accountService", AccountServiceImpl.class);
			accountService.updateAccountBalance(new Account("8765646788899", "Money Transfer"), 10000L);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (applicationContext != null) {
				System.out.println("Application is Closed...");
				((AbstractApplicationContext) applicationContext).close();
			}
		}

	}

}
