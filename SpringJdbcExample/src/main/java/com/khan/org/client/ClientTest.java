package com.khan.org.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khan.org.model.Employee;
import com.khan.org.service.EmployeeService;
import com.khan.org.serviceIml.EmployeeServiceImpl;

public class ClientTest {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = null;

		try {
			ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			EmployeeService employeeService = ctx.getBean(EmployeeServiceImpl.class);
			Employee employee = getEmployee();
			//employeeService.createEmployee(employee);
			//Employee employee2 = employeeService.getEmployeeById(103);
			//System.out.println(employee2);
			//employeeService.deletedAccount(108);
			//employeeService.updateEmailById(105, "khan@gmail.com");
			List<Employee> employees=employeeService.allEmployeeDetails();
			int cnt=1;
			for(Employee emp:employees) {
				System.out.println(cnt++ +" Employee Details: "+emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ctx != null) {
				System.out.println("Closed Application...");
				ctx.close();
			}
		}

	}

	public static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Khanzaid");
		employee.setEmail("zaidkhan7@gmail.com");
		employee.setGender("Male");
		employee.setSalary(40000.00);
		return employee;
	}

}
