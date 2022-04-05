package com.khan.org.serviceIml;

import java.util.List;

import com.khan.org.daoImpl.EmployeeDaoImpl;
import com.khan.org.model.Employee;
import com.khan.org.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDaoImpl employeeDaoImpl;


	public EmployeeDaoImpl getEmployeeDaoImpl() {
		return employeeDaoImpl;
	}

	public void setEmployeeDaoImpl(EmployeeDaoImpl employeeDaoImpl) {
		this.employeeDaoImpl = employeeDaoImpl;
	}

	public void createEmployee(Employee employee) {
		getEmployeeDaoImpl().createEmployee(employee);
		
	}

	public Employee getEmployeeById(Integer employeeId) {
		
		return getEmployeeDaoImpl().fetchEmployeeById(employeeId);
	}

	public void deletedAccount(Integer employeeId) {
		getEmployeeDaoImpl().deletedAccountById(employeeId);
		
	}

	public void updateEmailById(Integer employeeId, String email) {
		getEmployeeDaoImpl().updateEmailById(employeeId, email);
		
	}

	public List<Employee> allEmployeeDetails() {
		return getEmployeeDaoImpl().allEmployeeDetails();
	}

}
