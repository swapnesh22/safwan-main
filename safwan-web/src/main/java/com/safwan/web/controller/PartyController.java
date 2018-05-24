package com.safwan.web.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.safwan.data.model.SubCategory;
import com.safwan.data.model.PartyMaster;
import com.safwan.services.service.CategoryService;
import com.safwan.services.service.PartyService;
import com.safwan.web.converter.CategoryMasterEditor;

@Controller
public class PartyController {
	
	private static final int CATEGORY_TYPE_PARTY = 1;

	//@Autowired
	//private CustomerValidator customerValidator;
	
	@Autowired
	PartyService partyService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryMasterEditor categoryMasterEditor;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//binder.setValidator(customerValidator);
		binder.registerCustomEditor(SubCategory.class, this.categoryMasterEditor);
	}
	

	 /*@Autowired 
	 private ConversionService conversionService; 
	 
	 @InitBinder 
	 protected void initBinder(ServletRequestDataBinder binder) { 
		 binder.setConversionService(conversionService); 
	 } */


	@RequestMapping(value = "/listParty", method = RequestMethod.GET)
	public String listParties(Model model) {
		List<PartyMaster> listParty = partyService.listAllParties();
		model.addAttribute("listParty", listParty);
		return "party/listParty";
	}

	@GetMapping("/addParty")
	public String partyForm(Model model) {
		model.addAttribute("party", new PartyMaster());
		model.addAttribute("partytypes", categoryService.listCategories(CATEGORY_TYPE_PARTY));
		
		return "party/partyForm";
	}

	/*
	 * Save user object
	 */
	// @PostMapping("/saveParty")
	@RequestMapping(value = "/saveParty", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("party") @Validated PartyMaster party, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "party/partyForm";
		}
		partyService.saveOrUpdate(party);
		// return "success";//Send to success page with employee details only
		return "redirect:/listParty";
	}
	
	@RequestMapping(value = "/updateParty/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") Long id, @ModelAttribute("party") PartyMaster party, Model model) {
		party = partyService.findPartyById(id);
		model.addAttribute("party", party);
		model.addAttribute("partytypes", categoryService.listCategories(CATEGORY_TYPE_PARTY));
		return "party/partyForm";
	}

	@RequestMapping(value = "/deleteParty/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		try {
			partyService.deleteParty(id);
		} catch (CustomException cge) {
			throw cge;
		}
		return "redirect:/listParty";
	}

	@ModelAttribute("typeList")
	public List<String> typeList() {
		List<String> typeList = new ArrayList<String>();
		typeList.add("Admin");
		typeList.add("App User");
		typeList.add("Super");
		typeList.add("User");
		return typeList;
	}

}
