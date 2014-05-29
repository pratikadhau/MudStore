package com.mudstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mudstore.model.Product;

@Controller
public class ProductControllerRestConsumer {

	@RequestMapping("product/restop/{id}")
	public ModelAndView getProduct(@PathVariable("id")Integer id){
		RestTemplate  restTemplate=new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/MudStore/rest/product/"+id, Product.class);
		ModelAndView modelAndView = new ModelAndView("Product","product",product);
		return modelAndView;
	}
}
