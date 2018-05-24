package com.safwan.web.converter;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateEditor extends PropertyEditorSupport 

{
	@Override
    public void setAsText(String value) 
    {
		DateFormat formatter = null; 
		 Date convertedDate = null; 
		try {
            
			formatter = new SimpleDateFormat("dd-MM-yyyy"); 
			convertedDate = (Date) formatter.parse(value); 
			java.sql.Date sqlDate = new java.sql.Date(convertedDate.getTime());
			setValue(sqlDate);
        } catch(ParseException e) {
        	setValue(null);
        }
    }
	
	public String getAsText() {
		if (getValue() != null) {
			return new SimpleDateFormat("dd-MM-yyyy").format((Date) getValue());
		} else {
			return "";
		}
    }  

}
