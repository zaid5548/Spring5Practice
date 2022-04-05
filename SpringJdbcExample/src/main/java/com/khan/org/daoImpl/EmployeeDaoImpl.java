package com.khan.org.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.khan.org.dao.EmployeeDao;
import com.khan.org.maper.EmployeeRowMapper;
import com.khan.org.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createEmployee(Employee employee) {

		String SQL = "INSERT INTO employee_table (employee_name,email,gender,salary) VALUES(?,?,?,?);";
		int update = getJdbcTemplate().update(SQL, employee.getEmployeeName(), employee.getEmail(), employee.getGender(),
				employee.getSalary());
		if(update==1) {
			System.out.println("Employee is created...");
		}
	}

	public Employee fetchEmployeeById(Integer employeeId) {
		String SQL= "SELECT * FROM employee_table WHERE employee_Id=?";
		return getJdbcTemplate().queryForObject(SQL, new EmployeeRowMapper(), employeeId);
	}

	public void deletedAccountById(Integer employeeId) {
		String SQL= "delete from employee_table where employee_Id="+employeeId+""; 
		getJdbcTemplate().update(SQL);
	}

	public void updateEmailById(Integer employeeId, String email) {
		String SQL="UPDATE employee_table SET email=? where employee_Id=?";
		getJdbcTemplate().update(SQL,email,employeeId);
	}

	public List<Employee> allEmployeeDetails() {
		String SQL="SELECT * FROM employee_table";
		return getJdbcTemplate().query(SQL,new EmployeeRowMapper());
	}

}
