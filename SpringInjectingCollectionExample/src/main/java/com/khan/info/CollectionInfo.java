package com.khan.info;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.khan.model.Address;
import com.khan.model.Employee;

public class CollectionInfo {

	private List<String> names;
	private List<Employee> employeeList;
	private Set<Employee> employeeSet;
	private Map<Employee, Address> employeeAddressMap;
	private Properties stateCapital;
	private Employee employeeArray[] = new Employee[2];
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	public Map<Employee, Address> getEmployeeAddressMap() {
		return employeeAddressMap;
	}
	public void setEmployeeAddressMap(Map<Employee, Address> employeeAddressMap) {
		this.employeeAddressMap = employeeAddressMap;
	}
	public Properties getStateCapital() {
		return stateCapital;
	}
	public void setStateCapital(Properties stateCapital) {
		this.stateCapital = stateCapital;
	}
	public Employee[] getEmployeeArray() {
		return employeeArray;
	}
	public void setEmployeeArray(Employee[] employeeArray) {
		this.employeeArray = employeeArray;
	}
	
}
