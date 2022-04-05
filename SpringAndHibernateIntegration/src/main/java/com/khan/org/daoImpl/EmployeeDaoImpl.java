package com.khan.org.daoImpl;

import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.khan.org.dao.EmployeeDao;
import com.khan.org.maper.EmployeeRowMapper;
import com.khan.org.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void createEmployee(Employee employee) {

		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Integer employeeId = (Integer) session.save(employee);
		session.getTransaction().commit();
		if (employeeId > 0) {
			System.out.println("Employee is created with Id = " + employeeId);
		}
	}

	public Employee fetchEmployeeById(Integer employeeId) {
		Session session = getSessionFactory().openSession();
		Employee employee = session.get(Employee.class, employeeId);
		return employee;
	}

	public void deletedAccountById(Integer employeeId) {
		Session session = getSessionFactory().openSession();
		Employee employee = session.get(Employee.class, employeeId);
		if (Objects.nonNull(employee)) {
			session.remove(employee);
			session.beginTransaction();
			session.getTransaction().commit();
			System.out.println("Employee is Deleted with Id = " + employeeId);
		}
	}

	public void updateEmailById(Integer employeeId, String email) {
		Session session = getSessionFactory().openSession();
		Employee employee = session.get(Employee.class, employeeId);
		if (Objects.nonNull(employee)) {
			employee.setEmail(email);
			session.beginTransaction();
			session.getTransaction().commit();
			System.out.println("Employee New Email is Updated...");

		}
	}

	public List<Employee> allEmployeeDetails() {
		Session session = getSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		CriteriaQuery<Employee> criteriaQuery2 = criteriaQuery.select(root);
		Query<Employee> query = session.createQuery(criteriaQuery2);
		List<Employee> employees= query.getResultList();
		return employees;
	}

}
