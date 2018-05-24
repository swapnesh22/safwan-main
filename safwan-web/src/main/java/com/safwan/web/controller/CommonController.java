package com.safwan.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Category;
import com.safwan.data.model.PartyMaster;
import com.safwan.data.model.SamplePost;
import com.safwan.data.model.SamplePostComment;
import com.safwan.data.model.SubCategory;
import com.safwan.services.service.CategoryService;
import com.safwan.services.service.SamplePostService;
import com.safwan.web.converter.CategoryEditor;

@Controller
public class CommonController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryEditor categoryEditor;
	
	@Autowired
	SamplePostService samplePostService;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, this.categoryEditor);
	}
	
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") Category category) {
		categoryService.saveOrUpdate(category);
		return "redirect:/addCategory";
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String addCategory(Model model) {
		
		List<Category> listCategory = categoryService.listAllCategories();
		model.addAttribute("listCategory", listCategory);
		
		model.addAttribute("category", new Category());
		return "category/categoryForm";
	}
	
	@RequestMapping(value = "/addCategoryMaster", method = RequestMethod.GET)
	public String addCategoryMasterForm(Model model) {
		
		List<SubCategory> listSubCategory = categoryService.listAllSubCategories();
		model.addAttribute("listSubCategory", listSubCategory);
		
		model.addAttribute("categorym", new SubCategory());
		model.addAttribute("categories", categoryService.listAllCategories());
		return "category/categoryMasterForm";
	}
	
	@RequestMapping(value = "/saveCategoryMaster", method = RequestMethod.POST)
	public String saveCategoryMaster(@ModelAttribute("categorym") SubCategory categoryM) {
		categoryService.saveOrUpdate(categoryM);
		return "redirect:/addCategoryMaster";
	}
	
	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") int id) {
		try {
			categoryService.deleteCategory(id);
		} catch (CustomException cge) {
			throw cge;
		}
		return "redirect:/addCategory";
	}
	
	@RequestMapping(value = "/deleteSubCategory/{id}", method = RequestMethod.GET)
	public String deleteSubCategory(@PathVariable("id") int id) {
		try {
			categoryService.deleteSubCategory(id);
		} catch (CustomException cge) {
			throw cge;
		}
		return "redirect:/addCategoryMaster";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/addPost", method = RequestMethod.GET)
	public String addPost(Model model) {
		SamplePost post = samplePostService.findPostById(new Long(129));
		if (post == null) {
			post = new SamplePost();
		}
		model.addAttribute("post", post);
		System.out.println("Size of object ==============>>>>>>>>>>> "+post.getComments().size());
		for (SamplePostComment comment : post.getComments()) {
			System.out.println("Size of object "+comment.getReview());
		}
		
		model.addAttribute("listPostComment", post.getComments());
		return "post/postForm";
	}
	
	@RequestMapping(value = "/saveComment", method = RequestMethod.POST)
	public String update(@ModelAttribute ("post") SamplePost post, Model model) {
		
		System.out.println("ID is "+post.getId());
		
		for (SamplePostComment comment : post.getComments()) {
			System.out.println(comment.getId());
			System.out.println(comment.getReview());
		}
		
		model.addAttribute("post", post);
		return "post/postForm";
	}
}
