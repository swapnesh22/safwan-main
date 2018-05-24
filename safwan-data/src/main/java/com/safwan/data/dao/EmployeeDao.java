package com.safwan.data.dao;

import java.util.Set;

import com.safwan.data.model.Employee;

public interface EmployeeDao {
	
	public Set<Employee> listAllEmployees();
	
	public void saveOrUpdate(Employee employee);
	
	public Employee findEmployeeById(Long id);
	
	public void deleteEmployee(Long id);
}
