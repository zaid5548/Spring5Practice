package com.khan.org;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.khan.model.Address;
import com.khan.model.Employee;

public class ClientTest2 {
	public static void main(String[] args) {

		// BeanFactory beanFactory = null;
		ApplicationContext applicationContext = null;

		try {
			// creating Instance of ApplicationContext Spring Container
			applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			System.out.println("1=======================================================");
			Object object=applicationContext.getBean("employee");
			Employee employee=(Employee)object;
			Address address=employee.getAddress();
			System.out.println(address);
			System.out.println("2=======================================================");
			Employee employee2=applicationContext.getBean(Employee.class);
			Address address2=employee2.getAddress();
			System.out.println(employee2);
			System.out.println(address2);
			System.out.println("3=======================================================");
			Employee employee3=applicationContext.getBean(Employee.class, 10001,"Zaid Khan",60000.00,address2);
			Address address3=employee3.getAddress();
			System.out.println(employee3);
			System.out.println(address3);
			System.out.println("4=======================================================");
			Employee employee4=applicationContext.getBean("employee", Employee.class);
			Address address4=employee4.getAddress();
			System.out.println(employee4);
			System.out.println(address4);
			System.out.println("5=======================================================");
			Object object2=applicationContext.getBean("employee", 10001,"Zaid Khan",60000.00,address2);
			Employee employee5=(Employee)object2;
			Address address5=employee5.getAddress();
			System.out.println(employee5);
			System.out.println(address5);
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
