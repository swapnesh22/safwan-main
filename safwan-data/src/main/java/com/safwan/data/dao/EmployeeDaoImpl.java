package com.safwan.data.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safwan.data.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public Set<Employee> listAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		Set<Employee> employees = new HashSet<Employee>();
		employees.addAll(criteria.list());
		return employees;
	}

	public void saveOrUpdate(Employee employee) {
		getSession().saveOrUpdate(employee);		
	}

	public Employee findEmployeeById(Long id) {
		Employee employee = (Employee) getSession().get(Employee.class, id);
		return employee;
	}

	public void deleteEmployee(Long id) {
		Employee employee = (Employee) getSession().get(Employee.class, id);
		getSession().delete(employee);
	}

	

}
