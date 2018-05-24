package com.safwan.web.controller;

import java.sql.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Employee;
import com.safwan.services.service.EmployeeService;
import com.safwan.web.converter.DateEditor;
import com.safwan.web.validator.EmployeeValidator;

@Controller
@RequestMapping
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DateEditor dateEditor;
	
	@Autowired
	EmployeeValidator employeeValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, this.dateEditor);
		binder.setValidator(employeeValidator);
	}

	@GetMapping("/addEmployee")
	public String employeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/employeeForm";
	}
	
	@RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		Set<Employee> listEmployee = employeeService.listAllEmployees();
		model.addAttribute("listEmployee", listEmployee);
		return "employee/listEmployee";
	}
	
	@RequestMapping (value="/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") 
								@Validated Employee employee, 
								BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "employee/employeeForm";
		}
		employeeService.saveOrUpdate(employee);
		return "redirect:/listEmployee";
	}
	
	/*@ModelAttribute("employeeList")
	public Set<Employee> employeeList() {
		Set<Employee> listEmployee = employeeService.listAllEmployees();
		return listEmployee;
	}*/
	
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") Long id, @ModelAttribute("employee") Employee emp, Model model) {
		emp = employeeService.findEmployeeById(id);
		model.addAttribute("employee", emp);
		return "employee/employeeForm";
	}

	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		try {
			employeeService.deleteEmployee(id);
		} catch (CustomException cge) {
			throw cge;
		}
		return "redirect:/listEmployee";
	}
}
