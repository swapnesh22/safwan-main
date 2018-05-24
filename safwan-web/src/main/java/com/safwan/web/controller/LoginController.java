package com.safwan.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.safwan.data.model.User;
import com.safwan.services.service.UserService;

@Controller
@RequestMapping
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserService userService;
	
	/*@RequestMapping(value="/")
	protected String displayLogin(Model model) throws Exception {
		model.addAttribute("user", new User());
		return "welcome";
	}*/
	@RequestMapping(value="/")
	protected String displayLogin() throws Exception {
		return "welcome";
	}

	/*
	 * Add user in model attribute
	 */
	@ModelAttribute("user")
	public User setUpUserForm() {
		return new User();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("user") User user, Model model) {
		boolean isValid = false;
		String redirection;
		isValid = userService.validateLogin(user);

		if (isValid) {
			// model.addAttribute("user", user);
			// model.addAttribute("customer", new Customer());
			// redirection = "redirect:/addCustomer";
			user = getUserDetails(user);
			model.addAttribute("user", user);
			redirection = "redirect:/home";
		} else {
			redirection = "welcome";
		}

		return redirection;
	}

	private User getUserDetails(User user) {
		user = userService.getUserDetails(user);
		return user;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/forgetPassword")
	public String forgetPassForm(Model model) {
		model.addAttribute("user", new User());
		return "resetform";
	}
}
