package com.khan.org;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.khan.info.CollectionInfo;
import com.khan.model.Address;
import com.khan.model.Employee;

public class ClientTest {
	public static void main(String[] args) {

		// BeanFactory beanFactory = null;
		ApplicationContext applicationContext = null;

		try {
			// creating Instance of ApplicationContext Spring Container
			applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

			CollectionInfo collectionInfo=applicationContext.getBean(CollectionInfo.class);
			
			System.out.println("-----------Get Names----------------------");
			List<String> names=collectionInfo.getNames();
			names.forEach(System.out::println);
			
			System.out.println("-----------Get EmployeeList----------------------");
			List<Employee> employees=collectionInfo.getEmployeeList();
			employees.forEach(System.out::println);
			
			System.out.println("-----------Get EmployeeSet----------------------");
			Set<Employee> employeeSet=collectionInfo.getEmployeeSet();
			employeeSet.forEach(System.out::println);
			System.out.println("-----------Get Employee,Address Map----------------------");
			Map<Employee, Address> emMap=collectionInfo.getEmployeeAddressMap();
			emMap.forEach((employee,address)->{
				System.out.println(employee);
				System.out.println(address);
			});
			System.out.println("-----------Get Properties----------------------");
			Properties stateCapital=collectionInfo.getStateCapital();
			stateCapital.forEach((state,capital)->{
				System.out.println(state);
				System.out.println(capital);
			});
			
			System.out.println("-----------Get Employee Array----------------------");
			Employee[] employeeArray=collectionInfo.getEmployeeArray();
			for(Employee employee:employeeArray) {
				System.out.println(employee);
			}
			
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
