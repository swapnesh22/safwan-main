package com.safwan.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.safwan.data.exception.CustomException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex) {
		ModelAndView model = new ModelAndView("duplicate", "msg", ex.getMessage());
		return model;
	}
}
