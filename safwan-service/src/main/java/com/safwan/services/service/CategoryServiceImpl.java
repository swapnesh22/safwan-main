package com.safwan.services.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safwan.data.dao.CategoryDao;
import com.safwan.data.model.Category;
import com.safwan.data.model.SubCategory;
import com.safwan.data.model.PartyMaster;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	CategoryDao categoryDao;
		
	@Autowired
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> listAllCategories() {
		return categoryDao.listAllCategories();
	}

	public void saveOrUpdate(Category category) {
		categoryDao.saveOrUpdate(category);
	}

	public Category findCategoryById(int id) {
		return categoryDao.findCategoryById(id);
	}

	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);
	}

	public void saveOrUpdate(SubCategory categoryM) {
		categoryDao.saveOrUpdate(categoryM);
	}

	public List<SubCategory> listCategories(int categoryType) {
		return categoryDao.listCategories(categoryType);
	}

	public SubCategory findByCategoryMasterId(int id) {
		return categoryDao.findByCategoryMasterId(id);
	}

	public List<SubCategory> listAllSubCategories() {
		return categoryDao.listAllSubCategories();
	}

	public void deleteSubCategory(int id) {
		categoryDao.deleteSubCategory(id);
	}
}
