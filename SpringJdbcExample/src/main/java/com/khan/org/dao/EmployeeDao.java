package com.khan.org.dao;

import java.util.List;

import com.khan.org.model.Employee;

public interface EmployeeDao {

	public abstract void createEmployee(Employee employee);
	public abstract Employee fetchEmployeeById(Integer employeeId);
	public abstract void deletedAccountById(Integer employeeId);
	public abstract void updateEmailById(Integer employeeId,String email);
	public abstract List<Employee> allEmployeeDetails();
}
