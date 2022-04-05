package com.khan.client;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.model.Message;


public class ClientTest {

	public static void main(String[] args) {

		ApplicationContext applicationContext = null;

		try {
			applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			Object object=applicationContext.getBean(Message.class);
			Message message=(Message)object;
			System.out.println(message.getMessageid()+" "+message.getMessage());
			
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
