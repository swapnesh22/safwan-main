package com.safwan.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safwan.data.exception.CustomException;
import com.safwan.data.model.Category;
import com.safwan.data.model.SubCategory;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	public static final String SALT = "SAF_PASS_WAN_WORD";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(Category category) {
		getSession().saveOrUpdate(category);
	}

	public Category findCategoryById(int categoryId) {
		Category category = (Category)getSession().get(Category.class, categoryId);
		return category;
	}

	public void deleteCategory(int id) throws CustomException {
		Category category = (Category)getSession().get(Category.class, id);
		getSession().delete(category);
	}

	public List<Category> listAllCategories() {
		Criteria criteria = getSession().createCriteria(Category.class);
		return criteria.list();
	}

	public void saveOrUpdate(SubCategory categoryM) {
		getSession().saveOrUpdate(categoryM);
	}

	public List<SubCategory> listCategories(int categoryType) {
		Criteria criteria = getSession().createCriteria(SubCategory.class)
				.add(Restrictions.like("category.categoryid", categoryType));
		return criteria.list();
	}

	public SubCategory findByCategoryMasterId(int id) {
		SubCategory category = (SubCategory)getSession().get(SubCategory.class, id);
		return category;
	}
	
	public List<SubCategory> listAllSubCategories() {
		Criteria criteria = getSession().createCriteria(SubCategory.class);
		return criteria.list();
	}
	
	public void deleteSubCategory(int id) throws CustomException {
		SubCategory category = (SubCategory)getSession().get(SubCategory.class, id);
		getSession().delete(category);
	}

	
}
