package com.khan.org;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.khan.model.Message;

public class ClientTest2 {
	public static void main(String[] args) {

		// BeanFactory beanFactory = null;
		ApplicationContext applicationContext = null;

		/*
		 * try { //creating Instance of beanfactory Spring Container Resource resource =
		 * new ClassPathResource("ApplicationContext.xml"); beanFactory = new
		 * XmlBeanFactory(resource);
		 * 
		 * //Asking Spring Container to return Spring bean with id "message" Object
		 * object = beanFactory.getBean("message"); //Convert Spring bean into your
		 * business Object Message message = (Message) object; //Print Spring bean state
		 * System.out.println(message.getMessageId() + "\t" + message.getMessage()); }
		 * catch (Exception e) { e.printStackTrace(); }
		 */

		try {
			// creating Instance of ApplicationContext Spring Container
			applicationContext = new FileSystemXmlApplicationContext("classpath:ApplicationContext.xml");

			// Asking Spring Container to return Spring bean with id "message"
			Object object = applicationContext.getBean("message");
			// Convert Spring bean into your business Object
			Message message = (Message) object;
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
