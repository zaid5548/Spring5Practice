package com.khan.org.daoImpl;

import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.khan.org.dao.EmployeeDao;
import com.khan.org.maper.EmployeeRowMapper;
import com.khan.org.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void createEmployee(Employee employee) {

		Integer employeeId = (Integer)getHibernateTemplate().save(employee);
		if (employeeId > 0) {
			System.out.println("Employee is created with Id = " + employeeId);
		}		
	}

	public Employee fetchEmployeeById(Integer employeeId) {
		Employee employee=getHibernateTemplate().get(Employee.class, employeeId);
		return employee;
	}

	public void deletedAccountById(Integer employeeId) {
		Employee employee=getHibernateTemplate().get(Employee.class, employeeId);
		if(Objects.nonNull(employee)) {
			getHibernateTemplate().delete(employee);
			System.out.println("Employee is Deleted with Id = " + employeeId);
		}
	}

	public void updateEmailById(Integer employeeId, String email) {
		Employee employee=getHibernateTemplate().get(Employee.class, employeeId);
		if(Objects.nonNull(employee)) {
			employee.setEmail(email);
			getHibernateTemplate().update(employee);
			System.out.println("Employee New Email is Updated with Id = " + employeeId);
		}
	}

	public List<Employee> allEmployeeDetails() {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Employee.class);
		List<Employee> emList= (List<Employee>) getHibernateTemplate().findByCriteria(detachedCriteria);
		return emList;
	}

}
