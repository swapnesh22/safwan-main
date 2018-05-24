package com.safwan.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Employee;
import com.safwan.data.model.User;
import com.safwan.services.service.EmployeeService;
import com.safwan.services.service.UserService;
import com.safwan.web.converter.EmployeeEditor;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeEditor employeeEditor;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Employee.class, this.employeeEditor);
    }
	
	/*@GetMapping("/getUserDetails")
	public User getUserDetails(User user) {
		user = userService.getUserDetails(user);
		return user;
	}*/
	
	@GetMapping("/addUser")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("employees", employeeService.listAllEmployees());
		return "userform";
	}
		
	
	@GetMapping("/home")
	public String loadHome(@SessionAttribute("user") User user, Model model) {
		//user = getUserDetails(user);
		//model.addAttribute("user", user);
		return "home";
	}
	
	/*@GetMapping("/goToHome")
	public String goToHome(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "redirect:/home";
	}*/
	@GetMapping("/goToHome")
	public String goToHome() {
		return "redirect:/home";
	}
	
	/*@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("user") User user, Model model) {
		userService.saveOrUpdate(user);
		return "redirect:/listUser";
	}*/
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("user") User user, Model model) {
		userService.saveOrUpdate(user);
		return "success";
	}
	
	@ModelAttribute("userTypeList")
	public List<String> typeList() {
		List<String> typeList = new ArrayList<String>();
		typeList.add("Admin");
		typeList.add("User");
		return typeList;
	}
	
	/*@RequestMapping(value = "/listUser", method = RequestMethod.GET)
	public String listUser(@SessionAttribute("user") User user, Model model) {
		List<User> listUser = userService.listAllUsers();
		model.addAttribute("listUser", listUser);
		return "listuser";
	}*/
	@RequestMapping(value = "/listUser", method = RequestMethod.GET)
	public String listUser(Model model) {
		List<User> listUser = userService.listAllUsers();
		model.addAttribute("listUser", listUser);
		return "listuser";
	}
	
	@ExceptionHandler({CustomException.class})
    public ModelAndView handleSQLException(CustomException ex) {
		ModelAndView model = new ModelAndView("/listUser");
		model.addObject("exception", ex);
		model.addObject("listUser", listUsers());
        return model;
    }
	
	@ModelAttribute("listUser")
	public List<User> listUsers() {
		List<User> listUser = userService.listAllUsers();
		return listUser;
	}
	
	/*@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") int id, @ModelAttribute("user") User user, Model model) {
		user = userService.findUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("employees", employeeService.listAllEmployees());
		return "userform";
	}*/
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") int id, @SessionAttribute("user") User user, Model model) {
		user = userService.findUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("employees", employeeService.listAllEmployees());
		return "userform";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		try {
			userService.deleteUser(id);
		} catch (CustomException cge) {
			throw cge;
		}
		return "redirect:/listUser";
	}
	
	/*@ModelAttribute("employeeList")
	public Set<Employee> employeeList() {
		Set<Employee> listEmployee = employeeService.listAllEmployees();
		return listEmployee;
	}*/

}
