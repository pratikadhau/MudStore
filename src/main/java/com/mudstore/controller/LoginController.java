package com.mudstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mudstore.exception.InvalidCredential;
import com.mudstore.model.Credential;
import com.mudstore.model.Product;
import com.mudstore.model.User;
import com.mudstore.service.LoginService;
import com.mudstore.service.ProductService;
import com.mudstore.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		Credential credential = new Credential();
		ModelAndView modelAndView = new ModelAndView("Login", "credential",
				credential);
		modelAndView.addObject("errorMessage", "");
		return modelAndView;
	}

	@RequestMapping(value = { "/verifyCredential" }, method = RequestMethod.POST)
	public ModelAndView login(
			@ModelAttribute("credential") Credential credential) {
		try {
			Credential loginUserCredential = loginService.login(credential);
			User user = userService.getUserByUserName(loginUserCredential);
			ModelAndView modelAndView = new ModelAndView("Home", "user", user);
			List<Product> products = productService.getAllProducts();
			modelAndView.addObject("products", products);
			return modelAndView;
		} catch (InvalidCredential invalidCredential) {
			ModelAndView modelAndView = new ModelAndView("Login", "credential",
					credential);
			modelAndView.addObject("errorMessage",
					invalidCredential.getMessage());
			return modelAndView;
		}
	}
}
