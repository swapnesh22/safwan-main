package com.safwan.web.controller;

import java.sql.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Calllog;
import com.safwan.data.model.Employee;
import com.safwan.data.model.PartyMaster;
import com.safwan.data.model.User;
import com.safwan.services.service.CalllogService;
import com.safwan.services.service.ContractService;
import com.safwan.services.service.EmployeeService;
import com.safwan.services.service.PartyService;
import com.safwan.web.converter.DateEditor;
import com.safwan.web.converter.EmployeeEditor;
import com.safwan.web.converter.PartyEditor;

@Controller
@RequestMapping
public class CalllogController {
	
	@Autowired
	ContractService contractService;
	
	@Autowired
	CalllogService calllogService;

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	PartyService partyService;
	
	@Autowired
	PartyEditor partyEditor;
	
	@Autowired
	EmployeeEditor employeeEditor;
	
	@Autowired
	DateEditor dateEditor;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(PartyMaster.class, this.partyEditor);
		binder.registerCustomEditor(Employee.class, this.employeeEditor);
		binder.registerCustomEditor(Date.class, this.dateEditor);
	}

	@RequestMapping(value = "/listCall", method = RequestMethod.GET)
	public String listCalls(Model model) throws CustomException {
		String redirection;
		Set<Calllog> listCall = calllogService.listAllCalllogs();
		if (listCall != null && listCall.size() > 0) {
			redirection ="calllog/listCalllog";
			model.addAttribute("listCall", listCall);
		} else {
			redirection = "redirect:/addCall";
		}
		
		return redirection;
	}

	@GetMapping("/addCall")
	public String callForm(Model model) {
		model.addAttribute("call", new Calllog());
		model.addAttribute("employees", employeeService.listAllEmployees());
		model.addAttribute("parties", partyService.listAllParties());
		model.addAttribute("contracts", contractService.listAllContracts());
		return "calllog/calllogForm";
	}

	/*
	 * Save user object
	 */
	@RequestMapping(value = "/saveCall", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("call") @Validated Calllog call, 
			BindingResult result, Model model) {
		/*if (result.hasErrors()) {
			return "calllog/calllogForm";
		}*/
		calllogService.saveOrUpdate(call);
		return "redirect:/listCall";
	}
	
	@RequestMapping(value = "/updateCall/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") Long id, @ModelAttribute("call") Calllog call, Model model) {
		call = calllogService.findCalllogById(id);
		model.addAttribute("call", call);
		model.addAttribute("employees", employeeService.listAllEmployees());
		model.addAttribute("parties", partyService.listAllParties());
		model.addAttribute("contracts", contractService.listAllContracts());
		return "calllog/calllogForm";
	}

	@RequestMapping(value = "/deleteCall/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		try {
			calllogService.deleteCalllog(id);
		} catch (CustomException cge) {
			throw cge;
		}
		return "redirect:/listCall";
	}
	
	@RequestMapping(value = "/listAssignedCall", method = RequestMethod.GET)
	public String listAssignedCalls(@SessionAttribute ("user") User user, Model model) {
		Set<Calllog> listAssignedCall = calllogService.listCalllogByUser(user);
		model.addAttribute("listCall", listAssignedCall);
		return "calllog/listCalllog";
	}
	
	/*@ExceptionHandler(CustomException.class)
	public ModelAndView handleAllException(CustomException ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", ex.getMessage());

		return model;

	}*/
	
	
	@ExceptionHandler({CustomException.class})
    public ModelAndView handleSQLException(CustomException ex) {
		ModelAndView model = new ModelAndView("calllog/listCalllog");
		model.addObject("exception", ex);
		Set<Calllog> listCall = calllogService.listAllCalllogs();
		model.addObject("listCall", listCall);
        return model;
    }


}	
