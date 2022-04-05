package com.khan.model;

public class Employee {

	private Integer employeeId;
	private String employeeName;
	private Double salary;

	private Address address;

	public Employee(Integer employeeId, String employeeName, Double salary, Address address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.address = address;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Double getSalary() {
		return salary;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary + ", address=" + address + "]";
	}

}
