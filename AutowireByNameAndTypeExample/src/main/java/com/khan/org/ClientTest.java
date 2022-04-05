package com.khan.org;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.khan.model.Address;
import com.khan.model.Employee;

public class ClientTest {
	public static void main(String[] args) {

		// BeanFactory beanFactory = null;
		ApplicationContext applicationContext = null;

		try {
			// creating Instance of ApplicationContext Spring Container
			applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");


			// Asking Spring Container to return Spring bean with id "message"
			Object object = applicationContext.getBean("employee");
			// Convert Spring bean into your business Object
			Employee employee = (Employee) object;
			// Print Spring bean state
			System.out.println(employee);

			// Convert Spring bean into your business Object
			// Address address = (Address) applicationContext.getBean("address");
			Address address = employee.getAddress();
			// Print Spring bean state
			System.out.println(address);
			
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
