package com.mudstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mudstore.model.Credential;
import com.mudstore.model.Product;
import com.mudstore.model.User;
import com.mudstore.service.ProductService;
import com.mudstore.service.UserLoginService;
import com.mudstore.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		Credential credential = new Credential();
		ModelAndView modelAndView = new ModelAndView("Login", "credential",
				credential);
		modelAndView.addObject("successFlag", true);
		return modelAndView;
	}

	@RequestMapping(value = { "/doLogin" }, method = RequestMethod.POST)
	public ModelAndView login(
			@ModelAttribute("credential") Credential credential) {
		Boolean successful = userLoginService.isValid(credential);
		if (successful) {
			User user = userService.getUserByUserName(credential.getUsername());
			ModelAndView modelAndView = new ModelAndView("Home", "user", user);
			List<Product> products = productService.getAllProducts();
			modelAndView.addObject("products", products);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("Login", "credential",
					credential);
			modelAndView.addObject("successFlag", false);
			return modelAndView;
		}
	}
}
