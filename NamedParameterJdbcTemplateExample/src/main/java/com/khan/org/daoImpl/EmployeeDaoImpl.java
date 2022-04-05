package com.khan.org.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.khan.org.dao.EmployeeDao;
import com.khan.org.maper.EmployeeRowMapper;
import com.khan.org.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void createEmployee(Employee employee) {

		String SQL = "INSERT INTO employee_table (employee_name,email,gender,salary) VALUES(:employeeName,:email,:gender,:salary);";
		/*int update = getJdbcTemplate().update(SQL, employee.getEmployeeName(), employee.getEmail(), employee.getGender(),
				employee.getSalary());*/
		MapSqlParameterSource parameterSource=new MapSqlParameterSource();
		parameterSource.addValue("email", employee.getEmail());
		parameterSource.addValue("employeeName", employee.getEmployeeName());
		parameterSource.addValue("gender", employee.getGender());
		parameterSource.addValue("salary", employee.getSalary());
		
		int update = getNamedParameterJdbcTemplate().update(SQL, parameterSource);
		
		if(update==1) {
			System.out.println("Employee is created...");
		}
	}

	public List<Employee> fetchEmployeeById(Integer employeeId) {
		String SQL= "SELECT * FROM employee_table WHERE employee_Id=:employeeId";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("employeeId", employeeId);
		return getNamedParameterJdbcTemplate().query(SQL, map, new EmployeeRowMapper());
	}

	public void deletedAccountById(Integer employeeId) {
		String SQL= "delete from employee_table where employee_Id=:employeeId"; 
		MapSqlParameterSource parameterSource=new MapSqlParameterSource("employeeId",employeeId);
		int update = getNamedParameterJdbcTemplate().update(SQL, parameterSource);
		if(update == 1) {
			System.out.println("Employee details is Deleted...");
		}
	}

	public void updateEmailById(Integer employeeId, String email) {
		String SQL="UPDATE employee_table SET email=:newEmail where employee_Id=:employeeId";
		MapSqlParameterSource parameterSource=new MapSqlParameterSource("employeeId",employeeId);
		parameterSource.addValue("newEmail", email);
		int update = getNamedParameterJdbcTemplate().update(SQL, parameterSource);
		if(update == 1) {
			System.out.println("Email is Updated...");
		}
	}

	public List<Employee> allEmployeeDetails() {
		String SQL="SELECT * FROM employee_table";
		return getNamedParameterJdbcTemplate().query(SQL,new EmployeeRowMapper());
	}

}
