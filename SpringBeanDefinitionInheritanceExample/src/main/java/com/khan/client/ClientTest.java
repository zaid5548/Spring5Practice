package com.khan.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.model.Employee;

public class ClientTest {

	public static void main(String[] args) {

		ApplicationContext applicationContext = null;

		try {
			applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			Object object = applicationContext.getBean(Employee.class);
			Employee employee = (Employee) object;
			System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getGender() + " "
					+ employee.getDepartmentName() + " " + employee.getSalary());
			System.out.println(employee);
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
