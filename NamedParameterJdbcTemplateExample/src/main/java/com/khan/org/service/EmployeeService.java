package com.khan.org.service;

import java.util.List;

import com.khan.org.model.Employee;

public interface EmployeeService {

	public abstract void createEmployee(Employee employee);
	public abstract List<Employee> getEmployeeById(Integer employeeId);
	public abstract void deletedAccount(Integer employeeId);
	public abstract void updateEmailById(Integer employeeId,String email);
	public abstract List<Employee> allEmployeeDetails();
}
