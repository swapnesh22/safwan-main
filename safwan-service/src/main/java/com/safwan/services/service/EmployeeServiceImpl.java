package com.safwan.services.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safwan.data.dao.EmployeeDao;
import com.safwan.data.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao;
		
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Set<Employee> listAllEmployees() {
		return employeeDao.listAllEmployees();
	}

	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}

	public Employee findEmployeeById(Long id) {
		return employeeDao.findEmployeeById(id);
	}

	public void deleteEmployee(Long id) {
		employeeDao.deleteEmployee(id);
	}
	
	
}
