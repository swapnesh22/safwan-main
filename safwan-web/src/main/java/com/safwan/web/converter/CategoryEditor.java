package com.safwan.web.converter;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safwan.data.model.Category;
import com.safwan.services.service.CategoryService;

@Component
public class CategoryEditor extends PropertyEditorSupport 

{
	@Autowired
	CategoryService categoryService;
    //This will be called when user HTTP Post to server a field bound to DepartmentVO

    @Override
    public void setAsText(String id) 
    {
    	
    	Category category = categoryService.findCategoryById(Integer.valueOf(id));
        this.setValue(category);
    }

}
