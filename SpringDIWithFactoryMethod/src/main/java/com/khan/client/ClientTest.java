package com.khan.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.model.ATM;

public class ClientTest {

	public static void main(String[] args) {

		ApplicationContext applicationContext = null;

		try {
			applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			ATM atm=applicationContext.getBean(ATM.class);
			atm.printBalanceInformation("6764546787988987");
			
			
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
