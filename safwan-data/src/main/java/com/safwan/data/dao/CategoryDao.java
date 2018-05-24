package com.safwan.data.dao;

import java.util.List;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Category;
import com.safwan.data.model.SubCategory;
import com.safwan.data.model.User;

public interface CategoryDao {
	
	public void saveOrUpdate(Category category);
	
	public void saveOrUpdate(SubCategory categoryM);
	
	public Category findCategoryById(int categoryId);
	
	public void deleteCategory(int id) throws CustomException;
	
	public List<Category> listAllCategories();
	
	public List<SubCategory> listCategories(int categoryType);//Category
	
	public SubCategory findByCategoryMasterId(int id);
	
	public List<SubCategory> listAllSubCategories();
	
	public void deleteSubCategory(int id);
}
