package com.safwan.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.safwan.data.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	 public boolean supports(Class<?> paramClass) {
        return Employee.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "employee.firstname.empty");//validation.properties - valid.name=Please enter User Name
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "employee.lastname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "employee.address.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "employee.email.empty");
        ValidationUtils.rejectIfEmpty(errors, "dob", "employee.dob.empty");
        ValidationUtils.rejectIfEmpty(errors, "doj", "employee.doj.empty");
        ValidationUtils.rejectIfEmpty(errors, "contactphone", "employee.phone.empty");
        ValidationUtils.rejectIfEmpty(errors, "cellphone", "employee.mobile.empty");
    }
}  

