package com.safwan.web.converter;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safwan.data.model.Employee;
import com.safwan.services.service.EmployeeService;

@Component
public class EmployeeEditor extends PropertyEditorSupport 

{
	@Autowired
	EmployeeService employeeService;
    //This will be called when user HTTP Post to server a field bound to DepartmentVO

    @Override
    public void setAsText(String id) 
    {
    	
    	Employee emp = employeeService.findEmployeeById(Long.valueOf(id));
        this.setValue(emp);
    }

}
