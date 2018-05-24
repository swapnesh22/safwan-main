package com.safwan.services.service;

import java.util.List;

import com.safwan.data.model.Category;
import com.safwan.data.model.SubCategory;

public interface CategoryService {
	
	public List<Category> listAllCategories();
	
	public void saveOrUpdate(Category category);
	
	public void saveOrUpdate(SubCategory categoryM);
	
	public Category findCategoryById(int id);
	
	public void deleteCategory(int id);
	
	public List<SubCategory> listCategories(int categoryType);
	
	public SubCategory findByCategoryMasterId(int id);
	
	public List<SubCategory> listAllSubCategories();
	
	public void deleteSubCategory(int id);
}
