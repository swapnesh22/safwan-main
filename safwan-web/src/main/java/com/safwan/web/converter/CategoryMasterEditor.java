package com.safwan.web.converter;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safwan.data.model.SubCategory;
import com.safwan.services.service.CategoryService;

@Component
public class CategoryMasterEditor extends PropertyEditorSupport 

{
	@Autowired
	CategoryService categoryService;
    //This will be called when user HTTP Post to server a field bound to DepartmentVO

    @Override
    public void setAsText(String id) 
    {
    	SubCategory category = categoryService.findByCategoryMasterId(Integer.valueOf(id));
    	this.setValue(category);
    }
    
    public String getAsText() {
		if (getValue() != null) {
			SubCategory cat = (SubCategory) getValue();
			return cat.getSubcategorydesc();
		} else {
			return "";
		}
    }

}
