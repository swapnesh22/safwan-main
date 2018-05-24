package com.safwan.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.safwan.data.model.SubCategory;
import com.safwan.services.service.CategoryService;
////////////////NOT IN USE
@Component
public class CategoryConverter implements Converter<String, SubCategory> {
	
	@Autowired
	CategoryService service;

	public SubCategory convert(String source) {
		System.out.println("INSIDE CONVERTER =====================>>>>>>>>>>>>>>");
		SubCategory category = service.findByCategoryMasterId(Integer.valueOf(source));
    	return category;
	}
}
