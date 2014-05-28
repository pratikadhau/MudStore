package com.mudstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mudstore.model.Credential;
import com.mudstore.model.User;

@Controller
public class SignUpController {


	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView goToSignUp(){
		User user = new User();
		ModelAndView modelAndView = new ModelAndView("SignUp","user",user);
		modelAndView.addObject("credential", new Credential());
		return modelAndView;
	}
	
	@RequestMapping(value="/doSignUp",method=RequestMethod.POST)
	public ModelAndView doSignUp(@ModelAttribute("credential")Credential credential,@ModelAttribute("user")User user){
		credential.setPassword("");
		ModelAndView modelAndView = new ModelAndView("Login", "credential",
				credential);
		modelAndView.addObject("successFlag", true);
		return modelAndView;
	}
}
