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
import org.springframework.web.servlet.ModelAndView;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Contract;
import com.safwan.data.model.Employee;
import com.safwan.data.model.PartyMaster;
import com.safwan.services.service.ContractService;
import com.safwan.services.service.EmployeeService;
import com.safwan.services.service.PartyService;
import com.safwan.web.converter.DateEditor;
import com.safwan.web.converter.EmployeeEditor;
import com.safwan.web.converter.PartyEditor;
import com.safwan.web.excelview.ContractExcelView;

@Controller
@RequestMapping
public class ContractController {
	
	@Autowired
	ContractService contractService;

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

	@RequestMapping(value = "/listContract", method = RequestMethod.GET)
	public String listContracts(Model model) {
		Set<Contract> listContract = contractService.listAllContracts();
		model.addAttribute("listContract", listContract);
		return "contract/listContract";
	}

	@GetMapping("/addContract")
	public String contractForm(Model model) {
		model.addAttribute("contract", new Contract());
		model.addAttribute("employees", employeeService.listAllEmployees());
		model.addAttribute("parties", partyService.listAllParties());
		return "contract/contractForm";
	}

	/*
	 * Save user object
	 */
	@RequestMapping(value = "/saveContract", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("contract") @Validated Contract contract, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "contract/contractForm";
		}
		contractService.saveOrUpdate(contract);
		return "redirect:/listContract";
	}
	
	@RequestMapping(value = "/updateContract/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") Long id, @ModelAttribute("contract") Contract contract, Model model) {
		contract = contractService.findContractById(id);
		model.addAttribute("contract", contract);
		model.addAttribute("employees", employeeService.listAllEmployees());
		model.addAttribute("parties", partyService.listAllParties());
		return "contract/contractForm";
	}

	@RequestMapping(value = "/deleteContract/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		try {
			contractService.deleteContract(id);
		} catch (CustomException cge) {
			throw cge;
		}
		return "redirect:/listContract";
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		Set<Contract> listContract = contractService.listAllContracts();
		return new ModelAndView(new ContractExcelView(), "contractList", listContract);
	}


}	
