package com.utict.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	
	public static final String INTERNAL_SERVER_ERROR_VIEW="error/paginaError";

	@ExceptionHandler(Exception.class)
	public String showInternalServerError(Exception ex, Model model) {
        System.out.println("[ErrorController.showInternalServerError()] "+ex.getMessage());
        model.addAttribute("msjError", ex.getMessage());
		return INTERNAL_SERVER_ERROR_VIEW;
	}
}
