package com.khan.org;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.khan.config.MySpringConfig;
import com.khan.model.Message;

public class ClientTest {
	public static void main(String[] args) {

		// BeanFactory beanFactory = null;
		ApplicationContext applicationContext = null;

		try {
			// creating Instance of ApplicationContext Spring Container
			applicationContext = new AnnotationConfigApplicationContext(MySpringConfig.class);

			// Asking Spring Container to return Spring bean with id "message"
			Object object = applicationContext.getBean("message");
			// Convert Spring bean into your business Object
			Message message = (Message) object;
			message.setMessageId(102);
			message.setMessage("Update Message...");
			// Print Spring bean state
			System.out.println(message.getMessageId() + "\t" + message.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(applicationContext!=null) {
				System.out.println("Application is Closed...");
				((AbstractApplicationContext) applicationContext).close();
			}
		}
	}
}
