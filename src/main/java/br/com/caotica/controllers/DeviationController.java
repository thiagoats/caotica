package br.com.caotica.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Deviation controller class
 * @author Thiago Pinheiro do Nascimento
 * @since 13 mar 2025
**/
@Controller
public class DeviationController implements ErrorController {

	/**
	 * Redirect method for error page views
	 * @author Thiago Pinheiro do Nascimento
	 * @since 13 mar 2025
	**/
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if(statusCode == HttpStatus.BAD_REQUEST.value())
				return "errors/400";
			else if (statusCode == HttpStatus.FORBIDDEN.value())
				return "errors/403";
			else if (statusCode == HttpStatus.NOT_FOUND.value())
				return "errors/404";
			else if (statusCode == HttpStatus.CONFLICT.value())
				return "errors/409";
			else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value())
				return "errors/500";
		}
		return "errors/500";
	}
}